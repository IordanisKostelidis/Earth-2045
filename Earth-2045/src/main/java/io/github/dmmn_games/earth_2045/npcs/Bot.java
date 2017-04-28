package io.github.dmmn_games.earth_2045.npcs;

import java.io.Serializable;

public class Bot implements  Serializable {

    String name;

    int position;

    public Bot(String a, int pos) {
        this.name = a;
        this.position = pos;

    }

    public String getName() {
        return name;

    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String talk(String msg, String username) {
        String botmsg = "";

        if(msg.contains("hello")) {
            return "Hello " + username;
        } else if (msg.contains("you are ai") || msg.contains("what are you")) {
            return "No, i am a stupid static bot !";
        }else {
            return "What do you want " + username + "?";
        }


    }

}
