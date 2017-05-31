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
public class Man implements ICommand {

    private final String command;

    public Man() {
        this.command = "man";
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String run(String[] commandArguments, User user) {
        if (commandArguments.length == 1) {
            return "You must define the command you want !";
        } else {
            return new TXTReader(
                            new CurrentPath().getDir()
                            + "/Data/Docs/"
                            + commandArguments[1]
                            + "/"
                            + commandArguments[1]
                            + ".dat",
                            "This is invalid command !"
                    ).getReadedFile();
        }

    }
}
