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
    String doorId;
    int sideA;
    int sideB;
    int IdPass;
    boolean isOpen;

    public Door(String doorId, int sideA, int sideB, int IdPass, boolean isOpen) {
        this.doorId = doorId;
        this.sideA = sideA;
        this.sideB = sideB;
        this.IdPass = IdPass;
        this.isOpen = isOpen;
    }

    public String getDoorId() {
        return doorId;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public int getIdPass() {
        return IdPass;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

   
    
    
}
