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
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.*;
import io.github.dmmn_games.earth_2045.user.User;
import static java.lang.Math.abs;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iordkost
 */
public class GameController implements java.io.Serializable {

    private CommandsController CommandsController;
    private User User;
    private List<Floor> floors;

    private int time;
    private int nextTrigger;

    public GameController() {
        CommandsController = new CommandsController();
        floors = new ArrayList<>();
    }

    public void addFloor(Floor newFloor) {
        floors.add(newFloor);
    }

    public void initWorld(String Username, int time) {
        this.time = time;
        this.nextTrigger = time - 2;

        this.addFloor(new Floor());
        this.addFloor(new Floor());
        this.addFloor(new Floor());

        initRooms();

        // Add content for the floor1
        floors.get(1).getRoom(0).addDoor(
                new Door("door0to1",
                        1,
                        NORTH,
                        floors.get(1).getRoom(1),
                        true
                )
        );

        floors.get(1).getRoom(1).addDoor(
                new Door("door1to2",
                        2,
                        WEST,
                        floors.get(1).getRoom(2),
                        true
                )
        );

        floors.get(1).getRoom(3).addTool(new Key("masterkey", 100));

        floors.get(1).getRoom(0).addEnemy(new Enemy(true, "reverse", 5));
        floors.get(1).getRoom(1).addEnemy(new Enemy(true, "reverse", 5));
        floors.get(1).getRoom(2).addEnemy(new Enemy(true, "reverse", 5));
        floors.get(1).getRoom(3).addEnemy(new Enemy(true, "reverse", 5));
        floors.get(1).getRoom(0).addBot(new Bot("josearmando", 0));

        try {
            initElevation();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        this.User = new User(Username);
        this.User.setRoom(floors.get(1).getRoom(0));
    }

    private void initRooms() {
        floors.forEach((floor) -> {
            floor.addRoom(new Room());
            floor.addRoom(new Room());
            floor.addRoom(new Room());
            floor.addRoom(new Room());
        });
    }

    private void initElevation() throws Exception {
        floors.forEach((floor) -> {
            floor.getRoom(2).setEvevation(null, null);
        });

        floors.get(1).getRoom(2).setEvevation(null, floors.get(2).getElavatorRoom());

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

    public void timeTrigger() throws Exception {
        if (this.time == this.nextTrigger) {
            this.nextTrigger -= 2;

            Random random = new Random();

            int n = (int) (Math.random() * floors.size() + 0);

            floors.get(n).moveEnemies();
        }
    }

}
