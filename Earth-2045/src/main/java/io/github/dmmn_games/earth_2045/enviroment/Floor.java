/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.game.Location;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.tools.ITool;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author makis
 */
public class Floor implements Serializable {

    private List<Room> Rooms = new ArrayList<>();    

    public Floor() {
        this.Rooms = new ArrayList<>();
    }

    public Room getRoom(int index) {
        return Rooms.get(index);
    }
    
    /*public void addRoom(Room newRoom) {
        newRoom.Room.add(newRoom);
    }*/
    
    public List<Room> getRooms() {
        return this.Rooms;
    }
}
