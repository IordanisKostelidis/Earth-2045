/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.global;

/**
 *
 * @author iordkost
 */
public class Navigation {
    private final int North;
    private final String NorthString;
    
    private final int East;
    private final String EastString;
    
    private final int South;
    private final String SouthString;
    
    private final int West;
    private final String WestString;

    public Navigation() {
        this.North = 0;
        this.NorthString = "North".toLowerCase();
        
        this.East = 1;
        this.EastString = "East".toLowerCase();
        
        this.South = 2;
        this.SouthString = "South".toLowerCase();
                
        this.West = 3;
        this.WestString = "West".toLowerCase();
    }

    public int getNorth() {
        return North;
    }

    public int getEast() {
        return East;
    }

    public int getSouth() {
        return South;
    }

    public int getWest() {
        return West;
    }
    
    public String getLocation(int Location) {
        if(Location == North) {
            return NorthString;
        } else if (Location == East) {
            return EastString;
        } else if (Location == South) {
            return SouthString;
        } else if (Location == West) {
            return WestString;
        } else {
            return "Undefined".toLowerCase();
        }
    }
    
    public int getLocation(String Location) {
        if(Location.equals(NorthString)) {
            return North;
        } else if (Location.equals(EastString)) {
            return East;
        } else if (Location.equals(SouthString)) {
            return South;
        } else if (Location.equals(WestString)) {
            return West;
        } else {
            return -1;
        }
    }
    
    public int getNegativeLocation(int Location) {
        
        if(Location == this.North) {
            return this.South;
        } else if(Location == this.East) {
            return this.West;
        } else if(Location == this.South) {
            return this.North;
        } else if(Location == this.West) {
            return this.East;
        } else {
            return -1;
        }
        
    }
    
    
}
