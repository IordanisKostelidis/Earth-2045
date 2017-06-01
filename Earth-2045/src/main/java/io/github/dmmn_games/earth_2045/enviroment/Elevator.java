/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import java.io.Serializable;

/**
 *
 * @author iordkost
 */
public class Elevator implements Serializable {
    
    private final Room previousRoom; 
    private final Room nextRoom; 

    public Elevator(Room previousRoom, Room nextRoom) {
        this.previousRoom = previousRoom;
        this.nextRoom = nextRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public Room getNextRoom() {
        return nextRoom;
    }
    
    

}
