/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author makis
 */
public class Floor implements Serializable {

    private List<Room> rooms = new ArrayList<>();    

    public Floor() {
        this.rooms = new ArrayList<>();
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }
    
    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
    }
    
    public List<Room> getRooms() {
        return this.rooms;
    }
}
