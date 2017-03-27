/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.JTextAreaCustom;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Use implements ICommand {

    private final String Command;

    public Use() {
        this.Command = "use";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        JTextAreaCustom currentHistory = new JTextAreaCustom(History);
        
        if (Arguments.length == 1) {
            currentHistory.addLine("Use what ???");
        } else {
            switch (Arguments[1]) {
                case "door": {
                    currentHistory.addLine("You use the door !");
                    break;
                }
                default: {
                    currentHistory.addLine("You can't use " + Arguments[1] + " !!!");
                }
            }
        }

    }
}
