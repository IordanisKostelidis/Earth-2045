/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.enviroment.Room;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.game.Location;
import io.github.dmmn_games.earth_2045.tools.ITool;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Pick implements ICommand {

    private final String Command;

    public Pick() {
        this.Command = "pick";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        CommandUI currentHistory = new CommandUI(History);

        if (Arguments.length == 1) {
            currentHistory.addLine("Pick what ???");
        } else {
            try {
                Game.getUser().pick(Game.getFloors(), Arguments[1]);
            } catch (Exception ex) {
                currentHistory.addLine(ex.getMessage());
            }

        }

    }
}
