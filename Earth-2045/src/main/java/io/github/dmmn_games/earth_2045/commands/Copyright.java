/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.global.TXTReader;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Copyright implements ICommand {

    private final String Command;

    public Copyright() {
        this.Command = "copyright";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        CommandUI currentHistory = new CommandUI(History);
        if (Arguments.length == 1) {
            currentHistory.addLine(
                    new TXTReader(
                            new CurrentPath().getDir()
                            + "/Data/Docs/"
                            + this.Command
                            + "/"
                            + this.Command
                            + ".dat",
                            ""
                    ).getReadedFile()
            );
        }

    }
}
