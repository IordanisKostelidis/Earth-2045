/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.forms;

import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.music.Music;
import io.github.dmmn_games.earth_2045.user.User;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iordkost
 */
public class Game extends javax.swing.JFrame {

    private UIConfig UIConfig;
    private GameController GameController;
    private Music BGMusic;
    private List<String> commandHistory;
    private int HistoryIndex;

    /**
     * Creates new form Game
     */
    public Game() {
        initGame();
        GameController = new GameController();
        
    }

    public Game(String Username, int Time) {
        initGame();

        this.GameController = new GameController();
        GameController.setUser(new User(Username));
        GameController.setGameTimeField(secsRemLabelReal,
                Time,
                currentCommand,
                submitCommand
        );
        GameController.startTime();
    }

    public Game(GameController LoadedGame) {
        initGame();

        this.GameController = LoadedGame;
        GameController.setGameTimeField(
                secsRemLabelReal,
                LoadedGame.getListener().getSeconds(),
                currentCommand,
                submitCommand
        );
        GameController.startTime();
    }

    private void initGame() {

        // Init Components
        initComponents();

        // Apply UI Settings
        UIConfig = new UIConfig();
        try {
            UIConfig.initUI(this);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Init CommandUI Logger
        initHistory();

        // Play Music
        BGMusic = new Music();
        BGMusic.Play();
        
        // Init Command History
        this.commandHistory = new ArrayList<>();
        this.HistoryIndex = 0;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane();
        commandLogger = new javax.swing.JTextArea();
        submitCommand = new javax.swing.JButton();
        currentCommand = new javax.swing.JTextField();
        secsRemLabel = new javax.swing.JLabel();
        secsRemLabelReal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        commandLogger.setEditable(false);
        commandLogger.setColumns(20);
        commandLogger.setRows(5);
        scrollPanel.setViewportView(commandLogger);

        submitCommand.setText("Submit");
        submitCommand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitCommandMouseClicked(evt);
            }
        });

        currentCommand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                currentCommandKeyPressed(evt);
            }
        });

        secsRemLabel.setText("Time Remaining");

        secsRemLabelReal.setText("???");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentCommand, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitCommand))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(secsRemLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secsRemLabelReal)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secsRemLabel)
                    .addComponent(secsRemLabelReal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitCommand)
                    .addComponent(currentCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initHistory() {
        commandLogger.setText("Ready...." + "\n");

    }

    private void execCommand() {
        if (currentCommand.isEditable()) {
            
            commandHistory.add(currentCommand.getText());
            HistoryIndex = commandHistory.size() - 1;
            
            GameController.getCommandsController().runCommand(currentCommand, commandLogger, GameController);
            GameController.getCommandHistory().add(currentCommand.getText());
            
        }
    }

    private void submitCommandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitCommandMouseClicked
        execCommand();
    }//GEN-LAST:event_submitCommandMouseClicked

    private void currentCommandKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_currentCommandKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            execCommand();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
           currentCommand.setText(commandHistory.get(HistoryIndex));
           
           if(HistoryIndex == 0) {
               HistoryIndex = commandHistory.size() - 1;
           } else {
               HistoryIndex--;
           }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
           
           currentCommand.setText(commandHistory.get(HistoryIndex));
           
           if(HistoryIndex < commandHistory.size() - 1) {
               HistoryIndex++;
           } else {
               HistoryIndex = 0;
           }
           
           
        }
    }//GEN-LAST:event_currentCommandKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea commandLogger;
    private javax.swing.JTextField currentCommand;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JLabel secsRemLabel;
    private javax.swing.JLabel secsRemLabelReal;
    private javax.swing.JButton submitCommand;
    // End of variables declaration//GEN-END:variables
}