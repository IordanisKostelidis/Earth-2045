/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.commands_clones.*;
import io.github.dmmn_games.earth_2045.game.GameController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iordkost
 */
public class CommandsController implements Serializable {

    private final List<ICommand> Commands;
    private String[] listCommands;

    public CommandsController() {
        Commands = new ArrayList<>();
        this.initCommands();
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
        Commands.add(new Talk());
        Commands.add(new Take());
        Commands.add(new Shoot());

        // Cloned Commands
        Commands.add(new About());
        Commands.add(new Cls());
        Commands.add(new Pickup());
        Commands.add(new Quit());
        Commands.add(new WhereIAm());
        Commands.add(new WhoIAm());
        Commands.add(new Speak());

    }

    private String[] separateCommand(String Command) {
        return Command.
                toLowerCase().
                replaceAll("^\\s+|\\s+$", "").
                trim().replaceAll(" +", " ").
                split(" ");
    }

    public String runCommand(String command, GameController Game) {

        String Response = "";

        listCommands = separateCommand(command);

        boolean commandFound = false;
        for (int i = 0; i < Commands.size(); i++) {
            if (listCommands[0].equals(Commands.get(i).getCommand())) {
                commandFound = true;
                Commands.get(i).run(listCommands, Game.getUser());
                break;
            }
        }

        if (!commandFound) {
            Response += "Command not found !";
        }
        
        return Response;
    }
}
