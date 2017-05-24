/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import io.github.dmmn_games.earth_2045.commands.CommandsController;
import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.elevator.Elevator;
import io.github.dmmn_games.earth_2045.enviroment.*;
import static io.github.dmmn_games.earth_2045.game.Location.WEST;
import io.github.dmmn_games.earth_2045.user.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iordkost
 */
public class GameController implements java.io.Serializable {

    private CommandsController CommandsController;
    private User User;


    public GameController() {
        CommandsController = new CommandsController();
        initWorld();
    }

    private void initWorld() {
        Floor flrGround= new Floor();
        Floor flr0= new Floor();
        Floor flr1= new Floor();
        Floor flr2= new Floor();
        Floor flr3= new Floor();
        Floor flr4= new Floor();
        
        flrGround.linkfloors(null, flr1);
        flr0.linkfloors(flrGround, flr1);
        flr1.linkfloors(flr0, flr2);
        flr2.linkfloors(flr1, flr3);
        flr3.linkfloors(flr2,flr4);
        flr4.linkfloors(flr3, null);
        
//        Room rm1= new Room();
//        Room rm2= new Room();
//        Room rm3= new Room();
//        Room rm4= new Room();

        flr1.addRoom(new Room());
        flr1.addRoom(new Room());
        flr1.addRoom(new Room());
        flr1.addRoom(new Room());
        
        flr1.getRoom(1).addDoor(new Door("aa",1,WEST,flr1.getRoom(2),true));
        
        
    }

    public CommandsController getCommandsController() {
        return CommandsController;
    }

    public void setCommandsController(CommandsController CommandsController) {
        this.CommandsController = CommandsController;
    }


    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }
}
