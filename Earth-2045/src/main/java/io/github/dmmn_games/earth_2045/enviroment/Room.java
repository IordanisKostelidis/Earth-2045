/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.items.*;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author makis
 */
public class Room implements Serializable {

    private List<ITool> tools = new ArrayList<>();
    private List<IItem> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<Enemy>();

    public Room() {
        this.tools = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void addKey(Key newKey) {
        tools.add(newKey);
    }

    public List<ITool> getTools() {
        return tools;
    }

    public void setTools(ArrayList<ITool> tools) {
        this.tools = tools;
    }

    public List<IItem> getItems() {
        return items;
    }

    public void setItems(List<IItem> items) {
        this.items = items;
    }
         
    public ITool findTool(String toolName) throws Exception{
        
        for (int i=0;i<tools.size();i++)
        {
            if (tools.get(i).getKeyID().equals(toolName)){
                return tools.get(i);
            }
        }
       
        throw new Exception("Tool not found");
    
    }
    
    public void addEnemy(Enemy newEnemy) {
        this.enemies.add(newEnemy);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
    
    public Enemy findEnemy(String Name) throws Exception {
        for(int i=0;i<this.enemies.size();i++) {
          if(enemies.get(i).getName().equals(Name)) {
              return enemies.get(i);
          }  
        }
        
        throw new Exception("Enemy not found");
    }
}
