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
import io.github.dmmn_games.earth_2045.items.Window;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.Key;
import io.github.dmmn_games.earth_2045.tools.Weapon;
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
        
        initFloors();
        initUnderground();
        initGround();
        initUppergroundA();

    }
    
    public void initFloors() {
       for(int i=0;i<6;i++) {
           Floors.add(new Floor());
           for(int j=0;j<4;j++) {
               Floors.get(i).addRoom(new Room());
           } // Create 4 Rooms
       } // Create 6 Floors (Underground, Ground, 4 Upperground)
    }
    
    public void initUnderground() {
        
    }
    
    public void initGround() {
        Floors.get(1).addDoor(
                new Door("Main - Conference", 
                        0, 
                        1, 
                        Location.NORTH, 
                        100, 
                        false)
        ); // Room 0 to 1
        Floors.get(1).addDoor(
                new Door("Main - Security", 
                        0, 
                        3, 
                        Location.WEST, 
                        200, 
                        true)
        ); // Room 0 to 3
        Floors.get(1).addDoor(
                new Door("Conference - Elevator", 
                        1, 
                        2, 
                        Location.WEST, 
                        300, 
                        true)
        ); // Room 1 to 2
        
        Floors.get(1).getRoom(1).addTool(new Weapon("weapon",40));
        Floors.get(1).getRoom(3).addTool(new Key("key", 100));
        Floors.get(1).getRoom(0).getItems().add(new Window("East Window", "WHATT"));
        
        
        Floors.get(1).addBot(new Bot("thebot", 0));
        Floors.get(1).getRoom(2).addEnemy(new Enemy(true, "aizen", 100));
        
        

    }
    
    public void initUppergroundA() {
        Floors.get(2).addDoor(
                new Door("Room 0 - Room 1", 
                        0, 
                        1, 
                        Location.NORTH, 
                        100, 
                        true)
        ); // Room 0 to 1
        
        Floors.get(2).addDoor(
                new Door("Room 2 - Room 3", 
                        2, 
                        3, 
                        Location.SOUTH, 
                        100, 
                        true)
        ); // Room 2 to 3
        
        Floors.get(2).addDoor(
                new Door("Room 3 - Room 0", 
                        3, 
                        0, 
                        Location.EAST, 
                        100, 
                        true)
        ); // Room 3 to 0
        
        
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
