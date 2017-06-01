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
    private final String name;
    private final String desc;
    private final String dev;
    private final String copyright;
    private final String website;
    private final String version;
    
    public Info() {
        this.name = "Earth 2045";
        this.desc = "Earth 2045 : The End Of Free-Will";
        this.dev = "DMMN Games";
        this.copyright = "© 2017";
        this.website = "https://DMMN-Games.GitHUB.IO";
        this.version = "0.5.1.2 Alpha";
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getDev() {
        return dev;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getWebsite() {
        return website;
    }

    public String getVersion() {
        return version;
    }

    
}
