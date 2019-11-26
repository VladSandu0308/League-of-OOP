package com.player;

import com.map.Cell;

public abstract class Player {

    private int hp;
    private int xp;
    private int level;
    private int x;
    private int y;
    private Cell[][] map;

    public Player(int hp, int x, int y, Cell[][] map) {
        this.hp = hp;
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

    public void changeHP (int health) {
        this.hp -= health;
    }
}
