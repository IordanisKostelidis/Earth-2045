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
public class Shoot implements ICommand {

    private final String command;

    public Shoot() {
        this.command = "shoot";
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String run(String[] commandArguments, User user) {

        if (commandArguments.length == 1) {
            return "Shoot who ???";
        } else {
            return user.shoot(commandArguments[1]);
        }

    }
}
