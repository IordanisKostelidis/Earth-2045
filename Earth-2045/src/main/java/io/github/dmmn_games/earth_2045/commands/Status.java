/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
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

        
        new CommandUI(History).addLine("=== User's Status ===");
        new CommandUI(History).addLine("Username : " + Game.getUser().getUsername());
        new CommandUI(History).addLine("Health : " + Game.getUser().getHealth());
        new CommandUI(History).addLine("Floor : " + Game.getUser().getFloor());
        new CommandUI(History).addLine("Room : " + Game.getUser().getRoom());
        
        ITool tempTool;
        new CommandUI(History).addLine("=== Inventory ===");
        for(int i=0;i<Game.getUser().getInventory().getTools().size();i++) {
            tempTool = Game.getUser().getInventory().getTools().get(i);
            new CommandUI(History).addLine(tempTool.getToolName());
        }
        new CommandUI(History).addLine("Total Tools : " + Game.getUser().getInventory().getTools().size());

    }
}
