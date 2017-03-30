/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.global.History;
import io.github.dmmn_games.earth_2045.game.GameController;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class WhereAmI implements ICommand {

    private final String Command;

    public WhereAmI() {
        this.Command = "whereami";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        History newHistory = new History(History);
        newHistory.addLine("Floor = " + Game.getUser().getFloor());
        newHistory.addLine("Room = " + Game.getUser().getRoom());
    }
}
