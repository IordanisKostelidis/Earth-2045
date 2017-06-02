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

    private final List<ICommand> commands;

    public CommandsController() {
        commands = new ArrayList<>();
        this.initCommands();
    }

    private void initCommands() {
        // General Commands
        commands.add(new Clear());
        commands.add(new Info());
        commands.add(new Help());
        commands.add(new Man());
        commands.add(new Exit());
        commands.add(new Copyright());

        // User Info
        commands.add(new Status());
        commands.add(new WhoAmI());
        commands.add(new WhereAmI());

        // User Actions
        commands.add(new Go());
        commands.add(new Look());
        commands.add(new Pick());
        commands.add(new Talk());
        commands.add(new Take());
        commands.add(new Shoot());

        // Cloned Commands
        commands.add(new About());
        commands.add(new Cls());
        commands.add(new Kill());
        commands.add(new Pickup());
        commands.add(new Quit());
        commands.add(new WhereIAm());
        commands.add(new WhoIAm());
        commands.add(new Speak());

    }

    private String[] separateCommands(String command) {
        return command.
                toLowerCase().
                replaceAll("^\\s+|\\s+$", "").
                trim().replaceAll(" +", " ").
                split(" ");
    }

    public String runCommand(String command, GameController game) {

        String[] listCommands = separateCommands(command);

        for (int i = 0; i < commands.size(); i++) {
            if (listCommands[0].equals(commands.get(i).getCommand())) {
                return commands.get(i).run(listCommands, game.getUser());
            }
        }
        return "Command not found !";
    }
}
