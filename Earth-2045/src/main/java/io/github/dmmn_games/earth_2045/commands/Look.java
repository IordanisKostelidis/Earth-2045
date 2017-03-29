/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.enviroment.Floor;
import io.github.dmmn_games.earth_2045.enviroment.Room;
import io.github.dmmn_games.earth_2045.game.GameController;
import io.github.dmmn_games.earth_2045.global.JTextAreaCustom;
import io.github.dmmn_games.earth_2045.global.Navigation;
import javax.swing.JTextArea;

/**
 *
 * @author iordkost
 */
public class Look implements ICommand {

    private final String Command;

    public Look() {
        this.Command = "look";
    }

    @Override
    public String getCommand() {
        return this.Command;
    }

    @Override
    public void run(String[] Arguments, JTextArea History, GameController Game) {
        JTextAreaCustom currentHistory = new JTextAreaCustom(History);
        boolean isFound = false;
        if (Arguments.length == 1) {
            currentHistory.addLine("Look where ?");
        } else {
            if (Arguments[1].equals("around")) {

                int currentUserFloor = Game.getUser().getFloor();
                int currentUserRoom = Game.getUser().getRoom();

                Room currentRoom = Game.getFloor(currentUserFloor).getRoom(currentUserRoom);

                for (int i = 0; i < currentRoom.getTools().size(); i++) {
                    currentHistory.addLine(
                            "Tool Found : "
                            + currentRoom.getTools().get(i).getKeyID()
                    );
                }

                Floor currentFloor = Game.getFloor(currentUserFloor);
                Door tempDoor;
                for (int i = 0; i < currentFloor.getDoors().size(); i++) {
                    tempDoor = currentFloor.getDoors().get(i);
                    if (tempDoor.getRoomA() == currentUserRoom) {
                        currentHistory.addLine(
                                "Door Found : "
                                + tempDoor.getDoorId()
                        );
                        currentHistory.addLine(
                                "Door's Position : "
                                + new Navigation().getLocation(tempDoor.getPosA())
                        );
                    } else if (tempDoor.getRoomB() == currentUserRoom) {
                        currentHistory.addLine(
                                "Door Found : "
                                + tempDoor.getDoorId()
                        );
                        currentHistory.addLine(
                                "Door's Position : "
                                + new Navigation().getLocation(tempDoor.getPosB())
                        );
                    }
                }

            } else {

            }
        }
    }
}
