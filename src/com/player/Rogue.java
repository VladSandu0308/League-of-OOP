package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Rogue extends Player {
    public Rogue(int hp, int x, int y, Cell[][] map) {
        super(hp, x, y, map);
    }

    int count = 0;

    public void attackFirst(Wizard enemy) {
        int damage = Constants.ROGUE_ONE_DAMAGE + super.getLevel() * 20;
        count++;
        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            if (count % 3 == 0) {
                damage += Math.round(Constants.ROGUE_LAND_BONUS * damage)
            }
        }

        damage += Math.round(Constants.ROGUE_ONE_WIZARD * damage);

        enemy.changeHP(damage);
        count++;


    }

    public void attackFirst(Pyromancer enemy) {

    }

    public void attackFirst(Rogue enemy) {

    }

    public void attackFirst(Knight enemy) {

    }

    public void attackSecond(Wizard enemy) {

    }

    public void attackSecond(Pyromancer enemy) {

    }

    public void attackSecond(Rogue enemy) {

    }

    public void attackSecond(Knight enemy) {

    }
}
