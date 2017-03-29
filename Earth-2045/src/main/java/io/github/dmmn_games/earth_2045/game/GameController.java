/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import io.github.dmmn_games.earth_2045.enviroment.Floor;
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

}
