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
    boolean muurleft = false;
    Vakje up;
    boolean muurup = false;
    Vakje right;
    boolean muurright = false;
    Vakje down;
    boolean moordown = false;
    boolean drawworking = false;
    int id ;

    public Vakje(int id) {
        this.id = id;   
    }

    public void enddraw()
    {
        drawworking = false;
        if(left != null)
        {
            if (left.drawworking){
                    left.enddraw();
            }
        }
        if(up != null)
        {
            if (up.drawworking){
                    up.enddraw();
            }
        }
        if(right != null)
        {
            if (right.drawworking){
                    right.enddraw();
            }
        }
        if(down != null)
        {
            if (down.drawworking){
                    down.enddraw();
            }
        }
    }
    
    
    public void setDown(Vakje down) 
    {
        this.down = down;
        down.up = this;
    }

    public void setLeft(Vakje left) 
    {
        this.left = left;
        left.right = this;
    }

    public void setRight(Vakje right) 
    {
        this.right = right;
        right.left = this;
    }

    public void setUp(Vakje up) 
    {
        this.up = up;
        up.down = this;
    }
    
    // tekenen van het huidige vakje en het aanroepen van het tekenen van de omliggende vakjes
    public void draw(Graphics2D g, int x, int y)
    {
        drawworking = true;
        System.out.println(x);
        System.out.println(y);
        
        if(left == null)
        {
            g.drawLine(x * 50, y * 50, x * 50, y * 50 + 50);
        } else {
            if (!left.drawworking){
                left.draw(g, x - 1, y);
            }
        }
        
        if(up == null)
        {
            g.drawLine(x * 50, y * 50, x * 50 + 50, y * 50);
        }
        else 
        {
            if (!up.drawworking){
                up.draw(g, x , y - 1);
            }
        }
        
        if(right == null)
        {
            g.drawLine(x * 50 + 50, y * 50, x * 50 + 50, y * 50 + 50);
        } 
        else 
        {
            if (!right.drawworking){
                right.draw(g, x + 1, y);
            }
        }
        
        if(down == null)
        {
            g.drawLine(x * 50, y * 50 + 50, x * 50 + 50, y * 50 + 50);
        } 
        else 
        {
            if (!down.drawworking){
                down.draw(g, x, y + 1);
            }
        }
        
        //g.drawString("" + id, x * 50 + 10, y * 50 + 20);
        
    }
    
    
    
}
