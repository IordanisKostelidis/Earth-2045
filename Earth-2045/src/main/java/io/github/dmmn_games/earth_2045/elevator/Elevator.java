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

    String elevatorName;
    int room;
    Location position;

    public Elevator(String elevatorName, int room, Location position) {
        this.elevatorName = elevatorName;
        this.room = room;
        this.position = position;
    }

    public String getElevatorName() {
        return elevatorName;
    }

    public int getRoom() {
        return room;
    }

    public Location getPosition() {
        return position;
    }
    
    

}
