/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.commands;

import io.github.dmmn_games.earth_2045.user.User;
import java.io.Serializable;

/**
 *
 * @author iordkost
 */
public interface ICommand extends Serializable {

    String getCommand();
    String run(String[] commandArguments, User user);
    
}
