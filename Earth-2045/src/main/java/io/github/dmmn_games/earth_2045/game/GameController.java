/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.*;
import io.github.dmmn_games.earth_2045.user.User;
import java.util.ArrayList;

/**
 *
 * @author iordkost
 */
public class GameController implements java.io.Serializable {

    private User User;
    private ArrayList<Floor> Floors;

    public GameController() {
        Floors = new ArrayList<Floor>();
        initFloors();
    }

    private void initFloors() {
         Floors.add(new Floor());
         Floors.get(0).addRoom(new Room()); // add room0
         Floors.get(0).addRoom(new Room()); // add room1
         Floors.get(0).addRoom(new Room()); // add room2
         Floors.get(0).addRoom(new Room()); // add room3
         Floors.get(0).addDoor(new Door("door0to1",0,1,100,true)); // add door0to1
         Floors.get(0).addDoor(new Door("door0to3",0,3,200,true)); // add door3to1
         Floors.get(0).addDoor(new Door("door1to2",1,2,300,true)); // add door1to2
        
        /*
            Floors.add(new Floor());
            Floors.get(0).addRoom(new Room());
            Floors.get(0).getRoom(0).addDoor(new Door(....));
        */
    }

    public void setUser(User User) {
        this.User = User;
    }

    public User getUser() {
        return User;
    }
    
    //

}
