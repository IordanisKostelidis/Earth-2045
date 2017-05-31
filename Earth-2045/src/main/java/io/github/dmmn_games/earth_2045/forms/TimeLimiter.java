/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author iordkost
 */
public class TimeLimiter implements Serializable, ActionListener {

    private int remainingSeconds;
    private final JLabel remainingLabel;
    private final JTextField commandField;
    private final JButton submitCommandButton;

    public TimeLimiter(JLabel remainingLabel,
            int remainingSeconds,
            JTextField commandField,
            JButton submitCommandButton
    ) {
        this.remainingLabel = remainingLabel;
        this.remainingSeconds = remainingSeconds;
        this.commandField = commandField;
        this.submitCommandButton = submitCommandButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (remainingSeconds == 0) {
            this.commandField.setText("Game Over !!!");
            this.commandField.setEditable(false);
            this.submitCommandButton.setEnabled(false);
        } else {
            remainingSeconds--;
            int hours = remainingSeconds / 3600;
            int minutes = (remainingSeconds % 3600) / 60;
            int seconds = this.remainingSeconds % 60;

            String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

            remainingLabel.setText(timeString);
        }
    }

    public int getSeconds() {
        return this.remainingSeconds;
    }

}
