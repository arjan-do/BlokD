/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.Graphics2D;

/**
 *
 * @author Tony
 */
public class Speler extends Spelonderdeel{
    private boolean heeftBazzooka;
    private Direction direction;
    
    public Speler(){
        heeftBazzooka = false;
    }
    
    
    @Override
    public void draw(Graphics2D g, int x, int y){
        g.fillRect(x*Speelveld.vakjessize + Speelveld.vakjessize / 4, y*Speelveld.vakjessize + Speelveld.vakjessize / 4, Speelveld.vakjessize /2, Speelveld.vakjessize / 2);
    
    }
    
    @Override
    public void beweeg(Direction direction){
        switch(direction){
            case UP:
                if(!this.huidigvakje.muurup){
                    huidigvakje.up.setSpeler(this);
                    huidigvakje.down.speler = null;                    
                }
                break;
            case RIGHT:
                if(!this.huidigvakje.muurright){
                    huidigvakje.right.setSpeler(this);
                    huidigvakje.left.speler = null;                     
                }               
                break;
            case DOWN:
                if(!this.huidigvakje.muurdown){
                    huidigvakje.down.setSpeler(this);
                    huidigvakje.up.speler = null;                    
                }
                break;
            case LEFT:
                if(!this.huidigvakje.muurleft){
                    huidigvakje.left.setSpeler(this);
                    huidigvakje.right.speler = null;                    
                }
                break;
        }
    }
    
    public void vuurBazzooka(){
        
    }
}
