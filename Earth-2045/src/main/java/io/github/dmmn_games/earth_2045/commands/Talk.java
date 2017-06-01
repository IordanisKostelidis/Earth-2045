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
public class Talk implements ICommand {

    private final String command;

    public Talk() {
        this.command = "talk";
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String run(String[] commandArguments, User user) {

        if (commandArguments.length == 1) {
            return "Talk to who ?";
        } else {
            try {
               return "TALK" + user.findBot(commandArguments[1]).getName();
            } catch (Exception ex) {
                return ex.getMessage();
            }
        }

    }
}
