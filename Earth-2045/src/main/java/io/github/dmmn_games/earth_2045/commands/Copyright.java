/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.global.TXTReader;
import io.github.dmmn_games.earth_2045.user.User;

/**
 *
 * @author iordkost
 */
public class Copyright implements ICommand {

    private final String command;

    public Copyright() {
        this.command = "copyright";
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String run(String[] commandArguments, User user) {
        return new TXTReader(
                new CurrentPath().getDir()
                + "/Data/Docs/"
                + this.command
                + "/"
                + this.command
                + ".dat",
                ""
        ).getReadedFile();

    }
}
