/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.saveload;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.CurrentPath;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author iordkost
 */
public class Save {

    public void run(String slot, GameController game) {
        saveProcess(slot, game);
    }
    
    private void saveProcess(String nameOfFile, GameController currentGame) {
        try {
            // Serialize data object to a file
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(
                            new CurrentPath().getDir() + "/Data/Save/" + nameOfFile + ".sav"
                    )
            );
            out.writeObject(currentGame);
            out.close();

            // Serialize data object to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bos);
            out.writeObject(currentGame);
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
