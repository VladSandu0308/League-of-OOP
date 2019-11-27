package com.player;

import com.map.Cell;

public abstract class Player {

    private int hp;
    private int maxHP;
    private int xp;
    private int level;
    private int x;
    private int y;
    private Cell[][] map;

    private boolean stun = false;
    private int damageOverTime = 0;
    private int duration = 0;

    public Player(int hp, int x, int y, Cell[][] map) {
        this.hp = hp;
        this.maxHP = hp;
        this.xp = 0;
        this.level = 0;
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cell[][] getMap() {
        return map;
    }

    public boolean isStun() {
        return stun;
    }

    public int getDamageOverTime() {
        return damageOverTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDamageOverTime(int damageOverTime) {
        this.damageOverTime = damageOverTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void changeHP (int health) {
        this.hp -= health;
    }


}
