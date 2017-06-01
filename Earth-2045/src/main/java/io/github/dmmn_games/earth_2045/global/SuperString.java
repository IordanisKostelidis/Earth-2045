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
public class SuperString implements java.io.Serializable{

    String[] content;

    public SuperString(String[] content) {
        this.content = content;
    }

    public String[] getContent() {
        return content;
    }

    public String getString(int removeLimit) {
        String Updated = "";

        for (int i = removeLimit; i < content.length; i++) {
            if(i == removeLimit) {
                Updated += content[i];
            } else {
                Updated += " ";
                Updated += content[i];
            }
            
        }

        return Updated;
    }
}
