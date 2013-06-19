/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author arjandoets
 */
public class Speelveld extends javax.swing.JPanel implements KeyListener, SpelerListener{

    /**
     * Creates new form MainWindow
     */
    
    public Vakje startvakje;
    public Vakje vakje;
    public static int vakjessize = 30;
    Timer timer;
    Speler speler;
    //tmp
    boolean showpath = false;
    
    public Speelveld() {
        initComponents();
        
    }

    public void startlevel(){
        speler = (Speler)startvakje.bevat;
        speler.listeners.add((SpelerListener)this);
        this.requestFocusInWindow();
        this.addKeyListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D) g;      
 
        g2D.setStroke(new BasicStroke(Speelveld.vakjessize / 10));  
        
        g2D.setColor(Color.black);
        
        if (startvakje != null){            
            if (showpath){
                PathFinder route = new PathFinder();
                speler.huidigvakje.findroute(route);
                route.use();
            }
            startvakje.draw(g2D, 0, 0);
            startvakje.done();
        }
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                speler.beweeg(Direction.UP);
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                speler.beweeg(Direction.RIGHT);
                repaint();
                break;
            case KeyEvent.VK_DOWN:
                speler.beweeg(Direction.DOWN);
                repaint();
                break;
            case KeyEvent.VK_LEFT:
                speler.beweeg(Direction.LEFT);
                repaint();
                break;
            case KeyEvent.VK_F:
                if(showpath){
                    showpath = false;
                } else {
                    showpath = true;
                }
                
                repaint();
                break; 
            case KeyEvent.VK_B:
                speler.inventory.add(new Bazooka());
                repaint();
                break; 
                
            case KeyEvent.VK_U:
            speler.gebruikitem();
            repaint();
            break; 
            //Depth-first search
            case KeyEvent.VK_1:
                Speler rememberspeler = speler;
                startvakje = MazeGenerator.mazegen(this.getHeight(), this.getWidth());
                startvakje.setSpeler(rememberspeler);
                showpath = false;
                PathFinder route = new PathFinder();
                speler.huidigvakje.findroute(route);
                speler.setScore(route.shortestfound.size());
                repaint();
            break;
            //Aldous-Broder algorithm
            case KeyEvent.VK_2:
                Speler rememberspeler2 = speler;
                startvakje = MazeGenerator.mazegen2(this.getHeight(), this.getWidth());
                startvakje.setSpeler(rememberspeler2);
                showpath = false;
                PathFinder route2 = new PathFinder();
                speler.huidigvakje.findroute(route2);
                speler.setScore(route2.shortestfound.size());
                repaint();
            break;
            case KeyEvent.VK_T:
                int testammount = 250;
                int size = 2000;
                System.out.println("Depth-first search");
                Long avg = (long)0;
                for (int i = 0; i < testammount; i++) {
                    long start = System.currentTimeMillis();
                    MazeGenerator.mazegen(size, size);
                    avg += (System.currentTimeMillis() - start);
                }
                System.out.println(avg / testammount);
                
                System.out.println("Aldous-Broder algorithm");
                avg = (long)0;
                for (int i = 0; i < testammount; i++) {
                    long start = System.currentTimeMillis();
                    MazeGenerator.mazegen2(size, size);
                    avg += (System.currentTimeMillis() - start);
                }
                System.out.println(avg / testammount);
                
            break;
        }        
    }

    
    
    public void redraw (){
        long start = System.currentTimeMillis();
        startvakje = MazeGenerator.mazegen(this.getHeight(), this.getWidth());
        speler = (Speler)startvakje.bevat;;
        repaint();
        System.out.println(System.currentTimeMillis() - start);
    }

    @Override
    public void keyReleased(KeyEvent e) {
             
    }

    @Override
    public void spelerEvent(EventType event) {
        if(event.equals(EventType.eindeLevel)){
            Speler rememberspeler = speler;
                startvakje = MazeGenerator.mazegen(this.getHeight(), this.getWidth());
                startvakje.setSpeler(rememberspeler);
                showpath = false;
                PathFinder route = new PathFinder();
                speler.huidigvakje.findroute(route);
                speler.addScore(route.shortestfound.size());
        }
        
        if(event.equals(EventType.showPath)){
            if(showpath){
                    showpath = false;
                } else {
                    showpath = true;
                    
                    // setting a timer for disabling the pathfinder after 5 seconds
                    Timer path = new Timer();
                    path.schedule(new TimerTask() {
                        public void run()  {
                           showpath = false;
                           repaint();
                        }
                    }, 5000);
                    }      
        }
    }
}
