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
public abstract class Spelonderdeel {
    Vakje huidigvakje;
    public abstract void draw(Graphics2D g, int x, int y);
    public abstract void beweeg(Direction direction);
}

