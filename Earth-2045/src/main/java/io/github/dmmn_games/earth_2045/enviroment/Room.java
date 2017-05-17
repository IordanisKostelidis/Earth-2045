/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.game.Location;
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

    private List<Door> Doors = new ArrayList<>();
    private List<Bot> Bots = new ArrayList<>();
    private List<ITool> tools = new ArrayList<>();
    private List<IItem> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    

    public Room() {
        this.tools = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void addTool(ITool tool) {
        tools.add(tool);
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
            if (tools.get(i).getToolName().equals(toolName)){
                return tools.get(i);
            }
        }
       
        throw new Exception("I can't find " + toolName + " !!!");
    
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
        
        throw new Exception("I can't find " + Name + " !!!");
    }

    public void addDoor(Door newDoor) {
        Doors.add(newDoor);
    }


    public Door getDoor(int index) {
        return Doors.get(index);
    }

    public void getBot(int index) {
        Bots.get(index);
    }

    public List<Bot> getBots() {
        return Bots;
    }

    public List<Door> getDoors() {
        return Doors;
    }

    public void addBot(Bot newBot) {
        Bots.add(newBot);
    }

    
    
    public Bot findBot(String BotName, int UserPos) throws Exception {
        Bot tempBot;

        for (int i = 0; i < Bots.size(); i++) {
            tempBot = Bots.get(i);
            
            if (tempBot.getName().equals(BotName) && tempBot.getPosition() == UserPos) {
                return tempBot;
            }

        }
        throw new Exception("I can't find " + BotName + " !");
    }
    
    /*
    public boolean findDoorToUse(int userRoom, ITool Tool) {
        Door tempDoor;
        for (int i = 0; i < Doors.size(); i++) {
            tempDoor = Doors.get(i);
            if (tempDoor.getRoomA() == userRoom || tempDoor.getRoomB() == userRoom) {
                if (!tempDoor.isIsOpen()) {
                    if (Tool.getToolValue() == tempDoor.getIdPass()) {
                        tempDoor.unlockDoor();
                        return true;
                    }
                }
            }
        }

        return false;
    }
    
     public Door findDoorToGo(int userRoom, Location goLocation) {
        Door tempDoor;

        for (int i = 0; i < Doors.size(); i++) {
            tempDoor = Doors.get(i);
            
            if (tempDoor.getRoomA() == userRoom && tempDoor.getPosA() == goLocation) {
                return tempDoor;
            } else if (tempDoor.getRoomB() == userRoom && tempDoor.getPosB() == goLocation) {
                return tempDoor;
            }
        }

        return null;

    }*/
}
