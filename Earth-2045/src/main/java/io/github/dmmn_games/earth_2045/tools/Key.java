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
    String toolName;
    int toolValue;

    public Key(String toolName, int toolValue) {
        this.toolName = toolName;
        this.toolValue = toolValue;
    }
    
    @Override
    public String getToolName() {
        return toolName;
    }
    
    @Override
    public int getToolValue() {
        return toolValue;
    }

    
}
