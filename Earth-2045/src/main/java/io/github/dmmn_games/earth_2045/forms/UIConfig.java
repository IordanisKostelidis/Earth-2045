/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.forms;

import io.github.dmmn_games.earth_2045.global.CurrentPath;
import io.github.dmmn_games.earth_2045.global.Info;
import java.io.File;

/**
 *
 * @author iordkost
 */
public class UIConfig {

    private final int width;
    private final int height;

    private final int posX;
    private final int posY;

    public UIConfig() {
        this.width = 500;
        this.height = 500;

        posX = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width - this.width) / 2;
        posY = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - this.height) / 2;
    }

    public UIConfig(int width, int height) {
        this.width = width;
        this.height = height;

        posX = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width - this.width) / 2;
        posY = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - this.height) / 2;
    }

    public void initUI(javax.swing.JFrame currentFrame) throws Exception {
        // Disable Resizing Feature
        currentFrame.setResizable(
                false
        );

        // Set Window's Size
        currentFrame.setSize(
                this.width,
                this.height
        );

        // Set Window on Center of Screen
        currentFrame.setLocation(this.posX, this.posY);

        // Set Window's Title
        currentFrame.setTitle(
                new Info().getName() + " | " + new Info().getVersion()
        );

        currentFrame.setIconImage(javax.imageio.ImageIO.read(new File(new CurrentPath().getDir() + "/Data/Media/Images/Logo.dat")));

    }
}
