/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import io.github.dmmn_games.earth_2045.commands.CommandsController;
import io.github.dmmn_games.earth_2045.elevator.Elevator;
import io.github.dmmn_games.earth_2045.enviroment.*;
import io.github.dmmn_games.earth_2045.user.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iordkost
 */
public class GameController implements java.io.Serializable {

    private CommandsController CommandsController;
    private List<String> CommandHistory;

    private User User;
    private List<Floor> Floors;
    private Elevator Elevator;

    public Elevator getElevator() {
        return Elevator;
    }

    public GameController() {
        CommandsController = new CommandsController();

        this.CommandHistory = new ArrayList<>();

        Floors = new ArrayList<>();

        initWorld();
    }

    private void initWorld() {
        
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
