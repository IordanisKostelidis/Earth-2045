/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.doors;

import io.github.dmmn_games.earth_2045.global.Navigation;

/**
 *
 * @author iordkost
 */
public class Door {
    private String doorId;
    private int roomA;
    private int roomB;
    private int posA;
    private int posB;
    private int IdPass;
    private boolean isOpen;

    public Door(String doorId, int roomA, int roomB, int posA, int IdPass, boolean isOpen) {
        this.doorId = doorId;
        this.roomA = roomA;
        this.roomB = roomB;
        this.posA = posA;
        this.posB = new Navigation().getNegativeLocation(posA);
        this.IdPass = IdPass;
        this.isOpen = isOpen;
        
      
    }

    public String getDoorId() {
        return doorId;
    }

    public int getRoomA() {
        return roomA;
    }

    public int getRoomB() {
        return roomB;
    }

    public int getPosA() {
        return posA;
    }

    public int getPosB() {
        return posB;
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
