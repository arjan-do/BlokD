/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.Graphics2D;

/**
 *
 * @author arjandoets
 */
public class Vakje {
    Vakje left;
    Vakje up;
    Vakje right;
    Vakje down;
    boolean drawstart = false;
    int id ;

    public Vakje(int id) {
        this.id = id;
    }
    

    public void setDown(Vakje down) {
        this.down = down;
        down.up = this;
    }

    public void setLeft(Vakje left) {
        this.left = left;
        left.right = this;
    }

    public void setRight(Vakje right) {
        this.right = right;
        right.left = this;
    }

    public void setUp(Vakje up) {
        this.up = up;
        up.down = this;
    }
    
    
    
    public void draw(Graphics2D g, int x, int y)
    {
        drawstart = true;
        System.out.println(x);
        System.out.println(y);
        
        if(left == null)
        {
            g.drawLine(x * 50, y * 50, x * 50, y * 50 + 50);
        } else {
            if (!left.drawstart){
                left.draw(g, x - 1, y);
                left.drawstart = false;
            }
        }
        
        if(up == null)
        {
            g.drawLine(x * 50, y * 50, x * 50 + 50, y * 50);
        }
        else 
        {
            if (!up.drawstart){
                up.draw(g, x , y - 1);
                up.drawstart = false;
            }
        }
        
        if(right == null)
        {
            g.drawLine(x * 50 + 50, y * 50, x * 50 + 50, y * 50 + 50);
        } 
        else 
        {
            if (!right.drawstart){
                right.draw(g, x + 1, y);
                right.drawstart = false;
            }
        }
        
        if(down == null)
        {
            g.drawLine(x * 50, y * 50 + 50, x * 50 + 50, y * 50 + 50);
        } 
        else 
        {
            if (!down.drawstart){
                down.draw(g, x, y + 1);
                down.drawstart = false;
            }
        }
        
        g.drawString("" + id, x * 50 + 10, y * 50 + 20);
        
    }
    
    
    
}
