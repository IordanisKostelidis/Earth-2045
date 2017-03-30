/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.global;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author iordkost
 */
public class MyListener implements ActionListener{
    private int count;
    private JLabel label;

    public MyListener(JLabel label, int Time) {
        this.label = label;
        this.count = Time;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        count--;
        label.setText(count + "");
    }
    
}
