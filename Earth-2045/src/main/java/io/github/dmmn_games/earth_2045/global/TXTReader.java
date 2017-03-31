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

    private final String File;
    private String ReadedFile;

    public TXTReader(String File, String Message) {
        this.File = File;
        
        ReadedFile = Message;
        
        try {
            ReadedFile = new String(Files.readAllBytes(Paths.get(File)));
        } catch (IOException ex) {
            Logger.getLogger(TXTReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getReadedFile() {
        return ReadedFile;
    }
}
