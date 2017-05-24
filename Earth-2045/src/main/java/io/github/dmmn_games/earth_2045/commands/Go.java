/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.Location;
import io.github.dmmn_games.earth_2045.user.User;

/**
 *
 * @author iordkost
 */
public class Go implements ICommand {

    private final String Command;

    public Go() {
        this.Command = "go";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public String run(String[] Arguments, User user) {

        if (Arguments.length == 1) {
            return "Go where ?";
        } else {
            if (Arguments[1].toUpperCase().equals(Location.NORTH.name())
                    || Arguments[1].toUpperCase().equals(Location.SOUTH.name())
                    || Arguments[1].toUpperCase().equals(Location.EAST.name())
                    || Arguments[1].toUpperCase().equals(Location.WEST.name())) {
                return user.go(Location.valueOf(Arguments[1].toUpperCase()));
            } else {
                return "You can't go there !";
            }
        }
    }
}
