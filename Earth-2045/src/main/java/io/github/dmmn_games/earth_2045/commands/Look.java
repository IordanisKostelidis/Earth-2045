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
public class Look implements ICommand {

    private final String Command;

    public Look() {
        this.Command = "look";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {

        if (Arguments.length == 1) {
            new CommandUI(History).addLine("Look where ?");
        } else {
                        
            if (Arguments[1].equals("around")) {

                Game.getUser().lookAround(Game.getFloors(),Game.getElevator(), new CommandUI(History));

            }
        }
    }
}
