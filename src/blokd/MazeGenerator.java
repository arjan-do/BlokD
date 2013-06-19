/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author arjandoets
 */
public class MazeGenerator {
    //Depth-first search
    static public Vakje mazegen(int y, int x){
        
        Random rand = new Random();
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
        //recursive aanroepen van de generator
        
        vakjes[0][0].generatelevel();
        vakjes[0][0].done();
        
        vakjes[0][0].setSpeler(new Speler());
        vakjes[y / Speelveld.vakjessize - 1][x / Speelveld.vakjessize - 1].setVriend(new Vriend());
        
        for(int i = 0 ; i < 2 ; i++){
            int xHelper = rand.nextInt(x / Speelveld.vakjessize);
            int yHelper = rand.nextInt(y / Speelveld.vakjessize);
            if(vakjes[yHelper][xHelper].bevat == null){
                xHelper = rand.nextInt(x / Speelveld.vakjessize);
                yHelper = rand.nextInt(y / Speelveld.vakjessize);
                vakjes[yHelper][xHelper].setHelper(new Helper());            
            }else{
                vakjes[yHelper][xHelper].setHelper(new Helper());
            }            
        }
        
        // aanmaken van bezoekas
        int aangemaakt = 0;
        
        while(aangemaakt < 5){
            int xBezoeka = rand.nextInt(x / Speelveld.vakjessize);
            int yBezoeka = rand.nextInt(y / Speelveld.vakjessize);

            if(vakjes[yBezoeka][xBezoeka].bevat == null){
                vakjes[yBezoeka][xBezoeka].bevat = new Bazooka();
                aangemaakt ++;
            }
        }
        
        // aanmaken van valsspelers
        int v_aangemaakt = 0;
        
        while(v_aangemaakt < 1){
            int xValsspeler = rand.nextInt(x / Speelveld.vakjessize);
            int yValsspeler = rand.nextInt(y / Speelveld.vakjessize);

            if(vakjes[yValsspeler][xValsspeler].bevat == null){
                vakjes[yValsspeler][xValsspeler].bevat = new Valsspeler();
                v_aangemaakt ++;
            }
        }
        
        Vakje tmp = vakjes[0][0];
        vakjes = null;
        System.gc();
        return tmp;
    }    
    
    
    //Aldous-Broder algorithm
       static public Vakje mazegen2(int y, int x){
        
        Random rand = new Random();
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
        
        int max = vakjes.length * vakjes[0].length;
        int current = 0;
        
        Vakje working = vakjes[0][0];
        while (max > current){
            
            if (working.Done == false){
                current ++;
                working.Done = true;
            }

            ArrayList<Direction> pdir = new ArrayList<>();

            if(working.left != null){
                pdir.add(Direction.LEFT);
            }
            if(working.up != null){
                pdir.add(Direction.UP);
            }
            if(working.right != null){
                pdir.add(Direction.RIGHT);
            }
            if(working.down != null){
                pdir.add(Direction.DOWN);
            }

            Random random = new Random();
            int dir = random.nextInt(pdir.size());

            Direction cdir = pdir.get(dir);

            switch (cdir) {
                    case LEFT:
                        if (!working.left.Done){
                        working.muurleft = false;
                        working.left.muurright = false;
                        working = working.left;
                        } else {
                        working = working.left;
                        }
                        break;

                    case UP:
                        if (!working.up.Done){
                        working.muurup = false;
                        working.up.muurdown = false;
                        working = working.up;
                        } else {
                        working = working.up;
                        }
                        break;

                    case RIGHT:
                        if (!working.right.Done){
                        working.muurright = false;
                        working.right.muurleft = false;
                        working = working.right;
                        } else {
                        working = working.right;
                        }
                        break;

                    case DOWN:
                        if (!working.down.Done){
                        working.muurdown = false;
                        working.down.muurup = false;
                        working = working.down;
                        } else {
                        working = working.down;
                        }
                        break;

                }
        
        }
        
        vakjes[0][0].done();
        
        vakjes[0][0].setSpeler(new Speler());
        vakjes[y / Speelveld.vakjessize - 1][x / Speelveld.vakjessize - 1].setVriend(new Vriend());
        
        for(int i = 0 ; i < 2 ; i++){
            int xHelper = rand.nextInt(x / Speelveld.vakjessize);
            int yHelper = rand.nextInt(y / Speelveld.vakjessize);
            if(vakjes[yHelper][xHelper].bevat == null){
                xHelper = rand.nextInt(x / Speelveld.vakjessize);
                yHelper = rand.nextInt(y / Speelveld.vakjessize);
                vakjes[yHelper][xHelper].setHelper(new Helper());            
            }else{
                vakjes[yHelper][xHelper].setHelper(new Helper());
            }            
        }
        
        // aanmaken van bezoekas
        int aangemaakt = 0;
        
        while(aangemaakt < 5){
            int xBezoeka = rand.nextInt(x / Speelveld.vakjessize);
            int yBezoeka = rand.nextInt(y / Speelveld.vakjessize);

            if(vakjes[yBezoeka][xBezoeka].bevat == null){
                vakjes[yBezoeka][xBezoeka].bevat = new Bazooka();
                aangemaakt ++;
            }
        }
        
        // aanmaken van valsspelers
        int v_aangemaakt = 0;
        
        while(v_aangemaakt < 1){
            int xValsspeler = rand.nextInt(x / Speelveld.vakjessize);
            int yValsspeler = rand.nextInt(y / Speelveld.vakjessize);

            if(vakjes[yValsspeler][xValsspeler].bevat == null){
                vakjes[yValsspeler][xValsspeler].bevat = new Valsspeler();
                v_aangemaakt ++;
            }
        }
        
        Vakje tmp = vakjes[0][0];
        vakjes = null;
        System.gc();
        return tmp;
    } 
    
    static public Vakje testBeweeg(int y, int x){
        Random rand = new Random();
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
        vakjes[0][0].done();
        
        vakjes[0][0].setSpeler(new Speler());
        
        Vakje tmp = vakjes[0][0];
        vakjes = null;
        System.gc();
        return tmp;
    } 
    
    static public Vakje testInventory(int y, int x){
        Random rand = new Random();
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
        vakjes[0][0].done();
        
        vakjes[0][0].setSpeler(new Speler());
        vakjes[0][1].setHelper(new Helper());
        
        Vakje tmp = vakjes[0][0];
        vakjes = null;
        System.gc();
        return tmp;
    }     
}
