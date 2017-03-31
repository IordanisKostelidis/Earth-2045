/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.game.CommandUI;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Info implements ICommand {

    private final String Command;

    public Info() {
        this.Command = "info";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        CommandUI currentHistory = new CommandUI(History);
        currentHistory.addLine(
                new io.github.dmmn_games.earth_2045.global.Info().getName()
                + " " + new io.github.dmmn_games.earth_2045.global.Info().getVersion()
        );
        currentHistory.addLine(
                new io.github.dmmn_games.earth_2045.global.Info().getDesc()
        );
        currentHistory.addLine(
                "Developed by " + new io.github.dmmn_games.earth_2045.global.Info().getDev()
        );
        currentHistory.addLine(
                new io.github.dmmn_games.earth_2045.global.Info().getWebsite()
        );
    }

}
