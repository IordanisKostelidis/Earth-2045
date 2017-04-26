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
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.tools.Key;
import io.github.dmmn_games.earth_2045.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author iordkost
 */
public class GameController implements java.io.Serializable {

    private CommandsController CommandsController;
    private List<String> CommandHistory;

    private JLabel GameTimeField;
    private Timer GameTimer;
    private TimeLimiter Listener;

    private User User;
    private List<Floor> Floors;
    private Elevator Elevator;

    public Elevator getElevator() {
        return Elevator;
    }

    public GameController() {
        CommandsController = new CommandsController();

        this.CommandHistory = new ArrayList<>();

        GameTimeField = new JLabel();
        GameTimer = new Timer(0, null);
        Listener = new TimeLimiter(null, 0, null, null);

        Floors = new ArrayList<>();
        GameTimeField = new JLabel();

        initWorld();
    }

    private void initWorld() {
        
        Elevator = new Elevator("elevator", 2, Location.NORTH);
        
        Floors.add(
                new Floor()
        ); // added the underground
        Floors.add(
                new Floor()
        ); // added 1st floor
        Floors.add(
                new Floor()
        ); // added 2nd Floor
        Floors.add(
                new Floor()
        ); // added 3rd floor
        Floors.add(
                new Floor()
        ); // added 4th floor

        Floors.get(1).addRoom(
                new Room())
                ; // added room0 in 1st floor
        Floors.get(1).addRoom(
                new Room()
        ); // added room1 in 1st floor
        Floors.get(1).addRoom(
                new Room()
        ); // added room2 in 1st floor
        Floors.get(1).addRoom(
                new Room()
        ); // added room3 in 1st floor

        Floors.get(1).addDoor(
                new Door("Main - Conference", 
                        0, 
                        1, 
                        Location.NORTH, 
                        100, 
                        false)
        ); // add door0to1 in 1st floor
        Floors.get(1).addDoor(
                new Door("Main - Security", 
                        0, 
                        3, 
                        Location.WEST, 
                        200, 
                        true)
        ); // add door3to1 in 1st floor
        Floors.get(1).addDoor(
                new Door("Conference - Elevator", 
                        1, 
                        2, 
                        Location.WEST, 
                        300, 
                        true)
        ); // add door1to2 in 1st floor
        Floors.get(1).addDoor(
                new Door("Elevator", 
                        2, 
                        -1, 
                        Location.NORTH
                        , 
                        0, 
                        true)
        ); // ending door - demo

        Floors.get(1).getRoom(3).addKey(new Key("key", 100));
        
        
        Floors.get(1).addBot(new Bot("god", 0));

    }

    public CommandsController getCommandsController() {
        return CommandsController;
    }

    public void setCommandsController(CommandsController CommandsController) {
        this.CommandsController = CommandsController;
    }

    public List<String> getCommandHistory() {
        return CommandHistory;
    }

    public void setCommandHistory(ArrayList<String> CommandHistory) {
        this.CommandHistory = CommandHistory;
    }

    public JLabel getGameTimeField() {
        return GameTimeField;
    }

    public void setGameTimeField(
            JLabel GameTimeField,
            int SecondsRemain,
            JTextField Command,
            JButton SubmitCommand
    ) {
        this.GameTimeField = GameTimeField;
        Listener = new TimeLimiter(GameTimeField,
                SecondsRemain,
                Command,
                SubmitCommand
        );
        GameTimer = new Timer(1000, Listener);
    }

    public Timer getGameTimer() {
        return GameTimer;
    }

    public void setGameTimer(Timer GameTimer) {
        this.GameTimer = GameTimer;
    }

    public void startTime() {
        GameTimer.start();
    }

    public void stopTime() {
        GameTimer.stop();
    }

    public TimeLimiter getListener() {
        return Listener;
    }

    public void setListener(TimeLimiter Listener) {
        this.Listener = Listener;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public List<Floor> getFloors() {
        return Floors;
    }

    public Floor getFloor(int Index) {
        return this.Floors.get(Index);
    }

    public void setFloors(List<Floor> Floors) {
        this.Floors = Floors;
    }

}
