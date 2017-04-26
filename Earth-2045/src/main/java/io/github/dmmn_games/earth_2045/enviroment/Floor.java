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

    private List<Room> Rooms = new ArrayList<Room>();
    private List<Door> Doors = new ArrayList<Door>();
    private List<Bot> Bots= new ArrayList<Bot>();

    public Floor() {
        this.Rooms = new ArrayList<>();
        this.Doors = new ArrayList<>();
        this.Bots = new ArrayList<>();
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
    public void addBot(Bot newBot) {
        Bots.add(newBot);
    }
    
    public Bot findBot(String BotName) throws Exception {
        Bot tempBot;
        
        for (int i = 0; i < Bots.size(); i++){
        
            tempBot = Bots.get(i);
            
            if (tempBot.getName().equals(BotName)){
                return tempBot;
            }
                  
        }
        throw new Exception("The "+BotName+" not found!!");
    }
    
    public Door findDoorToGo(int userRoom, Location goLocation) {
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

    public boolean findDoorToUse(int userRoom, ITool Tool) {
        Door tempDoor;
        for (int i = 0; i < Doors.size(); i++) {
            tempDoor = Doors.get(i);
            if (tempDoor.getRoomA() == userRoom || tempDoor.getRoomB() == userRoom) {
                if (tempDoor.isIsOpen()) {
                    continue;
                } else {
                    if (Tool.getID() == tempDoor.getIdPass()) {
                        tempDoor.setIsOpen(true);
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
