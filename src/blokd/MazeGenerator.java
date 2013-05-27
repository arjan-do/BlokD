/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

/**
 *
 * @author arjandoets
 */
public class MazeGenerator {
    
    static public Vakje mazegen(){
        
        int id = 0;
        
        Vakje[][] vakjes = new Vakje[13][24]; 
        
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
        return vakjes[0][0];
    }
    
    
}