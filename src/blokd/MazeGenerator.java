/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.util.Random;

/**
 *
 * @author arjandoets
 */
public class MazeGenerator {
    
    static public Vakje mazegen(int y, int x){
        
        int id = 0;
        
        Vakje[][] vakjes = new Vakje[y / Speelveld.vakjessize][x / Speelveld.vakjessize]; 
        
        for(int ver = 0; ver < vakjes.length; ver ++)
        {
            for(int hor = 0; hor < vakjes[ver].length; hor ++)
            {
                vakjes[ver][hor] = new Vakje(id);
                if (hor != 0)
                {
                    vakjes[ver][hor].setLeft(vakjes[ver][hor - 1]);
                }
                if (ver != 0)
                {
                vakjes[ver][hor].setUp(vakjes[ver - 1][hor]);
                }
                
                id ++;
            }  
        }
        
        vakjes[0][0].generatelevel();
        vakjes[0][0].Done();
        
        vakjes[0][0].setSpeler(new Speler());
        vakjes[y / Speelveld.vakjessize - 1][x / Speelveld.vakjessize - 1].setVriend(new Vriend());
        vakjes[1][0].setVriend(new Helper());
        
        Vakje tmp = vakjes[0][0];
        vakjes = null;
        System.gc();
        return tmp;
    }    
}
