/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.doors.Door;
import java.util.*;

/**
 *
 * @author makis
 */
public class Floor {
    private ArrayList<Room> Rooms = new ArrayList<Room>();
    
    private ArrayList<Door> Doors = new ArrayList<Door>();
    
    public void addRoom(Room newRoom){
        Rooms.add(newRoom);
    }
    
    public Room getRoom (int intex){
        return Rooms.get(intex);
    }
    
    public void addDoor (Door newDoor){
        Doors.add(newDoor);
    }
   /**ArrayList<ITool> toolList = new ArrayList<ITool>();
       
     *  toolList.add(new Key(1,1,100,false));
      * toolList.add(new PassCard(2,1,100,false));
      * 
      * Rooms.add(new Room(
       */
      
    
    
}
