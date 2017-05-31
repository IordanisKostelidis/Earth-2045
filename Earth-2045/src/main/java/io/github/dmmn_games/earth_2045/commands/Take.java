/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.enviroment.ElevatorDirection;
import io.github.dmmn_games.earth_2045.user.User;

/**
 *
 * @author iordkost
 */
public class Take implements ICommand {

    private final String command;

    public Take() {
        this.command = "take";
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String run(String[] commandArguments, User user) {

        if(commandArguments.length == 1) {
            return "Take what ?";
        } else {
            String Elevator = commandArguments[1];
            ElevatorDirection Direction = ElevatorDirection.valueOf(
                    commandArguments[2].toUpperCase()
            );
            int Loop = Integer.parseInt(commandArguments[3]);
            
            return user.take(Elevator, Direction, Loop);
        }

    }
}
