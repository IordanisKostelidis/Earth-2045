package io.github.dmmn_games.earth_2045.npcs;

import io.github.dmmn_games.earth_2045.tools.ITool;
import java.io.Serializable;

public class Bot implements  Serializable {

    String name;
    String question;
    String answer;
    String succesAnswer = "Congrats take this Tool it will help you";
    String failAnswer = "Wrong answer";
    
    
    ITool tool;
    
    
    
    boolean chatFlag;
    
    private int flowCheck;                               
    
    
    

    public Bot()
    {
        
    }
    
    

    public Bot(String a,String question ,String answer,ITool tool) {
        this.name = a;
        
        this.question = question;
        this.answer = answer;
        
        this.tool = tool;

    }

    public String getSuccesAnswer()
    {
        return succesAnswer;
    }

    public void setSuccesAnswer(String succesAnswer)
    {
        this.succesAnswer = succesAnswer;
    }

    public String getFailAnswer()
    {
        return failAnswer;
    }

    public void setFailAnswer(String failAnswer)
    {
        this.failAnswer = failAnswer;
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

    

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public ITool getTool()
    {
        return tool;
    }

    public void setTool(ITool tool)
    {
        this.tool = tool;
    }

    
    
    public String talk(String s){
        
        
        if (s.matches(answer)){
            return succesAnswer;
        }
        
        else{
            return failAnswer;
        }
        
        
        
        
        
    }
    
    /*public String talk(String msg, String username) {
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

    }*/
    
    /*public boolean userAnswerCheck(String s,int a){
        
        int i;
        for(i = 0; i < userAnswer[flowCheck].length; i++){
            
            if(s.matches(userAnswer[a][i])){
                return true;
            }
            
            
        }
        
        
        return false;
        
    }*/


    

}
