/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands_clones;

import io.github.dmmn_games.earth_2045.commands.*;
import io.github.dmmn_games.earth_2045.game.GameController;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class WhoIAm implements ICommand {

    private final String Command;

    public WhoIAm() {
        this.Command = "whoiam";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        WhoAmI runCommand = new WhoAmI();
        runCommand.run(Arguments, History, Game);
    }
}