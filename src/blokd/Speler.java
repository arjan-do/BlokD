/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Tony
 */
public class Speler extends Spelonderdeel{
    private boolean heeftBazzooka;
    private Direction direction;
    public ArrayList<SpelerListener> listeners = new ArrayList<>();
    
    
    public Speler(){
        heeftBazzooka = false;
        
    }
    
    @Override
    public void draw(Graphics2D g, int x, int y){
        g.setColor(Color.black);
        g.fillRect(x*Speelveld.vakjessize + Speelveld.vakjessize / 4, y*Speelveld.vakjessize + Speelveld.vakjessize / 4, Speelveld.vakjessize /2, Speelveld.vakjessize / 2);
    }
    
    @Override
    public void beweeg(Direction direction){
        switch(direction){
            case UP:
                if(!this.huidigvakje.muurup){
                    if(huidigvakje.up.bevat instanceof Helper){
                        for(SpelerListener listener : listeners){
                            listener.spelerEvent(EventType.showPath);
                        }
                    }
                    huidigvakje.up.setSpeler(this);
                    huidigvakje.down.bevat = null;                    
                }
                break;
            case RIGHT:
                if(!this.huidigvakje.muurright){
                    if(huidigvakje.right.bevat instanceof Vriend){
                        for(SpelerListener listener : listeners){
                            listener.spelerEvent(EventType.eindeLevel);
                        }                    
                    }
                    else if(huidigvakje.right.bevat instanceof Helper){
                        for(SpelerListener listener : listeners){
                            listener.spelerEvent(EventType.showPath);
                        }
                    }                    
                    huidigvakje.right.setSpeler(this);
                    huidigvakje.left.bevat = null;                     
                }               
                break;
            case DOWN:
                if(!this.huidigvakje.muurdown){
                    if(huidigvakje.down.bevat instanceof Vriend){  
                        for(SpelerListener listener : listeners){
                            listener.spelerEvent(EventType.eindeLevel);
                        } 
                    }               
                    else if(huidigvakje.down.bevat instanceof Helper){
                        for(SpelerListener listener : listeners){
                            listener.spelerEvent(EventType.showPath);
                        }
                    }                      
                    huidigvakje.down.setSpeler(this);
                    huidigvakje.up.bevat = null;                    
                }
                break;
            case LEFT:
                if(!this.huidigvakje.muurleft){
                    if(huidigvakje.left.bevat instanceof Helper){
                        for(SpelerListener listener : listeners){
                            listener.spelerEvent(EventType.showPath);
                        }
                    }                      

                    huidigvakje.left.setSpeler(this);
                    huidigvakje.right.bevat = null;                    
                }
                break;
        }
    }
    
    public void vuurBazzooka(){
        
    }
}
