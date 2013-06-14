/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Tony
 */
public class Speler extends Spelonderdeel{
    ArrayList<SpelerListener> listeners = new ArrayList<>();
    Stack inventory = new Stack();
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void addScore(int score) {
        this.score += score;
    }
    
    public void removeScore(int score) {
        this.score -= score;
    }
    
    public Speler(){
    }
    
    @Override
    public void draw(Graphics2D g, int x, int y){
        g.setColor(Color.black);
        g.fillRect(x*Speelveld.vakjessize + Speelveld.vakjessize / 4, y*Speelveld.vakjessize + Speelveld.vakjessize / 4, Speelveld.vakjessize /2, Speelveld.vakjessize / 2);
        
        if(!inventory.isEmpty()){
            if(inventory.peek() instanceof Bazooka){
                g.setColor(Color.white);
                g.drawString("B",x*Speelveld.vakjessize + Speelveld.vakjessize / 3, y*Speelveld.vakjessize + Speelveld.vakjessize / 5 + Speelveld.vakjessize / 2);
            } else if(inventory.peek() instanceof Helper){
                g.setColor(Color.white);
                g.drawString("H",x*Speelveld.vakjessize + Speelveld.vakjessize / 3, y*Speelveld.vakjessize + Speelveld.vakjessize / 5 + Speelveld.vakjessize / 2);
            }
        }
    }
    
    @Override
    public void beweeg(Direction direction){
        switch(direction){
            case UP:
                if(!this.huidigvakje.muurup){
                    if(huidigvakje.up.bevat != null){
                        inventory.add(huidigvakje.up.bevat);
                    }
                    huidigvakje.up.setSpeler(this);
                    huidigvakje.down.bevat = null;                    
                }
                break;
            case RIGHT:
                if(!this.huidigvakje.muurright){
                    if(huidigvakje.right.bevat instanceof Vriend){
                        notify(EventType.eindeLevel);                   
                    }
                    else if(huidigvakje.right.bevat != null){
                        inventory.add(huidigvakje.right.bevat);
                    }                
                    huidigvakje.right.setSpeler(this);
                    huidigvakje.left.bevat = null;                     
                }               
                break;
            case DOWN:
                if(!this.huidigvakje.muurdown){
                    if(huidigvakje.down.bevat instanceof Vriend){  
                        notify(EventType.eindeLevel);
                    }               
                    else if(huidigvakje.down.bevat != null){
                        inventory.add(huidigvakje.down.bevat);
                    }                 
                    huidigvakje.down.setSpeler(this);
                    huidigvakje.up.bevat = null;                    
                }
                break;
            case LEFT:
                if(!this.huidigvakje.muurleft){
                    if(huidigvakje.left.bevat != null){
                        inventory.add(huidigvakje.left.bevat);
                    }                 

                    huidigvakje.left.setSpeler(this);
                    huidigvakje.right.bevat = null;                    
                }
                break;
        }
        if(!inventory.isEmpty()){
            if(inventory.peek() instanceof Valsspeler){
                inventory.pop();
                addScore(50);
            }
        }
    }
    
    private void notify(EventType type) {
        for(SpelerListener listener : listeners){
            listener.spelerEvent(type);
        }
    }   

    public void gebruikitem(){
        if(!inventory.isEmpty()){
            if(inventory.peek() instanceof Bazooka){
                Bazooka use = (Bazooka)inventory.pop();
                use.detonate(huidigvakje);
            } else if(inventory.peek() instanceof Helper){
                inventory.pop();
                for(SpelerListener listener : listeners){
                    listener.spelerEvent(EventType.showPath);
                }
            }
        }
    }
}
