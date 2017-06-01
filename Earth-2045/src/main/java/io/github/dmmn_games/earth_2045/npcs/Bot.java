package io.github.dmmn_games.earth_2045.npcs;

import io.github.dmmn_games.earth_2045.forms.BotConversation;
import io.github.dmmn_games.earth_2045.tools.Weapon;
import java.io.Serializable;

public class Bot implements  Serializable {

    String name;
    public String botQuestion [] = {"Who are you? Are you here to save us?\n\n",
                                    "I'm gonna give you the key to open the last floor\nbut first you have to solve a riddle to prove that you are the chosen one\n\nWhat walks on 4 legs when its morning,on 2 legs at noon\nand on 3 legs in the evening?\n\n",
                                    "Congratulations. Take this weapon to fight them\nNow go... we are running out of time",
                                    "Answer the question mate.\n\n"}; //Bot talking phrases.
    
    public String userAnswer [] [] = {{"yes","ofc","i am here","im here","of course","y"},
                                      {"human","man","the human","the man"}};
                        
    private int flowCheck;                               
    int position;
    Weapon weapon;
    

    public Bot()
    {
        
    }
    
    

    public Bot(String a, int pos) {
        this.name = a;
        this.position = pos;

    }

    public String[] getBotQuestion()
    {
        return botQuestion;
    }

    public void setBotQuestion(String[] botQuestion)
    {
        this.botQuestion = botQuestion;
    }

    public int getFlowCheck()
    {
        return flowCheck;
    }

    public void setFlowCheck(int flowCheck)
    {
        this.flowCheck = flowCheck;
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

        if(msg.contains(userAnswer[0][0]) && flowCheck == 0) {
            botmsg = getName() + ": " + botQuestion[1];
            setFlowCheck(1);
            
        } 
        
        else if (msg.contains(userAnswer[1][0]) && flowCheck == 1) {
            botmsg = getName() + ": " + botQuestion[2];
            setFlowCheck(2);
        }
        
        
        
        else {
            botmsg = getName() + ": " + botQuestion[3];
        }

         return botmsg;

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
