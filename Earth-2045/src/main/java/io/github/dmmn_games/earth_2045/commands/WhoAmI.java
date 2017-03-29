/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.Info;
import io.github.dmmn_games.earth_2045.global.JTextAreaCustom;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class WhoAmI implements ICommand {

    private final String Command;

    public WhoAmI() {
        this.Command = "whoami";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        JTextAreaCustom newHistory = new JTextAreaCustom(History);
        newHistory.addLine("You name is " + Game.getUser().getUsername());
    }
}
