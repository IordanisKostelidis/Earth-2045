/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.tools;

/**
 *
 * @author makis
 */
public class Key implements ITool {
    String KeyID;
    int ID;

    public Key(String KeyID, int ID) {
        this.KeyID = KeyID;
        this.ID = ID;
    }
    
    @Override
    public String getKeyID() {
        return KeyID;
    }
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getDamage() {
        return 0;
    }
    
    
}
