/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.elevator;

import io.github.dmmn_games.earth_2045.game.Location;
import java.io.Serializable;

/**
 *
 * @author iordkost
 */
public class Elevator implements Serializable {

    String ElevatorID;
    int Room;
    Location Pos;

    public Elevator(String ElevatorID, int Room, Location Pos) {
        this.ElevatorID = ElevatorID;
        this.Room = Room;
        this.Pos = Pos;
    }

    public String getElevatorID() {
        return ElevatorID;
    }

    public int getRoom() {
        return Room;
    }

    public Location getPos() {
        return Pos;
    }
    
    

}
