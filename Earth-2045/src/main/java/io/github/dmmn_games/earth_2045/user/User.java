/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.tools.ITool;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author iordkost
 */
public class User implements Serializable {

    private final String username;
    private int health;

    private ArrayList<ITool> inventory;

    private int floor;
    private int room;

    public User(String username) {
        this.username = username;
        this.health = 100;

        this.inventory = new ArrayList<>();

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

    public ArrayList<ITool> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<ITool> inventory) {
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

}
