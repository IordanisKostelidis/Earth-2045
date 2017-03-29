/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.Floor;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.JTextAreaCustom;
import io.github.dmmn_games.earth_2045.global.Navigation;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Go implements ICommand {

    private final String Command;

    public Go() {
        this.Command = "go";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        JTextAreaCustom currentHistory = new JTextAreaCustom(History);
        boolean isFound = false;
        if (Arguments.length == 1) {
            currentHistory.addLine("Go where ?");
        } else {
            
            int locationToGo = new Navigation().getLocation(Arguments[1]);
            
            int currentUserFloor = Game.getUser().getFloor();
            int currentUserRoom = Game.getUser().getRoom();
            
            Floor currentFloor = Game.getFloor(currentUserFloor);
            
            Door tempDoor;
            for(int i = 0; i<currentFloor.getDoors().size();i++) {
               tempDoor = currentFloor.getDoors().get(i);
               
               if(tempDoor.getRoomA() == currentUserRoom && tempDoor.getPosA() == locationToGo) {
                   if(tempDoor.isIsOpen()) {
                       Game.getUser().setRoom(tempDoor.getRoomB());
                        isFound = true;
                        break;
                   } else {
                       currentHistory.addLine("This door is locked");
                   }
               } else if(tempDoor.getRoomB() == currentUserRoom && tempDoor.getPosB() == locationToGo) {
                   if(tempDoor.isIsOpen()) {
                       Game.getUser().setRoom(tempDoor.getRoomA());
                        isFound = true;
                        break;
                   } else {
                       currentHistory.addLine("This door is locked");
                   }
               }
            }
            
            if(!isFound) {
                currentHistory.addLine("You can't go here !");
            } else {
                currentHistory.addLine("You go " + Arguments[1] + "!!!!");
            }
        }
    }
}
