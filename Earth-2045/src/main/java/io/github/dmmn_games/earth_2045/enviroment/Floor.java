/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import java.io.Serializable;
import static java.lang.Math.abs;
import java.util.*;

/**
 *
 * @author makis
 */
public class Floor implements Serializable {

 
    private List<Room> rooms;

    public Floor() {
        rooms = new ArrayList<>();
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

    public Room getElavatorRoom() throws Exception {
        for (Room tempRoom : rooms) {
            if (tempRoom.isElavation()) {
                return tempRoom;
            }
        }
        throw new Exception("there are no Elevator to this Floor");
    }

    public void moveEnemies() throws Exception {
        Random random = new Random();

        if (rooms.isEmpty()) {
            throw new Exception("Floor is empty !");
        } else {
            int randomRoom = (int) (Math.random() * rooms.size() + 0);

            Enemy tmpEnemy = rooms.get(randomRoom).getRandomEnemy();

            rooms.get(randomRoom).removeEnemy(tmpEnemy.getName());

            int randomNextRoom = (int) (Math.random() * rooms.size() + 0);
            while (randomRoom == randomNextRoom) {
                randomNextRoom = (int) (Math.random() * rooms.size() + 0);
            }

            rooms.get(randomNextRoom).addEnemy(tmpEnemy);

            throw new Exception("Enemy moved from " + randomRoom + " to " + randomNextRoom);
        }

    }
}
