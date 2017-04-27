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
    private final  JTextArea CurrentJTextArea;

    public CommandUI(JTextArea CurrentJTextArea) {
        this.CurrentJTextArea = CurrentJTextArea;
    }
    
    public void addLine(String Line) {
        this.CurrentJTextArea.setText(
                this.CurrentJTextArea.getText() + Line + "\n"
        );
    }
    
    public void clear() {
        this.CurrentJTextArea.setText("");
    }
}
