
package io.github.dmmn_games.earth_2045.npcs;


public class Enemy
{

    private boolean alive;
    
    public Enemy()
    {
        alive = true;
    }
    
    public int shoot(){
        if (alive == true)
            
            return 10;
        
        else
            
            return 0;
    }
    
    public void die(){
        
        alive = false;
        
    }
}
