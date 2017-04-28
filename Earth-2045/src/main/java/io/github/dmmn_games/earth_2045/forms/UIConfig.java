/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.forms;

import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.global.Info;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iordkost
 */
public class UIConfig {
    private final int Width;
    private final int Height;
    
    private final int PosX;
    private final int PosY;

    public UIConfig() {
        this.Width = 500;
        this.Height = 500;
        
        PosX=(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width-this.Width)/2;
        PosY=(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-this.Height)/2;
    }
    
    public UIConfig(int Width, int Height) {
        this.Width = Width;
        this.Height = Height;
        
        PosX=(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width-this.Width)/2;
        PosY=(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-this.Height)/2;
    }

    public void initUI(javax.swing.JFrame currentFrame) throws MalformedURLException {
        // Disable Resizing Feature
        currentFrame.setResizable(
                false
        );
        
        // Set Window's Size
        currentFrame.setSize(
                this.Width,
                this.Height
        );
        
        // Set Window on Center of Screen
        currentFrame.setLocation(this.PosX, this.PosY);

        // Set Window's Title
        currentFrame.setTitle(
                new Info().getName() + " | " + new Info().getVersion()
        );
        
        try {
            currentFrame.setIconImage(javax.imageio.ImageIO.read(new File(new CurrentPath().getDir() + "/Data/Media/Images/Logo.dat")));
        } catch (IOException ex) {
            // Logger.getLogger(UIConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
