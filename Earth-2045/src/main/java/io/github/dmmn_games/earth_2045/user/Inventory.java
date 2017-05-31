/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.tools.ITool;
import io.github.dmmn_games.earth_2045.tools.Weapon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikos
 */
public class Inventory implements Serializable {

    List<ITool> tools;

    public Inventory() {
        tools = new ArrayList<>();
    }

    public List<ITool> getTools() {
        return tools;
    }

    public void add(ITool tool) {
        tools.add(tool);
    }

    public void remove(String toolName) throws Exception {
        ITool tempTool = find(toolName);
        tools.remove(tempTool);

    }

    public ITool find(String toolName) throws Exception {
        boolean found = false;
        ITool tempTool = null;
        for (int i = 0; i < tools.size(); i++) {
            tempTool = tools.get(i);
            if (tempTool.getToolName().equals(toolName)) {
                found = true;
                break;
            }

        }
        if (!found) {
            throw new Exception("You don't have " + toolName + " !!!");
        } else {
            return tempTool;
        }
    }

    public boolean findKey(int doorid) {
        for (int i = 0; i < this.tools.size(); i++) {
            if (tools.get(i).getToolValue() == doorid) {
                return true;
            }

        }

        return false;
    }

    public int findWeapondmg() {
        Weapon tmpWpn = null;

        // Search all tools and find the weapon
        for (ITool temptool : tools) {
            if (temptool.getClass() == Weapon.class) {
                tmpWpn = (Weapon) temptool;
                break;
            }
        }

        // Weapon found
        if (null != tmpWpn) {
            return tmpWpn.getDamage();
        } else {
            return 1; // Bare Hand Damage
        }

    }
    public String[] getToolName(){
    String[] tempTools =new String[this.tools.size()];
    for(int i=0;i<tools.size();i++)
    {   
        tempTools[i]=this.tools.get(i).getToolName();
    
    
    }
    
    return tempTools;
    }
}
