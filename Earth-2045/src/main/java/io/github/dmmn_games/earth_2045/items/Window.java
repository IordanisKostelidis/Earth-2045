/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.items;

/**
 *
 * @author iordkost
 */
public class Window implements IItem {

    String itemName;
    String itemValue;

    public Window(String itemName, String itemValue) {
        this.itemName = itemName;
        this.itemValue = itemValue;
    }

    @Override
    public String getItemName() {
        return this.itemName;
    }

    @Override
    public String getItemValue() {
        return this.itemValue;
    }

}
