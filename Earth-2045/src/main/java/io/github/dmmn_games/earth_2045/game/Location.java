/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.game;

/**
 *
 * @author iordkost
 */
public enum Location {
    NORTH, WEST, SOUTH, EAST;
    
    
    public Location getNegativeLocation() {
        switch(this) {
            case NORTH: {
                return SOUTH;
            }
            case SOUTH: {
                return NORTH;
            }
            case EAST: {
                return WEST;
            }
            case WEST: {
                return EAST;
            }
            default: {
                return this;
            }
        }
    }

}
