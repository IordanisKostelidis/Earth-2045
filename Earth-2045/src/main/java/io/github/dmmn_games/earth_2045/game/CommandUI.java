/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class CommandUI implements java.io.Serializable {
    private final  JTextArea currentJTextArea;

    public CommandUI(JTextArea currentJTextArea) {
        this.currentJTextArea = currentJTextArea;
    }
    
    public void addLine(String line) {
        this.currentJTextArea.setText(
                this.currentJTextArea.getText() + line + "\n"
        );
    }
    
    public void clear() {
        this.currentJTextArea.setText("");
    }
}
