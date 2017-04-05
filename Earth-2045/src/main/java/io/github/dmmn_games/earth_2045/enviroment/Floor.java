/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.game.Location;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author makis
 */
public class Floor implements Serializable {

    private List<Room> Rooms = new ArrayList<Room>();
    private List<Door> Doors = new ArrayList<Door>();

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

    public List<Room> getRooms() {
        return this.Rooms;
    }

    public void addDoor(Door newDoor) {
        Doors.add(newDoor);
    }

    public Door getDoor(int index) {
        return Doors.get(index);
    }

    public List<Door> getDoors() {
        return Doors;
    }

    public Door findDoor(int userRoom, Location goLocation) {
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

    }

}
