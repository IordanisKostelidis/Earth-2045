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
    public int room;
    private int pos;
    private int health;
    private int score;
    private int floor;
    
private ArrayList<ITool> inventory;
    public User(String username) {
        this.username = username;
    }


    public void setRoom(int room) {
        this.room = room;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setScore(int score) {
        this.score = score;
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

    public int getPos() {
        return pos;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public int getFloor() {
        return floor;
    }

    public ArrayList<ITool> getInventory() {
        return inventory;
    }
    
    
}
