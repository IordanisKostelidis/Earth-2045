
package io.github.dmmn_games.earth_2045.npcs;

import io.github.dmmn_games.earth_2045.user.User;


public class Enemy
{

    private boolean alive = true;
    private int health = 100;
    
    public Enemy()
    {
        alive = true;
    }
    
    public void shoot(User user){
            
        user.receiveDamage();
        
    }
    
    public void receiveDamage(int damage){
        
        health = health - damage;
        
    }
    
    public boolean isAlive(){
        
        if (health <= 0){
            alive = false ;
        }
        
        return alive;
    }
    
    
}
