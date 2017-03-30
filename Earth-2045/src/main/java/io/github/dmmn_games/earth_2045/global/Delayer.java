/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.global;

import io.github.dmmn_games.earth_2045.forms.Menu;
import io.github.dmmn_games.earth_2045.forms.Splash;
import java.util.TimerTask;

/**
 *
 * @author iordkost
 */
public class Delayer extends TimerTask {
    
    Menu menu;
    Splash splash;

    public Delayer(Splash arg) {
        menu = new Menu();
        splash = arg;
    }

    @Override
    public void run() {
        menu.setVisible(true);
        splash.setVisible(false);
    }
    
    

}
