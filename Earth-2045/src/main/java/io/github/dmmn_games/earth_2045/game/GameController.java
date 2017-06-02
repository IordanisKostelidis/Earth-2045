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
import io.github.dmmn_games.earth_2045.npcs.*;
import io.github.dmmn_games.earth_2045.tools.*;
import io.github.dmmn_games.earth_2045.user.User;
import java.util.*;
import java.util.logging.*;
import org.w3c.dom.*;

/**
 *
 * @author iordkost
 */
public class GameController implements java.io.Serializable {

    private CommandsController commandsController;
    private User user;
    private final List<Floor> floors;

    private XMLReader xml;

    private int time;
    private int nextTrigger;

    public GameController() {
        commandsController = new CommandsController();
        floors = new ArrayList<>();
        try {
            xml = new XMLReader(new CurrentPath().getDir() + "/Data/World.xml");
        } catch (Exception ex) {
            System.exit(0);
        }

    }

    public void initWorld(String username, int time) {
        this.time = time;
        this.nextTrigger = time - 30;

        this.user = new User(username);

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

        NodeList tmpList = xml.getElementsByName("floor");

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

        NodeList tmpList = xml.getElementsByName("room");

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

        NodeList tmpList = xml.getElementsByName("door");

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
        NodeList tmpList = xml.getElementsByName("user");

        for (int i = 0; i < tmpList.getLength(); i++) {

            Node nNode = tmpList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                int floor = Integer.parseInt(eElement.getAttribute("floor"));
                int room = Integer.parseInt(eElement.getAttribute("room"));
                int health = Integer.parseInt(eElement.getAttribute("health"));

                this.user.setRoom(
                        this.floors.get(floor).getRoom(room)
                );
                
                this.user.setHealth(health);
            }
        }
    }

    private void initBots() {
        NodeList tmpList = xml.getElementsByName("bot");

        for (int i = 0; i < tmpList.getLength(); i++) {

            Node nNode = tmpList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String name = eElement.getAttribute("name");
                String question = eElement.getAttribute("question");
                String answer = eElement.getAttribute("answer");
                String tool = eElement.getAttribute("tool");
                int toolValue = Integer.parseInt(eElement.getAttribute("value"));
                
                ITool toolObj = null;
                switch(tool) {
                    case "weapon" : {
                        toolObj = new Weapon("gun", toolValue);
                        break;
                    }
                    case "key" : {
                        toolObj = new Key("key", toolValue);
                        break;
                    }
                }
                
                int floor = Integer.parseInt(eElement.getAttribute("floor"));
                int room = Integer.parseInt(eElement.getAttribute("room"));

                this.floors.get(floor).getRoom(room).addBot(
                        new Bot(
                                name,
                                question,
                                answer,
                                toolObj
                        )
                );
            }
        }
    }
    
    private void initEnemies() {
        NodeList tmpList = xml.getElementsByName("enemy");

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
        return commandsController;
    }

    public void setCommandsController(CommandsController commandsController) {
        this.commandsController = commandsController;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
