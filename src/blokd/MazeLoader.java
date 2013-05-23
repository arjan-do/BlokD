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
    
   static public Vakje load1(){
        
        int x = 1;
        int xsmall = 0;
        int y = 1; 
        int ysmall = 0;
        int id = 1;
        
        Vakje[][] vakjes = new Vakje[(level1.length - 1) / 2][(level1[0].length - 1) / 2]; 
        
        for(int ver = 0; ver < vakjes.length; ver ++)
        {
            for(int hor = 0; hor < vakjes[ver].length; hor ++)
            {
                vakjes[ver][hor] = new Vakje(id);
                id ++;
            }
        }
        
        
        while(y < level1.length){
            while(x < level1[0].length){

                Vakje working = vakjes[ysmall][xsmall];
                if (level1[y][x - 1] == 0){
                    working.setLeft(vakjes[ysmall][xsmall - 1]);
                }
                if (level1[y - 1][x] == 0){
                    working.setUp(vakjes[ysmall - 1][xsmall]);
                }
                if (level1[y][x + 1] == 0){
                    working.setRight(vakjes[ysmall][ xsmall + 1]);
                }
                if (level1[y + 1][x] == 0){
                working.setDown(vakjes[ysmall + 1][xsmall]);   
                }

                level1[y][x-1] = 1;
                level1[y-1][x] = 1;
                level1[y][x+1] = 1;
                level1[y+1][x] = 1;
                level1[y][x] = 1;

                x += 2;
                xsmall ++;
            }
            
            x = 1;
            xsmall = 0;
            
            y += 2;
            ysmall ++;
        }
            
        return vakjes[0][0];
        
    }
    
    
    char[][] levelemty = {
           //w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w,o,w 
            {},// w
            {},// o
            {},// w
            {},// o
            {},// w
            {},// o
            {},// w
            {},// o
            {},// w
            {},// o
            {},// w
            {},// o
            {},// w
            {},// o
            {},// w
            {},// o
            {} // w
    };
    
}
