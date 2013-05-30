/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.util.Stack;

/**
 *
 * @author arjandoets
 */
public class PathFinder {
    
    Stack<Vakje> shortestfound = new Stack<>();
    Stack<Vakje> current = new Stack<>();
    
    public void foundroute()
    {
        
        if (shortestfound.size() == 0){
            shortestfound = (Stack<Vakje>)current.clone();
        } else if (shortestfound.size() > current.size()){ 
            shortestfound = (Stack<Vakje>)current.clone();
        }
    }
    public void use()
    {
        while(!shortestfound.empty()){
            
            shortestfound.pop().path = true;
            
        }
    }
    
}
