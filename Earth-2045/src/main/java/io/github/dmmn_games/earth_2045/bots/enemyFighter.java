/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.bots;

/**
 *
 * @author elgreko
 */
public class enemyFighter
{

    private boolean alive;
    
    public enemyFighter()
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
