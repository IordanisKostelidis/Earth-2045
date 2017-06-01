/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.global;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iordkost
 */
public class TXTReader {

    private final String file;
    private String readedFile;

    public TXTReader(String file, String message) {
        this.file = file;
        
        readedFile = message;
        
        try {
            readedFile = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException ex) {
            Logger.getLogger(TXTReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getReadedFile() {
        return readedFile;
    }
}
