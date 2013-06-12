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
        
        Random rand = new Random();
        int xHelper = rand.nextInt(x / Speelveld.vakjessize);
        int yHelper = rand.nextInt(y / Speelveld.vakjessize);
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
        
        if(vakjes[yHelper][xHelper].bevat instanceof Speler || vakjes[yHelper][xHelper].bevat instanceof Vriend){
            xHelper = rand.nextInt(x / Speelveld.vakjessize);
            yHelper = rand.nextInt(y / Speelveld.vakjessize);
            vakjes[yHelper][xHelper].setHelper(new Helper());            
        }else{
            vakjes[yHelper][xHelper].setHelper(new Helper());
        }
        
        // aanmaken van bezoekas
        int aangemaakt = 0;
        
        while(aangemaakt < 5){
            int xBezoeka = rand.nextInt(x / Speelveld.vakjessize);
            int yBezoeka = rand.nextInt(y / Speelveld.vakjessize);

            if(vakjes[yBezoeka][xBezoeka].bevat == null){
                vakjes[yBezoeka][xBezoeka].bevat = new Bezoeka();
                aangemaakt ++;
            }
        }
        
        Vakje tmp = vakjes[0][0];
        vakjes = null;
        System.gc();
        return tmp;
    }    
}
