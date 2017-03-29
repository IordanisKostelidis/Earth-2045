/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.enviroment;

import io.github.dmmn_games.earth_2045.doors.Door;
import io.github.dmmn_games.earth_2045.items.*;
import io.github.dmmn_games.earth_2045.tools.*;
import java.util.*;

/**
 *
 * @author makis
 */
public class Room {
    
    private ArrayList<ITool> tools= new ArrayList<ITool>();
    private ArrayList<IItem> items= new ArrayList<IItem>();


    public Room() {
        this.tools = new ArrayList<>();
        this.items = new ArrayList<>();
    }
    
    
    public void addKey(Key newKey){
        tools.add(newKey);
    }

    public ArrayList<ITool> getTools() {
        return tools;
    }

    public void setTools(ArrayList<ITool> tools) {
        this.tools = tools;
    }

    public ArrayList<IItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<IItem> items) {
        this.items = items;
    }
    
    
    
    
}
