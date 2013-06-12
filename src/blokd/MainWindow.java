/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author arjandoets
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    
    int counter = 500;
    Speler speler;
    public MainWindow() {
        initComponents();
        
        //mainPanel1.startvakje = MazeLoader.load1(MazeLoader.level2);   
        mainPanel1.startvakje = MazeGenerator.mazegen(mainPanel1.getHeight(), mainPanel1.getWidth());
        speler = (Speler)mainPanel1.startvakje.bevat;
        mainPanel1.startlevel();
        startTimer();
    }
    
    private void startTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run(){
                if(counter > 0){
                timerLabel.setText("Timer: " + counter);
                counter--;      
                updateInventorycounter();
                }
            }
        }, 10, 1000);        
    }
    
    private void updateInventorycounter(){
        Object[] inventory = speler.inventory.toArray();
        int bazooka = 0;
        int helper = 0;
        for(Object object : inventory){
            if(object instanceof Bazooka){
                bazooka++;
            }
            else if(object instanceof Helper){
                helper++;
            }
        }
        
        bazookaLabel.setText("Aantal bazooka's: " + bazooka);
        helperLabel.setText("Aantal helpers: " + helper);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel1 = new blokd.Speelveld();
        timerLabel = new javax.swing.JLabel();
        bazookaLabel = new javax.swing.JLabel();
        helperLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 530));

        mainPanel1.setPreferredSize(new java.awt.Dimension(620, 467));

        org.jdesktop.layout.GroupLayout mainPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel1);
        mainPanel1.setLayout(mainPanel1Layout);
        mainPanel1Layout.setHorizontalGroup(
            mainPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 620, Short.MAX_VALUE)
        );
        mainPanel1Layout.setVerticalGroup(
            mainPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 467, Short.MAX_VALUE)
        );

        timerLabel.setText("Timer:");

        bazookaLabel.setText("Aantal Bazooka's:");

        helperLabel.setText("Aantal Helpers:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(104, 104, 104)
                .add(timerLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(bazookaLabel)
                .add(93, 93, 93)
                .add(helperLabel)
                .add(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(timerLabel)
                    .add(bazookaLabel)
                    .add(helperLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(mainPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainWindow().setVisible(true);                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bazookaLabel;
    private javax.swing.JLabel helperLabel;
    private blokd.Speelveld mainPanel1;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
