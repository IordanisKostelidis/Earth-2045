
package io.github.dmmn_games.earth_2045.npcs;



public class Bot
{

    String name;

    public Bot(String a)
    {
        this.name = a;
        
    }

    public String getName()
    {
        return name;
    }
    
    
    
    public String talk(String msg)
    {
        String botmsg = "";
        
        switch (msg)
        {
            case "talk bot" : botmsg = "fuck you DELI";
            break;
            
            default : botmsg = "degempesoemta";
            break;
        }
        
        return botmsg;
    }
    
    
}
