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
public class Bazooka extends Spelonderdeel{

    @Override
    public void draw(Graphics2D g, int x, int y) {
        g.setColor(Color.yellow);
        g.fillRect(x*Speelveld.vakjessize + Speelveld.vakjessize / 4, y*Speelveld.vakjessize + Speelveld.vakjessize / 4, Speelveld.vakjessize /2, Speelveld.vakjessize / 2);
    }

    
    public void detonate(Vakje vakje){
        
        if(vakje.left != null){
            vakje.muurleft = false;
            vakje.left.muurright = false;
        }
        if(vakje.up != null){
            vakje.muurup = false;
            vakje.up.muurdown = false;
        }
        if(vakje.right != null){
            vakje.muurright = false;
            vakje.right.muurleft = false;
        }
        if(vakje.down != null){
            vakje.muurdown = false;
            vakje.down.muurup = false;
        }
        
        
        
    }
    
    @Override
    public void beweeg(Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
