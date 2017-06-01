package io.github.dmmn_games.earth_2045.npcs;

import io.github.dmmn_games.earth_2045.forms.BotConversation;
import io.github.dmmn_games.earth_2045.tools.ITool;
import io.github.dmmn_games.earth_2045.tools.Weapon;
import java.io.Serializable;

public class Bot implements Serializable
{

    private String name;
    private String question;
    private String answer;
    private final String succesAnswer = "Congrats take this Tool it will help you";
    private final String failAnswer = "Wrong answer";

    ITool tool;

    boolean chatFlag;

    private int flowCheck;

    public Bot()
    {

    }

    public Bot(String name, String question, String answer, ITool tool)
    {
        this.name = name;

        this.question = question;
        this.answer = answer;

        this.tool = tool;

    }

    public boolean isChatFlag()
    {
        return chatFlag;
    }

    public void setChatFlag(boolean chatFlag)
    {
        this.chatFlag = chatFlag;
    }

    public String getSuccesAnswer()
    {
        return succesAnswer;
    }

    public String getFailAnswer()
    {
        return failAnswer;
    }

    public int getFlowCheck()
    {
        return flowCheck;
    }

    public void setFlowCheck(int flowCheck)
    {
        this.flowCheck = flowCheck;
    }

    public String getName()
    {
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

    public String talk(String s)
    {

        if (s.matches(answer))
        {
            return succesAnswer;
        } else
        {
            return failAnswer;
        }

    }

    public void removeTool()
    {
        this.tool = null;
    }

}
