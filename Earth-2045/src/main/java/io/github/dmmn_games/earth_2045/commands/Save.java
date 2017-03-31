/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.game.CommandUI;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Save implements ICommand {

    private final String Command;

    public Save() {
        this.Command = "save";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        CommandUI currentHistory = new CommandUI(History);
        if(Arguments.length == 1) {
            currentHistory.addLine("You must define the save slot !");
        } else {
            switch(Arguments[1]) {
                case "a": {
                    saveProcess("a", Game);
                    currentHistory.addLine("Your game is saved on slot a !");
                    break;
                }
                case "b": {
                    saveProcess("b", Game);
                    currentHistory.addLine("Your game is saved on slot b !");
                    break;
                }
                case "c": {
                    saveProcess("c", Game);
                    currentHistory.addLine("Your game is saved on slot c !");
                    break;
                }
                default: {
                    currentHistory.addLine("This is not a valid save slot !");
                }
            }
        }
    }
    
    private void saveProcess(String NameOfFile, GameController CurrentGame) {
        try {
            // Serialize data object to a file
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(
                            new CurrentPath().getDir() + "/Data/Save/" + NameOfFile + ".sav"
                    )
            );
            out.writeObject(CurrentGame);
            out.close();

            // Serialize data object to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bos);
            out.writeObject(CurrentGame);
            out.close();
        } catch (IOException e) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
