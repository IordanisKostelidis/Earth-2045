package io.github.dmmn_games.earth_2045.npcs;

import io.github.dmmn_games.earth_2045.forms.BotConversation;
import java.io.Serializable;

public class Bot implements  Serializable {

    String name;
    
    int position;

    public Bot()
    {
        
    }
    
    

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

    //triggers the conversation between user and bot with a previous History system to make if statement
   /* public void botConversation(BotConversation frame)
    {
        if (frame.previousHistory.equals(frame.botQuestion[0]) && frame.History.toLowerCase().matches("yes"))
        {
            botTalk(frame.botQuestion[1]);
            botTalk(frame.botQuestion[2]);
        } else if (frame.previousHistory.equals(frame.botQuestion[2]) && frame.History.toLowerCase().matches("human"))
        {
            botTalk(frame.botQuestion[3]);
            frame.enableExitButton();
        }
    }*/

    
// makes the bot talk saying the String argument
    /*public void botTalk(String s, BotConversation frame)
    {
        frame.conversation.append("Bot: " + s + "\n\n");
        frame.previousHistory = s;
    }*/

}
