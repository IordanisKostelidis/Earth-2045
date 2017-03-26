/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.game.GameController;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author iordkost
 */
public class CommandsController {
    private final ArrayList<ICommand> Commands;

    public CommandsController() {
        Commands = new ArrayList<>();
        this.initCommands();
    }
    
    private void initCommands() {
        Commands.add(new Clear());
        Commands.add(new Help());
        Commands.add(new Exit());
        Commands.add(new Save());
        Commands.add(new Load());
    }
    
    private String removeSpaces(JTextField Command) {
        System.err.println(Command.getText().replaceAll("^\\s+|\\s+$", "").trim().replaceAll(" +", " "));
        return Command.getText().replaceAll("^\\s+|\\s+$", "").trim().replaceAll(" +", " ");
    }
    
    private String[] separateCommand(String Command) {
        String[] Commands = Command.split(" ");    
        return Commands;
    }
    
    public void runCommand(JTextField Command, JTextArea History, GameController Game) {
        
        String CleanedCommand = removeSpaces(Command);
        String[] listCommands = separateCommand(CleanedCommand);
        
        boolean commandFound = false;
        
        for(int i = 0; i<Commands.size(); i++) {
            if(listCommands[0].equals(Commands.get(i).getCommand())) {
                commandFound = true;
                Command.setText("");
                Commands.get(i).run(listCommands, History, Game);
                break;
            }
        }
        
        if(!commandFound) {
            History.setText(
                    History.getText() + "This is not a valid command !" + "\n"
            );
            Command.setText("");
        }
    }
    
}
