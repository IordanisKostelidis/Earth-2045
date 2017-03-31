/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.enviroment.Room;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.tools.ITool;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Pick implements ICommand {

    private final String Command;

    public Pick() {
        this.Command = "pick";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        CommandUI currentHistory = new CommandUI(History);
        
        if (Arguments.length == 1) {
            currentHistory.addLine("Pick what ???");
        } else {
            int currentUserFloor = Game.getUser().getFloor();
            int currentUserRoom = Game.getUser().getRoom();
            
            Room currentRoom = Game.getFloor(currentUserFloor).getRoom(currentUserRoom);
            
            ITool currentTool;
            boolean found = false;
            
            for(int i=0;i<currentRoom.getTools().size();i++) {
                currentTool = currentRoom.getTools().get(i);
                
                if(currentTool.getKeyID().equals(Arguments[1])) {
                    found = true;
                    Game.getUser().getInventory().add(currentTool);
                    currentRoom.getTools().remove(i);
                    break;
                }
            }
            
            if(!found) {
                currentHistory.addLine("What ??");
            } else {
                currentHistory.addLine("You have picked up " + Arguments[1]);
            }
            
        }

    }
}
