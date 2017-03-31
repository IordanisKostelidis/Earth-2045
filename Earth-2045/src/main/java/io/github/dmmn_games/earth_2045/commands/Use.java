/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.tools.ITool;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Use implements ICommand {

    private final String Command;

    public Use() {
        this.Command = "use";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        CommandUI currentHistory = new CommandUI(History);
        
        if (Arguments.length == 1) {
            currentHistory.addLine("Use what ???");
        } else {
            
            int currentUserFloor = Game.getUser().getFloor();
            int currentUserRoom = Game.getUser().getRoom();
            
            String usingTool = Arguments[1];
            
            ITool tempTool = null;
            boolean found = false;
            
            for(int i=0;i<Game.getUser().getInventory().size();i++) {
                tempTool = Game.getUser().getInventory().get(i);
                
                if(usingTool.equals(tempTool.getKeyID())) {
                    found = true;
                    break;
                }
                
            }
            
            if(!found) {
                currentHistory.addLine("You don't have this tool !");
            } else {
                int KeyID = tempTool.getID();
                
                Door tempDoor = null;
                boolean doorFound = false;
                for(int i = 0;i<Game.getFloor(currentUserFloor).getDoors().size();i++) {
                    tempDoor = Game.getFloor(currentUserFloor).getDoors().get(i);
                    
                    if(tempDoor.getRoomA() == currentUserRoom || tempDoor.getRoomB() == currentUserRoom) {
                        doorFound = true;
                        break;
                    }
                    
                }
                
                if(tempDoor.getIdPass() == tempTool.getID() && doorFound) {
                    tempDoor.setIsOpen(true);
                    Game.getUser().getInventory().remove(tempTool);
                    currentHistory.addLine("The door is unlocked");
                }
                
            }
            
        }

    }
}
