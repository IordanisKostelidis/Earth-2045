package io.github.dmmn_games.earth_2045.npcs;

import io.github.dmmn_games.earth_2045.user.User;
import java.io.Serializable;

public class Enemy implements Serializable {

    private boolean alive;
    private String name;
    private int health;

    public Enemy(boolean alive, String name, int health) {
        this.alive = alive;
        this.name = name;
        this.health = health;
    }

    public void shoot(User user) {

        user.receiveDamage(10);

    }

    public void receiveDamage(int damage) {

        health = health - damage;
        if (health <= 0) {
            alive = false;
        }

    }

    public int getHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

}
