/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.user.User;

/**
 *
 * @author iordkost
 */
public class Info implements ICommand {

    private final String command;

    public Info() {
        this.command = "info";
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String run(String[] commandArguments, User user) {
        return new io.github.dmmn_games.earth_2045.global.Info().getName() + "\n"
                + new io.github.dmmn_games.earth_2045.global.Info().getVersion();
    }

}
