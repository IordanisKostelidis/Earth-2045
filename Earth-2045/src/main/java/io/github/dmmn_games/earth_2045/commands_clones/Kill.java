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
public class Kill implements ICommand {

    private final String Command;

    public Kill() {
        this.Command = "kill";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public String run(String[] Arguments, User user) {
        return new Shoot().run(Arguments, user);

    }
}
