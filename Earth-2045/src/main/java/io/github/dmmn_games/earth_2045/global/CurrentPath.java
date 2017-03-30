/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.global;

import io.github.dmmn_games.earth_2045.forms.Menu;
import io.github.dmmn_games.earth_2045.music.Music;
import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iordkost
 */
public class CurrentPath {

    private String Dir;

    public CurrentPath() {
        
        Dir = "";
        
        CodeSource codeSource = Menu.class.getProtectionDomain().getCodeSource();
        try {
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            Dir = jarFile.getParentFile().getPath();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getDir() {
        return Dir;
    }
}
