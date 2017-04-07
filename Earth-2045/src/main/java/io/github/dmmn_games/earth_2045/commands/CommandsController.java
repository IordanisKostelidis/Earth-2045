/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.commands_clones.*;
import io.github.dmmn_games.earth_2045.game.CommandUI;
import io.github.dmmn_games.earth_2045.game.GameController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author iordkost
 */
public class CommandsController implements java.io.Serializable {

    private final List<ICommand> Commands;
    private boolean canDoCommand;
    private CommandUI currentHistory;
    private String[] listCommands;

    public CommandsController() {
        Commands = new ArrayList<>();
        this.initCommands();
        this.canDoCommand = true;
    }

    private void initCommands() {
        // General Commands
        Commands.add(new Clear());
        Commands.add(new Info());
        Commands.add(new Help());
        Commands.add(new Man());
        Commands.add(new Exit());
        Commands.add(new Copyright());

        // User Info
        Commands.add(new Status());
        Commands.add(new WhoAmI());
        Commands.add(new WhereAmI());

        // User Actions
        Commands.add(new Go());
        Commands.add(new Look());
        Commands.add(new Pick());
        Commands.add(new Use());

        // Save Load
        Commands.add(new Save());
        Commands.add(new Load());

        // Cloned Commands
        Commands.add(new About());
        Commands.add(new Cls());
        Commands.add(new Pickup());
        Commands.add(new Quit());
        Commands.add(new Take());
        Commands.add(new WhereIAm());
        Commands.add(new WhoIAm());

    }

    private String[] separateCommand(JTextField Command) {
        return Command.getText().
                toLowerCase().
                replaceAll("^\\s+|\\s+$", "").
                trim().replaceAll(" +", " ").
                split(" ");
    }

    public void runCommand(JTextField Command, JTextArea History, GameController Game) {

        if (canDoCommand) {
            currentHistory = new CommandUI(History);
            listCommands = separateCommand(Command);

            boolean commandFound = false;
            for (int i = 0; i < Commands.size(); i++) {
                if (listCommands[0].equals(Commands.get(i).getCommand())) {
                    commandFound = true;
                    Commands.get(i).run(listCommands, History, Game);
                    break;
                }
            }

            if (!commandFound) {
                currentHistory.addLine("Command not found !");

            }
            Command.setText("");
        }
    }

    public boolean isCanDoCommand() {
        return canDoCommand;
    }

    public void setCanDoCommand(boolean canDoCommand) {
        this.canDoCommand = canDoCommand;
    }

}
