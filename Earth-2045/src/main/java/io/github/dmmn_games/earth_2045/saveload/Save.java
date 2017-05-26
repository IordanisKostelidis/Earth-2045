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

    public void run(String Slot, GameController Game) {
        saveProcess(Slot, Game);
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
            System.err.println("Can't create the save file !");
        }
    }
}
