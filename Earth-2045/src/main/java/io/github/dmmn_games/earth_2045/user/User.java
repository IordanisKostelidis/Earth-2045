/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.ElevatorDirection;
import io.github.dmmn_games.earth_2045.enviroment.Room;
import io.github.dmmn_games.earth_2045.game.Location;
import io.github.dmmn_games.earth_2045.items.IItem;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.ITool;
import java.io.Serializable;
import java.util.List;

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
        this.health = 1000;
        this.alive = true;
        this.room = null;
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
                return ("The door is unlocked, and i went " + loctogo.toString().toLowerCase() + "!\n");

            } else if (inventory.findKey(tempdoor.getDoorID())) {
                tempdoor.unlockDoor();
                room = tempdoor.getNextRoom();
                return ("The door has locked, i unlocked it and i went " + loctogo.toString().toLowerCase() + "!\n");
            } else {
                return "The door is locked and i don't have the key !\n";

            }
        } catch (Exception ex) {
            return (ex.getMessage());
        }

    }

    public String pick(String toolName) {
        try {
            inventory.add(room.findItool(toolName));
            room.removeITool(toolName);
        } catch (Exception ex) {
            return (ex.getMessage());
        }
        return ("I have find the " + toolName + " and i put in on my inventory !");
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
            throw new Exception("DEAD");

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
                response += "I can't look for " + selector + " !\n";
            }

        }
        return response;

    }

    private String lookTools() {
        List<ITool> tempTools = room.getTools();
        String response = "";
        for (int i = 0; i < tempTools.size(); i++) {
            response += "I find a " + tempTools.get(i).getToolName() + "and i can pick up !\n";

        }
        return response;

    }

    private String lookItem() {
        List<IItem> tempItems = room.getItems();
        String response = "";
        for (int i = 0; i < tempItems.size(); i++) {
            response += "I found a " + tempItems.get(i).getItemName() + " i can't pick up this Item!! \n";

        }
        return response;

    }

    private String lookBots() {
        List<Bot> tempBots = room.getBots();
        String response = "";
        for (int i = 0; i < tempBots.size(); i++) {
            response += "I find " + tempBots.get(i).getName() + " and i can talk with him \n";

        }
        return response;

    }

    private String lookEnemy() {
        List<Enemy> tempEnemy = room.getEnemies();
        String response = "";
        for (int i = 0; i < tempEnemy.size(); i++) {
            response += "I found enemy " + tempEnemy.get(i).getName() + " and i can kill him ! \n";

        }
        return response;

    }

    private String lookDoors() {
        List<Door> tempDoors = room.getDoors();
        String response = "";
        for (int i = 0; i < tempDoors.size(); i++) {
            response += "I found a door " + tempDoors.get(i).getGeoloc() + " !\n";

        }
        return response;

    }

    public String take(String elevator, ElevatorDirection direction, int loop) {
        if (room.isElevator()) {

            if (direction == ElevatorDirection.UP) {
                for (int i = 0; i < loop; i++) {

                    if (room.getElevation().getNextRoom() != null) {
                        room = room.getElevation().getNextRoom();
                    }

                }

            } else {
                for (int i = 0; i < loop; i++) {
                    if (room.getElevation().getPreviousRoom() != null) {
                        room = room.getElevation().getPreviousRoom();
                    }

                }

            }
            
            return "I took the elevator and I went " + direction.name() + "!";

        }
        return "I can not find an elevator here !";
        
    }

    public String shoot(String enemyName) {

        try {
            Enemy tempEnemy = room.findEnemy(enemyName);

            tempEnemy.receiveDamage(inventory.findWeaponDmg());
            if (tempEnemy.isAlive()) {
                tempEnemy.shoot(this);
                return "I shot the enemy and made him " + inventory.findWeaponDmg() + " damage and he shot me and made me " + tempEnemy.getDamage() + " damage.\n";
            } else {

                room.removeEnemy(enemyName);
                return "I shot the enemy and killed him !\n";

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

    public String status() {
        String response = "Name: " + this.username + "\n"
                + "Room: " + this.room.getName() + "\n"
                + "Health: " + this.health + "\n"
                + "-----Inventory------";
        String[] toolNames = this.inventory.getToolName();
        for (String toolName : toolNames) {
            response += "\n" + toolName;
        }

        return response;
    }

    public Bot findBot(String botName) throws Exception {

        return room.findBot(botName);

    }

}
