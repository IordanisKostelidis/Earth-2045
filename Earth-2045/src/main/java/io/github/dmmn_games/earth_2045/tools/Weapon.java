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
public class Weapon implements ITool {

    String toolName;
    int damage;

    public Weapon(String toolName, int damage) {
        this.toolName = toolName;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String getToolName() {
        return toolName;
    }

    @Override
    public int getToolValue() {
        return 0;
    }

}
