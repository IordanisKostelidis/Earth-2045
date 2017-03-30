/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.global.History;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.tools.ITool;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Status implements ICommand {

    private final String Command;

    public Status() {
        this.Command = "status";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {

        History newHistory = new History(History);
        
        newHistory.addLine("=== User's Status ===");
        newHistory.addLine("Username : " + Game.getUser().getUsername());
        newHistory.addLine("Health : " + Game.getUser().getHealth());
        newHistory.addLine("Floor : " + Game.getUser().getFloor());
        newHistory.addLine("Room : " + Game.getUser().getRoom());
        
        ITool tempTool;
        newHistory.addLine("=== Inventory ===");
        for(int i=0;i<Game.getUser().getInventory().size();i++) {
            tempTool = Game.getUser().getInventory().get(i);
            newHistory.addLine(tempTool.getKeyID());
        }
        newHistory.addLine("Total Tools : " + Game.getUser().getInventory().size());

    }
}
