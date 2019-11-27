package com.player;

import com.map.Cell;

public abstract class Player {

    private int hp;
    private int maxHP;
    private int xp;
    private int level;
    private int x;
    private int y;
    private String type;
    private Cell[][] map;

    private boolean stun = false;
    private int damageOverTime = 0;
    private int duration = 0;
    private int baseDamage = 0;

    public Player(String type, int hp, int x, int y, Cell[][] map) {
        this.hp = hp;
        this.maxHP = hp;
        this.xp = 0;
        this.level = 0;
        this.type = type;
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp += xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int xp) {
        this.level = (xp - 250) / 50;
        if (this.level < 0) {
            this.level = 0;
        }

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

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage += baseDamage;
    }

    public void resetBaseDamage() {
        this.baseDamage = 0;
    }

    public void overTimeDamage() {
        if (this.duration > 0) {
            this.changeHP(this.damageOverTime);
        }
        this.duration--;
        if (this.duration == 0) {
            this.stun = false;
            this.damageOverTime = 0;
        }
    }

    public void moveUp() {
        this.x ++;
    }

    public void moveDown() {
        this.x --;
    }

    public void moveRight() {
        this.y ++;
    }

    public void moveLeft() {
        this.y --;
    }

    /*public abstract void defend(Knight x);

    public abstract void defend(Pyromancer x);

    public abstract void defend(Rogue x);

    public abstract void defend(Wizard x);*/

    public abstract void defend(Player enemy);

    protected abstract void attackFirst(Rogue enemy);

    protected abstract void attackFirst(Wizard enemy);

    protected abstract void attackFirst(Knight enemy);

    protected abstract void attackFirst(Pyromancer enemy);

    protected abstract void attackSecond(Rogue enemy);

    protected abstract void attackSecond(Knight enemy);

    protected abstract void attackSecond(Pyromancer enemy);

    protected abstract void attackSecond(Wizard enemy);
}
