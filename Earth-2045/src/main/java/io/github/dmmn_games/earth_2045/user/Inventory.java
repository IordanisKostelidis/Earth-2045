/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.tools.ITool;
import java.util.List;

/**
 *
 * @author Spiros
 */
public class Inventory {
    
    List<ITool> tools;
    
    public Inventory() {
    }
    
    public List<ITool> getTools() {
        return tools;
    }
    
    public void add(ITool tool) {
        tools.add(tool);
    }
    
    public void remove(String toolName) throws Exception {
        ITool tempTool = find(toolName);
        if (tempTool == null) {
            throw new Exception("You dont have this tool");
        } else {
            tools.remove(tempTool);
            
        }
        
    }
    
    public ITool find(String toolName) {
        boolean found = false;
        ITool tempTool = null;
        for (int i = 0; i < tools.size(); i++) {
            tempTool = tools.get(i);
            if (tempTool.getKeyID().equals(toolName)) {
                found = true;
                break;
                
            }
            
        }
        if (!found) {
            
            return null;
        } else {
            
            return tempTool;
        }
    }
}
