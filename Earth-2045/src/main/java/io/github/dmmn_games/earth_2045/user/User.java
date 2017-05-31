/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.ElevatorDirection;
import io.github.dmmn_games.earth_2045.enviroment.Floor;
import io.github.dmmn_games.earth_2045.enviroment.Room;
import io.github.dmmn_games.earth_2045.game.Location;
import io.github.dmmn_games.earth_2045.items.IItem;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.ITool;
import java.io.Serializable;
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
    private boolean alive;

    private Inventory inventory;

    private Room room;

    public User(String username) {
        this.username = username;
        this.health = 100;
        this.alive = true;
       

        this.inventory = new Inventory();

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public String go(Location loctogo) {
        try {

            Door tempdoor = room.findDoor(loctogo);
            if (tempdoor.isIsOpen()) {
                room = tempdoor.getNextRoom();

            } else {
                if (inventory.findKey(tempdoor.getDoorID())) {
                    tempdoor.unlockDoor();

                } else {
                    return ("Door is Locked and you dont have the key to open it");

                }

            }
        } catch (Exception ex) {
            return (ex.getMessage());
        }

        return ("Go success");

    }

    public String pick(String toolName) {
        try {
            inventory.add(room.findItool(toolName));
            room.removeITool(toolName);
        } catch (Exception ex) {
            return (ex.getMessage());
        }
        return ("You pick" + toolName);
    }

    public String talk(String bot, String message) {
        try {
            Bot tempBot = room.findBot(bot);
            return tempBot.talk(message, this.username);
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    public void recieveDamage(int damage) throws Exception {
        if (health > damage) {
            health = health - damage;
        } else {
            health = 0;
            throw new Exception("I have died !!!");

        }
    }

    public String look(String selector) {
        String response = "";
        switch (selector) {
            case "tools": {
                response += lookTools();

                break;
            }
            case "items": {
                response += lookItem();
                break;
            }
            case "bots": {
                response += lookBots();
                break;
            }
            case "enemy": {
                response += lookEnemy();
                break;
            }
            case "doors": {
                response += lookDoors();
                break;
            }
            case "around": {
                response += lookDoors();
                response += lookTools();
                response += lookItem();
                response += lookBots();
                response += lookEnemy();
                break;
            }
            default: {
                response += "unsupported Response";
            }

        }
        return response;

    }

    private String lookTools() {
        List<ITool> tempTools = room.getTools();
        String response = "";
        for (int i = 0; i < tempTools.size(); i++) {
            response +="I find a "+ tempTools.get(i).getToolName()+"and i can pick up \n";

        }
        return response;

    }

    private String lookItem() {
        List<IItem> tempItems = room.getItems();
        String response = "";
        for (int i = 0; i < tempItems.size(); i++) {
            response +="I found a "+ tempItems.get(i).getItemName()+"i can't pick up this Item!! \n";
            

        }
        return response;

    }

    private String lookBots() {
        List<Bot> tempBots = room.getBots();
        String response = "";
        for (int i = 0; i < tempBots.size(); i++) {
            response +="I find Bot"+tempBots.get(i).getName()+"and i can talk with him \n";

        }
        return response;

    }

    private String lookEnemy() {
        List<Enemy> tempEnemy = room.getEnemies();
        String response = "";
        for (int i = 0; i < tempEnemy.size(); i++) {
            response +="I found a enemy with name"+ tempEnemy.get(i).getName()+"write shot and try to kill him!! \n";

        }
        return response;

    }

    private String lookDoors() {
        List<Door> tempDoors = room.getDoors();
        String response = "";
        for (int i = 0; i < tempDoors.size(); i++) {
            response +="i Found the door"+ tempDoors.get(i).getGeoloc()+"\n";

        }
        return response;

    }

    public String take(String elevator, ElevatorDirection direction, int loop) {
        if (room.isElavation()) {

            if (direction == ElevatorDirection.UP) {
                for (int i = 0; i < loop; i++) {
                   if(room.getElevation().getNextRoom() != null) {
                       room = room.getElevation().getNextRoom();
                   }

                }

            } else {
                for (int i = 0; i < loop; i++) {
                    if(room.getElevation().getPreviousRoom() != null) {
                       room = room.getElevation().getPreviousRoom();
                   }

                }

            }

        }

        return "I changed Floor";
    }

    public String shoot(String enemyName) {

        try {
            Enemy tempEnemy = room.findEnemy(enemyName);
            
            tempEnemy.receiveDamage(inventory.findWeapondmg());
            if (tempEnemy.isAlive()) {
                tempEnemy.shoot(this);
                return "I hit the"+tempEnemy.getName()+"with"+inventory.findWeapondmg()+"Damage"+  "and enemy hit me with"+tempEnemy.getDamage();

            } else {
                
                room.removeEnemy(enemyName);
                return "I kill the Enemy!!";

            }

        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    public void receiveDamage(int damage) {
        this.health -= damage;
        if (health <= 0) {
            alive = false;
        }

    }

    public boolean isAlive() {
        return alive;
    }
    public String status(){
    String response="";
    response="Name: "+this.username+"\n Health"+this.health+"\n -----Inventory------";
    String[] toolNames=this.inventory.getToolName();
    for(int i=0;i<toolNames.length;i++){
    
    
    response+="\n"+toolNames[i];
    }
    
    
   return response; }

}
