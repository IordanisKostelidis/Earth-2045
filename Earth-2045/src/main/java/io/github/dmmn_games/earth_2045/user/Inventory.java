/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.user;

import io.github.dmmn_games.earth_2045.tools.ITool;
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
            if (tempTool.getKeyID().equals(toolName)) {
                found = true;
                break;
            }

        }
        if (!found) {
            throw new Exception("You don't have this tool !!!");
        } else {
            return tempTool;
        }
    }
}
