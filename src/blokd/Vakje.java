/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author arjandoets
 */
public class Vakje {
    Vakje left;
    boolean muurleft = true;
    Vakje up;
    boolean muurup = true;
    Vakje right;
    boolean muurright = true;
    Vakje down;
    boolean muurdown = true;
    int id ;
    boolean Done = false;
    
    Spelonderdeel speler;
    
    public Vakje(int id) {
        this.id = id;   
    }

    public void setSpeler(Spelonderdeel speler) {
        this.speler = speler;
        this.speler.huidigvakje = this;
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
    
    //de draw eindigen en alle variabelen reseten
    public void Done()
    {
        Done = false;
        if(left != null){
            if(left.Done){
                left.Done();
            }
        }
        if(up != null){
            if(up.Done){
                up.Done();
            }
        }
        if(right != null){
            if(right.Done){
                right.Done();
            }
        }
        if(down != null){
            if(down.Done){
                down.Done();
            }
        }
    }
    
    
    public void generatelevel()
    {
        Done = true;
        
        ArrayList<Direction> pdir = new ArrayList<>();
        ArrayList<Direction> draw = new ArrayList<>();
        
        if(left != null){
            if(!left.Done){
                pdir.add(Direction.LEFT);
            }
        }
        if(up != null){
            if(!up.Done){
                pdir.add(Direction.UP);
            }
        }
        if(right != null){
            if(!right.Done){
                pdir.add(Direction.RIGHT);
            }
        }
        if(down != null){
            if(!down.Done){
                pdir.add(Direction.DOWN);
            }
        }
            
        
        draw.add(Direction.LEFT);
        draw.add(Direction.UP);
        draw.add(Direction.RIGHT);
        draw.add(Direction.DOWN);
        
        for( int i = pdir.size(); i != 0;  i --) {
        
            Random random = new Random();   
            int dir = random.nextInt(i);
        
            Direction sdir = pdir.get(dir);
        
            switch (sdir) {
                case LEFT:
                    if (!left.Done){
                        left.generatelevel();
                        draw.remove(Direction.LEFT);
                        pdir.remove(Direction.LEFT);
                    }
                    break;
                case UP:
                    if (!up.Done){
                        up.generatelevel();
                        draw.remove(Direction.UP);
                        pdir.remove(Direction.UP);
                    }
                    break;
                case RIGHT:
                    if (!right.Done){
                        right.generatelevel();
                        draw.remove(Direction.RIGHT);
                        pdir.remove(Direction.RIGHT);
                    }
                    break;
                case DOWN:
                    if (!down.Done){
                        down.generatelevel();
                        draw.remove(Direction.DOWN);
                        pdir.remove(Direction.DOWN);
                    }
                    break;
            }
           
        }
         
        if(!draw.contains(Direction.LEFT)){
            muurleft = false;
            if(left != null){
                left.muurright = false;
            }
        }
        if(!draw.contains(Direction.UP)){
            muurup = false;
            if(up != null){
                up.muurdown = false;
            }
        }
        if(!draw.contains(Direction.RIGHT)){
            muurright = false;
            if(right != null){
                right.muurleft = false;
            }
        }
        if(!draw.contains(Direction.DOWN)){
            muurdown = false;
            if(down != null){
                down.muurup = false;
            }
        }
        
        
    }
    
    // tekenen van het huidige vakje en het aanroepen van het tekenen van de omliggende vakjes
    public void draw(Graphics2D g, int x, int y)
    {
        if(speler != null){
            speler.draw(g, x, y);
        }
        Done = true;
        
        
        
        if(muurleft == true)
        {
            g.drawLine(x * MainPanel.vakjessize, y * MainPanel.vakjessize, x * MainPanel.vakjessize, y * MainPanel.vakjessize + MainPanel.vakjessize);
        }  
        
        if(muurup == true)
        {
            g.drawLine(x * MainPanel.vakjessize, y * MainPanel.vakjessize, x * MainPanel.vakjessize + MainPanel.vakjessize, y * MainPanel.vakjessize);
        }
        
        if(muurright == true)
        {
            g.drawLine(x * MainPanel.vakjessize + MainPanel.vakjessize, y * MainPanel.vakjessize, x * MainPanel.vakjessize + MainPanel.vakjessize, y * MainPanel.vakjessize + MainPanel.vakjessize);
        }
        
        if(muurdown == true)
        {
            g.drawLine(x * MainPanel.vakjessize, y * MainPanel.vakjessize + MainPanel.vakjessize, x * MainPanel.vakjessize + MainPanel.vakjessize, y * MainPanel.vakjessize + MainPanel.vakjessize);
        }
        
        if(left != null){
            if(!left.Done){
                left.draw(g, x - 1, y);
            }
        }
        if(up != null){
            if(!up.Done){
                up.draw(g, x , y - 1);
            }
        }
        if(right != null){
            if(!right.Done){
                right.draw(g, x + 1, y);
            }
        }
        if(down != null){
            if(!down.Done){
                down.draw(g, x, y + 1);
            }
        }
        //g.drawString("" + id, x * 50 + 10, y * 50 + 20);
        
    }
    
    
    
}
