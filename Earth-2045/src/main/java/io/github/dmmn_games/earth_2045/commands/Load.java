/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.user.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Load implements ICommand {

    private final String Command;

    public Load() {
        this.Command = "load";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {

        CommandUI currentHistory = new CommandUI(History);
        if (Arguments.length == 1) {
            currentHistory.addLine("You must define the load slot !");
        } else {
            switch (Arguments[1]) {
                case "a": {
                    Game = loadProcess("a");
                    currentHistory.addLine("Your game is loaded from slot a !");
                    break;
                }
                case "b": {
                    Game = loadProcess("a");
                    currentHistory.addLine("Your game is loaded from slot b !");
                    break;
                }
                case "c": {
                    Game = loadProcess("a");
                    currentHistory.addLine("Your game is loaded from slot c !");
                    break;
                }
                default: {
                    currentHistory.addLine("This is not a valid slot !");
                }
            }
        }

    }

    public GameController loadProcess(String NameOfFile) {
        GameController x = new GameController();

        x.setUser(new User("Empty"));

        try {
            FileInputStream myGame = new FileInputStream(
                    new CurrentPath().getDir() + "/Data/Save/" + NameOfFile + ".sav"
            );
            ObjectInputStream reader = new ObjectInputStream(myGame);
            x = new GameController();
            x = (GameController) reader.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        }
        return x;
    }
}
