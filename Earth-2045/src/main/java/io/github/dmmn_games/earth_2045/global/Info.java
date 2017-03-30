/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.global;

/**
 *
 * @author iordkost
 */
public class Info {
    private final String Name;
    private final String Desc;
    private final String Dev;
    private final String Copyright;
    private final String Website;
    private final String Version;
    
    public Info() {
        this.Name = "Earth 2045";
        this.Desc = "Earth 2045 : The End Of Free-Will";
        this.Dev = "DMMN Games";
        this.Copyright = "© 2017";
        this.Website = "https://DMMN-Games.GitHUB.IO";
        this.Version = "0.2.0.0 Pre-Alpha";
    }

    public String getName() {
        return Name;
    }

    public String getDesc() {
        return Desc;
    }

    public String getDev() {
        return Dev;
    }

    public String getCopyright() {
        return Copyright;
    }

    public String getWebsite() {
        return Website;
    }

    public String getVersion() {
        return Version;
    }

    
}
