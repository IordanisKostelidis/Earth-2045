/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import io.github.dmmn_games.earth_2045.commands.CommandsController;
import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.*;
import static io.github.dmmn_games.earth_2045.game.Location.*;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.*;
import io.github.dmmn_games.earth_2045.user.User;
import java.util.Random;

/**
 *
 * @author iordkost
 */
public class GameController implements java.io.Serializable {

    private CommandsController CommandsController;
    private User User;

    private Floor flrGround;
    private Floor flr0;
    private Floor flr1;
    private Floor flr2;
    private Floor flr3;
    private Floor flr4;

    private int time;
    private int nextTrigger;

    public GameController() {
        CommandsController = new CommandsController();
    }

    public void initWorld(String Username, int time) {
        this.time = time;
        this.nextTrigger = time - 30;

        // Create floors
        flrGround = new Floor();
        flr0 = new Floor();
        flr1 = new Floor();
        flr2 = new Floor();
        flr3 = new Floor();
        flr4 = new Floor();

        // Link floors
        flrGround.linkfloors(null, flr1);
        flr0.linkfloors(flrGround, flr1);
        flr1.linkfloors(flr0, flr2);
        flr2.linkfloors(flr1, flr3);
        flr3.linkfloors(flr2, flr4);
        flr4.linkfloors(flr3, null);

        // Add rooms on flr1
        flr1.addRoom(new Room());
        flr1.addRoom(new Room());
        flr1.addRoom(new Room());
        flr1.addRoom(new Room());

        // Add content for the floor1
        flr1.getRoom(0).addDoor(new Door("door0to1", 100, NORTH, flr1.getRoom(1), false));
        flr1.getRoom(0).addDoor(new Door("door0to3", 1, WEST, flr1.getRoom(3), true));
        flr1.getRoom(1).addDoor(new Door("door1to2", 1, WEST, flr1.getRoom(2), true));
        flr1.getRoom(3).addTool(new Key("keyforDoor0to1", 100));
        flr1.getRoom(1).addEnemy(new Enemy(true, "reverse", 5));

        this.User = new User(Username);
        this.User.setFloor(flr1);
        this.User.setRoom(flr1.getRoom(1));

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

    public void timeTrigger() {
        if (this.time == this.nextTrigger) {
            this.nextTrigger -= 30;

            Random random = new Random();

            int n = random.nextInt(floors.size()) + 0;
            
            floors.get(n).moveEnemies();
        }
    }

}
