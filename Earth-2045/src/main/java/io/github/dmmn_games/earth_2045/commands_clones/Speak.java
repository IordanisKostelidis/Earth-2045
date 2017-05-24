/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands_clones;

import io.github.dmmn_games.earth_2045.commands.*;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.user.User;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Speak implements ICommand {

    private final String Command;

    public Speak() {
        this.Command = "speak";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public String run(String[] Arguments, User user) {
        return new Talk().run(Arguments, user);
    }
}
