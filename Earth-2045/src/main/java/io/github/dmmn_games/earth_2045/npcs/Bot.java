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

    public String talk(String msg) {
        String botmsg = "";

        switch (msg) {
            case "talk scientist":
                botmsg = "fuck you DELI";
                break;

            case "talk prisoner":
                botmsg = "Zaxaritsa kai lili sto stoma";
                break;

            default:
                botmsg = "Learn how to talk correctly pal";
                break;
        }

        return botmsg;
    }

}
