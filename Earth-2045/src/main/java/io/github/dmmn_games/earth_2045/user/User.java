/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.elevator.Elevator;
import io.github.dmmn_games.earth_2045.enviroment.ElevatorDirection;
import io.github.dmmn_games.earth_2045.enviroment.Floor;
import io.github.dmmn_games.earth_2045.enviroment.Room;
import io.github.dmmn_games.earth_2045.game.CommandUI;
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

    private Floor floor;
    private Room room;

    public User(String username) {
        this.username = username;
        this.health = 100;
        this.alive = true;

        this.inventory = new Inventory();

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
                if (inventory.findkey(tempdoor.getDoorID())) {
                    tempdoor.unlockDoor();

                } else {
                    return ("Door is Locked and yu dont have the key to open it");

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
            case "Tools": {
                response += lookTools();

                break;
            }
            case "Items": {
                response += lookItem();
                break;
            }
            case "Bots": {
                response += lookBots();
                break;
            }
            case "Enemy": {
                response += lookEnemy();
                break;
            }
            case "Doors": {
                response += lookDoors();
                break;
            }
            case "Around": {
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
        List<ITool> temptools = room.getTools();
        String response = "";
        for (int i = 0; i < temptools.size(); i++) {
            response += temptools.get(i).getToolName();

        }
        return response;

    }

    private String lookItem() {
        List<IItem> tempitems = room.getItems();
        String response = "";
        for (int i = 0; i < tempitems.size(); i++) {
            response += tempitems.get(i).getItemName();

        }
        return response;

    }

    private String lookBots() {
        List<Bot> tempbots = room.getBots();
        String response = "";
        for (int i = 0; i < tempbots.size(); i++) {
            response += tempbots.get(i).getName();

        }
        return response;

    }

    private String lookEnemy() {
        List<Enemy> tempenemy = room.getEnemies();
        String response = "";
        for (int i = 0; i < tempenemy.size(); i++) {
            response += tempenemy.get(i).getName();

        }
        return response;

    }

    private String lookDoors() {
        List<Door> tempdoors = room.getDoors();
        String response = "";
        for (int i = 0; i < tempdoors.size(); i++) {
            response += tempdoors.get(i).getDoorName();

        }
        return response;

    }

    public String take(String elevator, ElevatorDirection direction, int loop) {
        if (room.isElavator()) {

            if (direction == ElevatorDirection.UP) {
                for (int i = 0; i < loop; i++) {
                    floor = floor.getNextfloor();
                    try {
                        room = floor.getElavatorRoom();
                    } catch (Exception ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } else {
                for (int i = 0; i < loop; i++) {
                    floor = floor.getPreviousfloor();
                    try {
                        room = floor.getElavatorRoom();
                    } catch (Exception ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        }

        return "You changed Floor";
    }

    public String shoot(String enemyName) {

        try {
            Enemy tempEnemy = room.findEnemy(enemyName);
            tempEnemy.receiveDamage(inventory.findWeapondmg());
            if (tempEnemy.isAlive()) {
                tempEnemy.shoot(this);
                return "Double Shot";

            } else {
                return "You kill the Enemy";

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

}
