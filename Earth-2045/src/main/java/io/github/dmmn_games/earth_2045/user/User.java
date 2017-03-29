/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.tools.ITool;
import java.util.ArrayList;

/**
 *
 * @author iordkost
 */
public class User {

    private final String username;
    private int room;
    private int health;
    private int floor;
    private ArrayList<ITool> inventory;

    public User(String username) {
        this.username = username;
    }

    public void setRoom(int room) {
        this.room = room;
    }



    public void setHealth(int health) {
        this.health = health;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setInventory(ArrayList<ITool> inventory) {
        this.inventory = inventory;
    }

    public int getRoom() {
        return room;
    }

  

    public int getHealth() {
        return health;
    }

    public int getFloor() {
        return floor;
    }

    public ArrayList<ITool> getInventory() {
        return inventory;
    }

}
