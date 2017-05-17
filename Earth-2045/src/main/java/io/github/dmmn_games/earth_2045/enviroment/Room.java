/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.items.*;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author makis
 */
public class Room implements Serializable {

    private List<Door> doors;

    private List<ITool> tools;
    private List<IItem> items;

    private List<Bot> bots;
    private List<Enemy> enemies;

    public Room() {
        this.doors = new ArrayList<>();
        
        this.tools = new ArrayList<>();
        this.items = new ArrayList<>();
        
        this.bots = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }
    
    public void addDoor(Door newDoor) {
        doors.add(newDoor);
    }
    
    public void addTool(ITool newITool) {
        tools.add(newITool);
    }
    
    public void addItem(IItem newIItem) {
        items.add(newIItem);
    }
    public void addBot(Bot newBot) {
        bots.add(newBot);
    }
    public void addEnemy(Enemy newEnemy) {
        enemies.add(newEnemy);
    }

    
}
