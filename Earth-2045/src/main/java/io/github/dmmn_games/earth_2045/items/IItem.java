/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.items;

import java.io.Serializable;

/**
 *
 * @author iordkost
 */
public interface IItem extends Serializable {
    public String getItemName();
    public String getItemValue();
}
