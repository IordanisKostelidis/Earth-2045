/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.saveload;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.CurrentPath;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author iordkost
 */
public class Load {

    public GameController loadProcess(String NameOfFile) {
        GameController x = new GameController();
        x.initWorld("Empty", 0);

        try {
            FileInputStream myGame = new FileInputStream(
                    new CurrentPath().getDir() + "/Data/Save/" + NameOfFile + ".sav"
            );
            ObjectInputStream reader = new ObjectInputStream(myGame);
            x = (GameController) reader.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Can't load the save file !");
        }
        return x;
    }
}
