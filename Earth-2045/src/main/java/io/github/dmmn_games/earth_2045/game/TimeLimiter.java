/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

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

    private int Seconds;
    private final JLabel Msg;
    private final JTextField Command;
    private final JButton SubmitCommand;

    public TimeLimiter(JLabel Msg,
            int Seconds,
            JTextField Command,
            JButton SubmitCommand
    ) {
        this.Msg = Msg;
        this.Seconds = Seconds;
        this.Command = Command;
        this.SubmitCommand = SubmitCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Seconds == 0) {
            this.Command.setText("Game Over !!!");
            this.Command.setEditable(false);
            this.SubmitCommand.setEnabled(false);
        } else {
            Seconds--;
            int hours = Seconds / 3600;
            int minutes = (Seconds % 3600) / 60;
            int seconds = Seconds % 60;

            String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

            Msg.setText(timeString);
        }
    }

    public int getSeconds() {
        return this.Seconds;
    }

}
