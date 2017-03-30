/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.*;
import io.github.dmmn_games.earth_2045.global.Navigation;
import io.github.dmmn_games.earth_2045.tools.Key;
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
        Floors = new ArrayList<>();
        initFloors();
    }

    private void initFloors() {
         Floors.add(new Floor()); // added the underground
         Floors.add(new Floor()); // added 1st floor
         Floors.add(new Floor()); // added 2nd Floor
         Floors.add(new Floor()); // added 3rd floor
         Floors.add(new Floor()); // added 4th floor
         
         Floors.get(1).addRoom(new Room()); // added room0 in 1st floor
         Floors.get(1).addRoom(new Room()); // added room1 in 1st floor
         Floors.get(1).addRoom(new Room()); // added room2 in 1st floor
         Floors.get(1).addRoom(new Room()); // added room3 in 1st floor
         
         Floors.get(1).addDoor(new Door("North Door",0,1,new Navigation().getNorth(),100,false)); // add door0to1 in 1st floor
         Floors.get(1).addDoor(new Door("West Door",0,3,new Navigation().getWest(),200,true)); // add door3to1 in 1st floor
         Floors.get(1).addDoor(new Door("West Door",1,2,new Navigation().getWest(),300,true)); // add door1to2 in 1st floor
         Floors.get(1).addDoor(new Door("North Door",2,-1,new Navigation().getNorth(),0,true)); // ending door - demo
        
         Floors.get(1).getRoom(3).addKey(new Key("akey",100)); 
        
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public ArrayList<Floor> getFloors() {
        return Floors;
    }

    public void setFloors(ArrayList<Floor> Floors) {
        this.Floors = Floors;
    }
    
    public Floor getFloor(int Index) {
        return Floors.get(Index);
    }

}
