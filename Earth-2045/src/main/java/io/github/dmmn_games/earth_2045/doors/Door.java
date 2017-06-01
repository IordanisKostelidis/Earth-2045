/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.doors;

import io.github.dmmn_games.earth_2045.enviroment.Room;
import io.github.dmmn_games.earth_2045.game.Location;
import java.io.Serializable;

/**
 *
 * @author iordkost
 */
public class Door implements Serializable {

    private final int doorID;
    private final Location geoloc;
    private final Room nextRoom;
    private boolean isOpen;

    public Door(int doorID, Location geoloc, Room nextRoom, boolean isOpen) {
        this.doorID = doorID;
        this.geoloc = geoloc;
        this.nextRoom = nextRoom;
        this.isOpen = isOpen;
    }

    public Location getGeoloc() {
        return geoloc;
    }


    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }


    public int getDoorID() {
        return doorID;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public boolean isIsOpen() {
        return isOpen;
    }
    
    public void unlockDoor() {
        this.isOpen = true;
    }


    
}
