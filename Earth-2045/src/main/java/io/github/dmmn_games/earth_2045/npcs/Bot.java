
package io.github.dmmn_games.earth_2045.npcs;



public class Bot
{

    
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
