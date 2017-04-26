/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.Floor;
import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.game.Location;
import io.github.dmmn_games.earth_2045.items.IItem;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.tools.ITool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iordkost
 */
public class User implements Serializable {

    private final String username;
    private int health;

    private Inventory inventory;

    private int floor;
    private int room;

    public User(String username) {
        this.username = username;
        this.health = 100;

        this.inventory = new Inventory();

        this.floor = 1;
        this.room = 0;

    }

    public String getUsername() {
        return username;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void go(List<Floor> Floors, Location LocToGo) throws Exception {
        Door result = Floors.get(floor).findDoorToGo(room, LocToGo);
        if (result == null) {
            throw new Exception("Door not found !");
        } else {
            if (result.getRoomA() == -1 || result.getRoomB() == -1) {
                throw new Exception("The End");
            } else {
                if (result.isIsOpen()) {
                    if (result.getRoomA() == room) {
                        room = result.getRoomB();
                    } else {
                        room = result.getRoomA();
                    }
                    throw new Exception("You go " + LocToGo + "!");
                } else {
                    throw new Exception("Door is locked !");
                }
            }
        }
    }

    public void pick(List<Floor> floors, String toolName) throws Exception {
        ITool result = floors.get(floor).getRoom(room).findTool(toolName);
        if (result == null) {
            throw new Exception("tool not found");
        } else {
            inventory.add(result);
            floors.get(floor).getRoom(room).getTools().remove(result);
            throw new Exception("You have pick " + toolName);
        }

    }

    public void use(List<Floor> floors, String toolName) throws Exception {
        ITool tempTool = inventory.find(toolName);
        if (floors.get(floor).findDoorToUse(room, tempTool)) {
            inventory.remove(toolName);
            throw new Exception("Door is unlocked now !");
        } else {
            throw new Exception("There is no a usable door to unlock !");
        }
    }

    public String talk(List<Floor> floors, String bot, String message) throws Exception {
        Bot botTalk = floors.get(floor).findBot(bot,room);
        return botTalk.talk(message);

    }
    public void recieveDamage(int damage) throws Exception
    {
        if(health>damage)
            health=health-damage;
        else
        {
            health=0;
            throw new Exception("User Die!!!");
            
                    }
    }
    public void lookAround(List<Floor> floors,CommandUI info){
        List<IItem> items=floors.get(floor).getRoom(floor).getItems();
        
        info.addLine("Items");
        for(int i=0;i<items.size();i++)
        {
            info.addLine(items.get(i).getItemID());
        
        }
        List<ITool> tools=floors.get(floor).getRoom(floor).getTools();
        
        info.addLine("Tools");
        for(int i=0;i<tools.size();i++)
        {
            info.addLine(tools.get(i).getKeyID());
        
        }
        List<Door> doors=floors.get(floor).getDoors();
        
        info.addLine("Doors");
        for(int i=0;i<doors.size();i++)
        {
            info.addLine(doors.get(i).getDoorId());
        
        }
        List<Bot>bots=floors.get(floor).getBots();
        
        info.addLine("Bots");
        for(int i=0;i<bots.size();i++)
        {
            info.addLine(bots.get(i).getName());
        
        }

    
    }
    
}
