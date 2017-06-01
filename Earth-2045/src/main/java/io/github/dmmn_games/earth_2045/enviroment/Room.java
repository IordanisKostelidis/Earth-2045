/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.game.Location;
import io.github.dmmn_games.earth_2045.items.*;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author makis
 */
public class Room implements Serializable {

    private String name;

    private List<Door> doors;

    private List<ITool> tools;
    private List<IItem> items;

    private List<Bot> bots;
    private List<Enemy> enemies;

    private boolean elevator;
    private Elevator elevatorRooms;

    public Room() {
        this.doors = new ArrayList<>();

        this.tools = new ArrayList<>();
        this.items = new ArrayList<>();

        this.bots = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.elevator = false;
        this.name = null;
    }

    public Room(String name, boolean elevator) {
        this.doors = new ArrayList<>();

        this.tools = new ArrayList<>();
        this.items = new ArrayList<>();

        this.bots = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.elevator = elevator;
        this.name = name;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public String getName() {
        return name;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public List<ITool> getTools() {
        return tools;
    }

    public List<IItem> getItems() {
        return items;
    }

    public List<Bot> getBots() {
        return bots;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void addDoor(int ID, Location loc, Room nextRoom, boolean open) {
        doors.add(new Door(ID, loc, nextRoom, open));
        nextRoom.addOtherDoor(ID, loc.getNegativeLocation(), this, open);

    }

    public void addTool(ITool newITool) {
        tools.add(newITool);
    }

    public void addItem(IItem newIItem) {
        items.add(newIItem);
    }

    public void addBot(Bot newBot) {
        bots.add(newBot);
    }

    public void addEnemy(Enemy newEnemy) {
        enemies.add(newEnemy);
    }

    public Door findDoor(Location location) throws Exception {

        for (Door tempDoor : doors) {
            if (tempDoor.getGeoLoc().equals(location)) {
                return tempDoor;
            }

        }
        throw new Exception("I hit on the wall, i am not a ghost !");
    }

    public ITool findItool(String iTool) throws Exception {

        for (ITool tempItool : tools) {
            if (tempItool.getToolName().equals(iTool)) {
                return tempItool;
            }

        }
        throw new Exception("the tool" + iTool + " not found");
    }

    public IItem findIitem(String iTool) throws Exception {

        for (IItem tempIitem : items) {
            if (tempIitem.getItemName().equals(iTool)) {
                return tempIitem;
            }

        }
        throw new Exception("the tool" + iTool + " not found");
    }

    public Bot findBot(String botName) throws Exception {

        for (Bot tempBot : bots) {
            if (tempBot.getName().equals(botName)) {
                return tempBot;
            }

        }
        throw new Exception("the tool" + botName + " not found");
    }

    public Enemy findEnemy(String enemyName) throws Exception {

        for (Enemy tempEnemy : enemies) {
            if (tempEnemy.getName().equals(enemyName)) {
                return tempEnemy;
            }

        }
        throw new Exception("the tool" + enemyName + " not found");
    }

    public String removeITool(String toolName) {
        for (ITool tempItool : tools) {
            if (tempItool.getToolName().equals(toolName)) {
                tools.remove(tempItool);
                return "the tool " + tempItool.getToolName() + " removed";
            }
        }
        return "the tool " + toolName + " didn't find";
    }

    public String removeEnemy(String enemyName) {
        for (Enemy tempEnemy : enemies) {
            if (tempEnemy.getName().equals(enemyName)) {
                enemies.remove(tempEnemy);
                return "the enemy " + tempEnemy.getName() + " removed";
            }
        }
        return "the enemy didn't find";
    }

    public Elevator getElevation() {
        return elevatorRooms;
    }

    public void setEvevation(Room previousRoom, Room nextRoom) {
        this.elevatorRooms = new Elevator(previousRoom, nextRoom);
    }

    public Enemy getRandomEnemy() throws Exception {
        if (enemies.isEmpty()) {
            throw new Exception("We can't find enemy here !");
        } else {
            return this.enemies.get((int) (Math.random() * enemies.size() + 0));
        }
    }

    private void addOtherDoor(int id, Location loc, Room nextRoom, boolean open) {
        this.doors.add(new Door(id, loc, nextRoom, open));
    }

}
