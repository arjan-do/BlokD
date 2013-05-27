/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

/**
 *
 * @author arjandoets
 */
public class MazeLoader {
    
    static int[][] level1 = {
           //w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},// w
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},// o
            {1,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1,1,0,1,0,1},// w
            {1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,1},// o
            {1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,1},// w
            {1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,1},// o
            {1,0,1,1,1,1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,1},// w
            {1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,1},// o
            {1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,1},// w
            {1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,1},// o
            {1,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1,1,0,1,0,1},// w
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},// o
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} // w
            
    };
    
    static int[][] level2 = {
           //w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w 
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},// w
            {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},// o
            {1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1},// w
            {1,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1},// o
            {1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},// w
            {1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,1},// o
            {1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1},// w
            {1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,1},// o
            {1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1},// w
            {1,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,1},// o
            {1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1},// w
            {1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,1},// o
            {1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1},// w
            {1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1},// o
            {1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1},// w
            {1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,1},// o
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} // w
    };
    
   static public Vakje load1(int[][] level){
        
        int x = 1;
        int xsmall = 0;
        int y = 1; 
        int ysmall = 0;
        int id = 1;
        
        Vakje[][] vakjes = new Vakje[(level.length - 1) / 2][(level[0].length - 1) / 2]; 
        
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
               
        while(y < level.length){
            while(x < level[0].length){

                Vakje working = vakjes[ysmall][xsmall];
                if (level[y][x - 1] != 0){
                    working.muurleft = true;
                }
                if (level[y - 1][x] != 0){
                    working.muurup = true;
                }
                if (level[y][x + 1] != 0){
                    working.muurright = true;
                }
                if (level[y + 1][x] != 0){
                    working.muurdown = true;
                }

                x += 2;
                xsmall ++;
            }
            
            x = 1;
            xsmall = 0;
            
            y += 2;
            ysmall ++;
        }
        vakjes[0][0].setSpeler(new Speler());
        return vakjes[0][0];
        
    }
}