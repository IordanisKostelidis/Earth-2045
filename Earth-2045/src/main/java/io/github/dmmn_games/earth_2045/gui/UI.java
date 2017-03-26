/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.gui;

import io.github.dmmn_games.earth_2045.global.Info;

/**
 *
 * @author iordkost
 */
public class UI {
    private final int Width;
    private final int Height;
    
    private final int PosX;
    private final int PosY;

    public UI() {
        this.Width = 640;
        this.Height = 480;
        
        PosX=(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width-this.Width)/2;
        PosY=(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-this.Height)/2;
    }

    public void initUI(javax.swing.JFrame currentFrame) {
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
    }
}
