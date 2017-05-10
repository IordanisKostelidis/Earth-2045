/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.game.GameController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Shoot implements ICommand {

    private final String Command;

    public Shoot() {
        this.Command = "shoot";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        
        if (Arguments.length == 1) {
            new CommandUI(History).addLine("Shoot who ???");
        } else {
            try {
                Game.getUser().shoot(Game.getFloors(),Arguments[1]);
            } catch (Exception ex) {
                new CommandUI(History).addLine(ex.getMessage());
                if(ex.getMessage().contains("is dead")) {
                    // ToDo - Remove Enemy from World
                }
            }
        }

    }
}
