/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author arjandoets
 */
public class Valsspeler extends Spelonderdeel{

    @Override
    public void draw(Graphics2D g, int x, int y) {
        g.setColor(Color.red);
        g.fillRect(x*Speelveld.vakjessize + Speelveld.vakjessize / 4, y*Speelveld.vakjessize + Speelveld.vakjessize / 4, Speelveld.vakjessize /2, Speelveld.vakjessize / 2);
        g.setColor(Color.black);
        g.drawString("V",x*Speelveld.vakjessize + Speelveld.vakjessize / 3, y*Speelveld.vakjessize + Speelveld.vakjessize / 5 + Speelveld.vakjessize / 2);
    }

    @Override
    public void beweeg(Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
