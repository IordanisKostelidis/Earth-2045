/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.elevator.Elevator;
import io.github.dmmn_games.earth_2045.enviroment.Floor;
import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.game.Location;
import io.github.dmmn_games.earth_2045.items.IItem;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.tools.ITool;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author iordkost
 */
public class User implements Serializable {

    private final String username;
    private int health;

    private Inventory inventory;

    private int floor;
    private int room;

    public User(String username) {
        this.username = username;
        this.health = 100;

        this.inventory = new Inventory();

        this.floor = 1;
        this.room = 0;

    }

    public String getUsername() {
        return username;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void go(List<Floor> Floors, Location LocToGo) throws Exception {
        Door result = Floors.get(floor).findDoorToGo(room, LocToGo);
        if (result == null) {
            throw new Exception("What ? I can't pass through walls " + username + "!");
        } else {
            if (result.getRoomA() == -1 || result.getRoomB() == -1) {
                throw new Exception("The End Of Everything");
            } else {
                if (result.isIsOpen()) {
                    if (result.getRoomA() == room) {
                        room = result.getRoomB();
                    } else {
                        room = result.getRoomA();
                    }
                    throw new Exception("You go " + LocToGo + "!");
                } else {
                    throw new Exception("What ? The door is locked !");
                }
            }
        }
    }

    public void pick(List<Floor> floors, String toolName) throws Exception {
        ITool result = floors.get(floor).getRoom(room).findTool(toolName);
        if (result == null) {
            throw new Exception("I don't have this tool " + username);
        } else {
            inventory.add(result);
            floors.get(floor).getRoom(room).getTools().remove(result);
            throw new Exception("Nice, i have picked a " + toolName);
        }

    }

    public void use(List<Floor> floors, String toolName) throws Exception {
        ITool tempTool = inventory.find(toolName);
        if (floors.get(floor).findDoorToUse(room, tempTool)) {
            inventory.remove(toolName);
            throw new Exception("Whoa ! I have unlocked this door " + username);
        } else {
            throw new Exception("WHATT? I can't use this key on this door " + username);
        }
    }

    public String talk(List<Floor> floors, String bot, String message) throws Exception {
        Bot botTalk = floors.get(floor).findBot(bot, room);
        return botTalk.talk(message, username);

    }

    public void recieveDamage(int damage) throws Exception {
        if (health > damage) {
            health = health - damage;
        } else {
            health = 0;
            throw new Exception("User Die!!!");

        }
    }

    public void lookAround(List<Floor> floors, Elevator elevator, CommandUI info) {
        List<IItem> items = floors.get(floor).getRoom(room).getItems();

        info.addLine("== Items ==");
        for (int i = 0; i < items.size(); i++) {
            info.addLine(items.get(i).getItemID());

        }
        List<ITool> tools = floors.get(floor).getRoom(room).getTools();

        info.addLine("== Tools ==");
        for (int i = 0; i < tools.size(); i++) {
            info.addLine(tools.get(i).getKeyID());

        }

        if (room == elevator.getRoom()) {
            info.addLine("== Elevator ==");
            info.addLine(elevator.getPos().name());
        }

        List<Door> doors = floors.get(floor).getDoors();

        info.addLine("== Doors ==");
        for (int i = 0; i < doors.size(); i++) {
            Door tempDoor = doors.get(i);
            if (tempDoor.getRoomA() == room || tempDoor.getRoomB() == room) {
                if (room == tempDoor.getRoomA()) {
                    info.addLine(
                            tempDoor.getPosA().name()
                    );
                } else {
                    info.addLine(
                            tempDoor.getPosB().name()
                    );
                }
            }

        }
        List<Bot> bots = floors.get(floor).getBots();

        info.addLine("== Bots ==");
        for (int i = 0; i < bots.size(); i++) {
            if (bots.get(i).getPosition() == room) {
                info.addLine(bots.get(i).getName());
            }

        }

    }

    public void take(List<Floor> floors, Elevator Elevator, String Word, String FloorToGo) throws Exception {
        if (Word.equals(Elevator.getElevatorID())) {

            if (room == Elevator.getRoom()) {
                if (floors.size() >= Integer.parseInt(FloorToGo)) {
                    floor = Integer.parseInt(FloorToGo);
                } else {
                    throw new Exception("Out of index");
                }

            } else {
                throw new Exception("NO ELEVATOR");
            }

        } else {
            throw new Exception("BUGGGGGGGG");
        }
    }

    public void shoot(List<Floor> floors, String enemyName) throws Exception {
        Enemy tempEnemy = floors.get(this.floor).getRoom(this.room).findEnemy(enemyName);
        ITool tempWeapon = this.inventory.find("weapon");
        tempEnemy.receiveDamage(tempWeapon.getDamage());
        if (tempEnemy.isAlive()) {
            tempEnemy.shoot(this);
            throw new Exception("You have " + this.health + " health and " + enemyName + "have" + tempEnemy.getHealth() + " health");

        } else {
            throw new Exception("You have " + this.health + " health and " + enemyName + "have Died!!!");
        }

    }

    public void receiveDamage(int damage) {
        this.health -= damage;

    }

    public boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {

            return false;
        }
    }

}
