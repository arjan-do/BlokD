/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author arjandoets
 */
public class MainPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainWindow
     */
    
    public Vakje startvakje;
    
    public MainPanel() {
        initComponents();
    }

    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D) g;      
 
        g2D.setStroke(new BasicStroke(5));  
        
        g2D.setColor(Color.black);
        
        
        if (startvakje != null){
            
            startvakje.draw(g2D, 0, 0);
            startvakje.enddraw();
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
}
