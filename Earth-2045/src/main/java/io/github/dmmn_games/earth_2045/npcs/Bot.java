package io.github.dmmn_games.earth_2045.npcs;

import io.github.dmmn_games.earth_2045.forms.BotConversation;
import io.github.dmmn_games.earth_2045.tools.Weapon;
import java.io.Serializable;

public class Bot implements  Serializable {

    String name;
    public String botQuestion [] = {"Who are you? Are you here to save us?\n\n",
                                    "I'm gonna give you the key to open the last floor\nbut first you have to solve a riddle to prove that you are the chosen one\n\nWhat walks on 4 legs when its morning,on 2 legs at noon\nand on 3 legs in the evening?\n\n",
                                    "Congratulations. Take this weapon to fight them\nNow go... we are running out of time",
                                    "Answer the question correctly please.\n\n"}; //Bot talking phrases.
    
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
        //TODO this.weapon = weapon;

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

        if(userAnswerCheck(msg,flowCheck) && flowCheck == 0) {
            botmsg = botQuestion[1];
            setFlowCheck(1);
            
        } 
        
        else if (userAnswerCheck(msg,flowCheck) && flowCheck == 1) {
            botmsg = botQuestion[2];
            setFlowCheck(2);
        }
        
        
        
        else {
            botmsg = botQuestion[3];
        }

         return botmsg;

    }
    
    public boolean userAnswerCheck(String s,int a){
        
        int i;
        for(i = 0; i < userAnswer[0].length; i++){
            
            if(s.matches(userAnswer[a][i])){
                return true;
            }
            
            
        }
        
        
        return false;
        
    }
    
    

    

}
