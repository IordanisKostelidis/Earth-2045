/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.saveload;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.user.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author iordkost
 */
public class Load {

    public void run(String[] Arguments, GameController Game) throws Exception {

        if (Arguments.length == 1) {
            throw new Exception("You must define the load slot !");
        } else {
            switch (Arguments[1]) {
                case "a": {
                    Game = loadProcess("a");
                    break;
                }
                case "b": {
                    Game = loadProcess("a");

                    break;
                }
                case "c": {
                    Game = loadProcess("a");
                    break;
                }
                default: {
                    throw new Exception("This is not a valid slot !");
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
            System.err.println("Can't load the save file !");
        }
        return x;
    }
}
