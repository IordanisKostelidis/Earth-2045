/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.Floor;
import io.github.dmmn_games.earth_2045.game.Location;
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

    public void pick(List<Floor> floors, String toolName) throws Exception {
        ITool result = floors.get(floor).getRoom(room).findTool(toolName);
        if (result == null) {
            throw new Exception("tool not found");
        } else {
            inventory.add(result);
            floors.get(floor).getRoom(room).getTools().remove(result);
            throw new Exception("You have pick "+ toolName);
        }

    }
    public void use(List<Floor> floors,String toolName) throws Exception
    {
        ITool tempTool = inventory.find(toolName);
        if(floors.get(floor).findDoorToUse(room, tempTool)) {
            inventory.remove(toolName);
            throw new Exception("Door is unlocked now !");
        } else {
            throw new Exception("There is no a usable door to unlock !");
        }
    }
}
