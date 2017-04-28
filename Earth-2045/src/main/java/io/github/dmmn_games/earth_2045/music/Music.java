/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.music;

import io.github.dmmn_games.earth_2045.global.CurrentPath;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author iordkost
 */
public class Music implements Serializable {

    Clip clip;
    
    public Music() {
        // Do Nothing
    }

    public void Play() {
        try {
            clip = AudioSystem.getClip();
            
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    new File(
                            new CurrentPath().getDir() + "/Data/Media/Music/BG-Music.dat"
                    )
            );
            clip.open(inputStream);
            clip.loop(1000);
            clip.start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            System.err.println("Music file not found");
        }
    }
    
    public void Pause() {
        clip.stop();
    }
}
