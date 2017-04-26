
package io.github.dmmn_games.earth_2045.npcs;



public class Bot
{

    String name;
    
    int position;

    

    public Bot(String a)
    {
        this.name = a;
        
    }

    public String getName()
    {
        return name;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }
    
    
    
    public String talk(String msg)
    {
        String botmsg = "";
        
        switch (msg)
        {
            case "talk scientist" : botmsg = "fuck you DELI";
            break;
            
            case "talk prisoner" : botmsg = "Zaxaritsa kai lili sto stoma";
            break;
            
            default : botmsg = "Learn how to talk correctly pal";
            break;
        }
        
        return botmsg;
    }
    
    
}
