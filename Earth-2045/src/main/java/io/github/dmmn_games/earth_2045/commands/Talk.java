/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.SuperString;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Talk implements ICommand {

    private final String Command;

    public Talk() {
        this.Command = "talk";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        CommandUI currentHistory = new CommandUI(History);

        System.out.println(new SuperString(Arguments).GetString(2));
        
        if (Arguments.length == 1) {
            currentHistory.addLine("Talk to who ?");
        } else {
            try {
                String Msg = new SuperString(Arguments).GetString(2);
                
                currentHistory.addLine(Game.getUser().talk(Game.getFloors(), Arguments[1], Msg));
            } catch (Exception ex) {
                if (ex.getMessage().equals("The End")) {
                    Game.getCommandsController().setCanDoCommand(false);
                    Game.stopTime();
                }
                currentHistory.addLine(ex.getMessage());
            }
        }
    }
}
