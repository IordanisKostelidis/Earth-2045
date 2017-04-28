/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.game.Location;
import javax.swing.JTextArea;

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
    public void run(String[] Arguments, JTextArea History, GameController Game) {

        if (Arguments.length == 1) {
            new CommandUI(History).addLine("Go where ?");
        } else {
            if (Arguments[1].toUpperCase().equals(Location.NORTH.name())
                    || Arguments[1].toUpperCase().equals(Location.SOUTH.name())
                    || Arguments[1].toUpperCase().equals(Location.EAST.name())
                    || Arguments[1].toUpperCase().equals(Location.WEST.name())) {
                try {
                    Game.getUser().go(Game.getFloors(), Location.valueOf(Arguments[1].toUpperCase()));
                } catch (Exception ex) {
                    if(ex.getMessage().equals("The End")) {
                        Game.getCommandsController().setCanDoCommand(false);
                        Game.stopTime();
                    }
                    new CommandUI(History).addLine(ex.getMessage());
                }
            } else {
                new CommandUI(History).addLine("You can't go there !");
            }
        }
    }
}
