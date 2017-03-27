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
    private final int East;
    private final int South;
    private final int West;

    public Navigation() {
        this.North = 0;
        this.East = 1;
        this.South = 2;
        this.West = 3;
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
}
