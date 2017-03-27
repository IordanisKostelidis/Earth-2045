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
        JTextAreaCustom currentHistory = new JTextAreaCustom(History);
        
        if (Arguments.length == 1) {
            currentHistory.addLine("Go where ?");
        } else {
            switch (Arguments[1]) {
                case "north": {
                    currentHistory.addLine("You go North !");
                    break;
                }
                case "east": {
                    currentHistory.addLine("You go East !");
                    break;
                }
                case "south": {
                    currentHistory.addLine("You go South !");
                    break;
                }
                case "west": {
                    currentHistory.addLine("You go West !");
                    break;
                }
                default: {
                    currentHistory.addLine("You can't go " + Arguments[1] + " !!!");
                }
            }
        }

    }
}
