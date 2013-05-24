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
    
    
    public Speler(){
        heeftBazzooka = false;
    }
    
    
    @Override
    public void draw(Graphics2D g, int x, int y){
        g.fillRect(x*50 + 10, y*50 + 10, 30, 30);
    
    }
    
    @Override
    public void beweeg(String richting){
        switch(richting){
            case "omhoog":
                huidigvakje.up.setSpeler(this);
                huidigvakje.down.speler = null;
                break;
            case "rechts":
                huidigvakje.right.setSpeler(this);
                huidigvakje.left.speler = null;                
                break;
            case "omlaag":
                huidigvakje.down.setSpeler(this);
                huidigvakje.up.speler = null;
                break;
            case "links":
                huidigvakje.left.setSpeler(this);
                huidigvakje.right.speler = null;
                break;
        }
    }
    
    public void vuurBazzooka(){
        
    }
}
