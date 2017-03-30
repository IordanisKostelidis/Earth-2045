/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.History;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Help implements ICommand {

    private final String Command;

    public Help() {
        this.Command = "help";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        History currentHistory = new History(History);
        if (Arguments.length == 1) {
            currentHistory.addLine("ToDO: Add Help File");
        }

    }
}
