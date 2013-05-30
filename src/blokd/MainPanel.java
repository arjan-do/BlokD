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
public class MainPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form MainWindow
     */
    
    public Vakje startvakje;
    public static int vakjessize = 15;
    Timer timer;

    Speler speler; 
    public MainPanel() {
        initComponents();
        
    }

    public void startlevel(){
        speler = (Speler)startvakje.speler;
        this.requestFocusInWindow();
        this.addKeyListener(this);
    }
    
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D) g;      
 
        g2D.setStroke(new BasicStroke(MainPanel.vakjessize / 10));  
        
        g2D.setColor(Color.black);
        
        if (startvakje != null){
            startvakje.draw(g2D, 0, 0);
            startvakje.Done();
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
            case KeyEvent.VK_R:
                
                if (timer == null){
                timer = new Timer();
                        
                timer.schedule(new TimerTask() {
                public void run()  {
                    redraw();
                }
                }, 10, 1500);
                }
                break;
                
                
            case KeyEvent.VK_S:
                timer.cancel();
                timer = null;
                break;
        }        
    }

    
    
    public void redraw (){
        long start = System.currentTimeMillis();
        startvakje = MazeGenerator.mazegen(this.getHeight(), this.getWidth());
        speler = (Speler)startvakje.speler;
        
        System.out.println(System.currentTimeMillis() - start);
        repaint();
        
        
    }
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        /*switch(e.getKeyCode()){
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
            case KeyEvent.VK_R:
                startvakje = MazeGenerator.mazegen(this.getHeight(), this.getWidth());
                speler = (Speler)startvakje.speler;
                repaint();
                break;
        } */       
    }
}
