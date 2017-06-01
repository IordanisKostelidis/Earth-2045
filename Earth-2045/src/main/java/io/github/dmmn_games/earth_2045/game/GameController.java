/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import io.github.dmmn_games.earth_2045.commands.CommandsController;
import io.github.dmmn_games.earth_2045.enviroment.*;
import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.global.XMLReader;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.npcs.Enemy;
import io.github.dmmn_games.earth_2045.user.User;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author iordkost
 */
public class GameController implements java.io.Serializable {

    private CommandsController CommandsController;
    private User User;
    private final List<Floor> floors;

    private XMLReader XML;

    private int time;
    private int nextTrigger;

    public GameController() {
        CommandsController = new CommandsController();
        floors = new ArrayList<>();
        try {
            XML = new XMLReader(new CurrentPath().getDir() + "/Data/World.xml");
        } catch (Exception ex) {
            System.exit(0);
        }

    }

    public void initWorld(String Username, int time) {
        this.time = time;
        this.nextTrigger = time - 30;

        this.User = new User(Username);

        try {

            initFloors();
            initRooms();

            initElevation();
            initDoors();

            initUser();
            initBots();
            initEnemies();

        } catch (Exception ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initFloors() throws Exception {

        NodeList tmpList = XML.getElementsByName("floor");

        for (int i = 0; i < tmpList.getLength(); i++) {
            Node nNode = tmpList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                String name = eElement.getAttribute("name");
                this.floors.add(
                        new Floor(
                                name
                        )
                );
            }
        }
    }

    private void initRooms() throws Exception {

        NodeList tmpList = XML.getElementsByName("room");

        for (int i = 0; i < tmpList.getLength(); i++) {
            Node nNode = tmpList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                int floor = Integer.parseInt(eElement.getAttribute("floor"));
                String name = eElement.getAttribute("name");
                String elevator = eElement.getAttribute("elevator");

                this.floors.get(
                        floor
                ).addRoom(new Room(name, elevator.equals("true")));

            }
        }
    }

    private void initDoors() throws Exception {

        NodeList tmpList = XML.getElementsByName("door");

        for (int i = 0; i < tmpList.getLength(); i++) {
            Node nNode = tmpList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                this.floors.get(
                        Integer.parseInt(
                                eElement.getAttribute("floor")
                        )
                ).getRoom(
                        Integer.valueOf(
                                eElement.getAttribute("fromRoom")
                        )
                ).addDoor(Integer.valueOf(
                        eElement.getAttribute("id")
                ),
                        Location.valueOf(eElement.getAttribute("location")),
                        this.floors.get(
                                Integer.valueOf(
                                        eElement.getAttribute("floor")
                                )
                        ).getRoom(
                                Integer.valueOf(
                                        eElement.getAttribute("toRoom")
                                )
                        ), "true".equals(eElement.getAttribute("open"))
                );

            }
        }
    }

    private void initUser() {
        NodeList tmpList = XML.getElementsByName("user");

        for (int i = 0; i < tmpList.getLength(); i++) {

            Node nNode = tmpList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                int floor = Integer.parseInt(eElement.getAttribute("floor"));
                int room = Integer.parseInt(eElement.getAttribute("room"));
                int health = Integer.parseInt(eElement.getAttribute("health"));

                this.User.setRoom(
                        this.floors.get(floor).getRoom(room)
                );
                
                this.User.setHealth(health);
            }
        }
    }

    private void initBots() {
        NodeList tmpList = XML.getElementsByName("bot");

        for (int i = 0; i < tmpList.getLength(); i++) {

            Node nNode = tmpList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String name = eElement.getAttribute("name");
                int floor = Integer.parseInt(eElement.getAttribute("floor"));
                int room = Integer.parseInt(eElement.getAttribute("room"));

                this.floors.get(floor).getRoom(room).addBot(new Bot(name, 0));
            }
        }
    }
    
    private void initEnemies() {
        NodeList tmpList = XML.getElementsByName("enemy");

        for (int i = 0; i < tmpList.getLength(); i++) {

            Node nNode = tmpList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String name = eElement.getAttribute("name");
                int health = Integer.parseInt(eElement.getAttribute("health"));
                int floor = Integer.parseInt(eElement.getAttribute("floor"));
                int room = Integer.parseInt(eElement.getAttribute("room"));

                this.floors.get(floor).getRoom(room).addEnemy(new Enemy(true, name, health));
            }
        }
    }

    private void initElevation() throws Exception {
        for (int i = 0; i < floors.size(); i++) {
            if (i == 0) {
                // Under
                floors.get(i).getElavatorRoom().setEvevation(
                        null,
                        floors.get(i + 1).getElavatorRoom()
                );
            } else if (i == floors.size() - 1) {
                // Top
                floors.get(i).getElavatorRoom().setEvevation(
                        floors.get(i - 1).getElavatorRoom(),
                        null
                );
            } else {
                floors.get(i).getElavatorRoom().setEvevation(
                        floors.get(i - 1).getElavatorRoom(),
                        floors.get(i + 1).getElavatorRoom()
                );
            }
        }
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
            this.nextTrigger -= 30;

            Random random = new Random();

            int n = (int) (Math.random() * floors.size() + 0);

            floors.get(n).moveEnemies();
        }
    }

}
