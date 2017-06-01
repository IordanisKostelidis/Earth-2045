/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import io.github.dmmn_games.earth_2045.commands.CommandsController;
import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.*;
import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.global.XMLReader;
import io.github.dmmn_games.earth_2045.npcs.Bot;
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
        this.nextTrigger = time - 2;
        
        this.User = new User(Username);
        
        try {

            initFloors();
            initRooms();
            initDoors();
            initUser();
            initBots();
            
            this.User.setRoom(floors.get(1).getRoom(0));
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

                this.floors.get(
                        Integer.parseInt(
                                eElement.getAttribute("floor")
                        )
                ).addRoom(new Room());

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
                ).addDoor(new Door(
                        eElement.getAttribute("name"),
                        Integer.valueOf(
                                eElement.getAttribute("id")
                        ),
                        Location.valueOf(eElement.getAttribute("pos")),
                        this.floors.get(
                                Integer.valueOf(
                                        eElement.getAttribute("floor")
                                )
                        ).getRoom(
                                Integer.valueOf(
                                        eElement.getAttribute("toRoom")
                                )
                        ), "true".equals(eElement.getAttribute("open")))
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

                this.User.setRoom(
                        this.floors.get(floor).getRoom(room)
                );
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
