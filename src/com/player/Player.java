package com.player;

public abstract class Player {

    private int hp;
    private int xp;
    private int level;
    private int x;
    private int y;

    public Player(int hp, int x, int y) {
        this.hp = hp;
        this.xp = 0;
        this.level = 0;
        this.x = x;
        this.y = y;
    }


}
