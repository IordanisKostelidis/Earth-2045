/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.doors;

/**
 *
 * @author iordkost
 */
public class Door {
    int currentDoor;
    int nextDoor;
    int IdPass;
    boolean isOpen;

    public Door(int currentDoor, int nextDoor, int IdPass, boolean isOpen) {
        this.currentDoor = currentDoor;
        this.nextDoor = nextDoor;
        this.IdPass = IdPass;
        this.isOpen = isOpen;
    }

    public int getCurrentDoor() {
        return currentDoor;
    }

    public int getNextDoor() {
        return nextDoor;
    }

    public int getIdPass() {
        return IdPass;
    }

    public boolean isIsOpen() {
        return isOpen;
    }
    
    
}
