/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.doors.Door;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author makis
 */
public class Floor implements Serializable {

    private ArrayList<Room> Rooms = new ArrayList<Room>();
    private ArrayList<Door> Doors = new ArrayList<Door>();

    public Floor() {
        this.Rooms = new ArrayList<>();
        this.Doors = new ArrayList<>();
    }

    public void addRoom(Room newRoom) {
        Rooms.add(newRoom);
    }

    public Room getRoom(int index) {
        return Rooms.get(index);
    }

    public ArrayList<Room> getRooms() {
        return this.Rooms;
    }

    public void addDoor(Door newDoor) {
        Doors.add(newDoor);
    }
    
    public Door getDoor(int index) {
        return Doors.get(index);
    }

    public ArrayList<Door> getDoors() {
        return Doors;
    }

}
