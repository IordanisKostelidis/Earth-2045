/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.game.GameController;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Kill implements ICommand {

    private final String Command;

    public Kill() {
        this.Command = "kill";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        
        if (Arguments.length == 1) {
            new CommandUI(History).addLine("Kill who ???");
        } else {
            switch (Arguments[1]) {
                case "guard": {
                    new CommandUI(History).addLine("You killed a guard !");
                    break;
                }
                default: {
                    new CommandUI(History).addLine("You can't kill " + Arguments[1] + " !!!");
                }
            }
        }

    }
}
