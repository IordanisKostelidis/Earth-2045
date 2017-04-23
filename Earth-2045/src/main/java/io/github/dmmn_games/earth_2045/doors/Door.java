/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.doors;

import io.github.dmmn_games.earth_2045.game.Location;
import java.io.Serializable;

/**
 *
 * @author iordkost
 */
public class Door implements Serializable {

    private final String doorID;
    private final int roomA;
    private final int roomB;
    private final Location posA;
    private final Location posB;
    private final int passID;
    private boolean isOpen;

    public Door(String doorId, int roomA, int roomB, Location posA, int IdPass, boolean isOpen) {
        this.doorID = doorId;
        this.roomA = roomA;
        this.roomB = roomB;
        this.posA = posA;
        this.posB = this.posA.getNegativeLocation();
        this.passID = IdPass;
        this.isOpen = isOpen;

    }

    public String getDoorId() {
        return doorID;
    }

    public int getRoomA() {
        return roomA;
    }

    public int getRoomB() {
        return roomB;
    }

    public Location getPosA() {
        return posA;
    }

    public Location getPosB() {
        return posB;
    }

    public int getIdPass() {
        return passID;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

}
