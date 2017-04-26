/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.game.GameController;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Take implements ICommand {

    private final String Command;

    public Take() {
        this.Command = "take";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        CommandUI currentHistory = new CommandUI(History);

        switch (Arguments.length) {
            case 1:
                currentHistory.addLine("Take what ???");
                break;
            case 2:
                currentHistory.addLine("ODKOSPKDOPAK");
                break;
            default:
                try {
                    Game.getUser().take(Game.getFloors(), Game.getElevator(), Arguments[1], Arguments[2]);
                } catch (Exception ex) {
                    currentHistory.addLine(ex.getMessage());
                }   break;
        }

    }
}
