package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Knight extends Player {
    public Knight(int hp, int x, int y, Cell[][] map) {
        super(hp, x, y, map);
    }

    public void defend(Wizard enemy) {
        enemy.attackFirst(this);
    }

    public void defend(Pyromancer enemy) {
        enemy.attackFirst(this, Constants.PYROMANCER_ONE_KNIGHT);
        enemy.attackSecond(this, Constants.PYROMANCER_TWO_KNIGHT);
    }

    public void defend(Rogue enemy) {
        enemy.attackFirst(this, Constants.ROGUE_ONE_KNIGHT);
        enemy.attackSecond(this, Constants.ROGUE_TWO_KNIGHT);
    }

    public void defend(Knight enemy) {
        enemy.attackFirst(this, Constants.KNIGHT_ONE_KNIGHT);
        enemy.attackSecond(this,Constants.KNIGHT_TWO_KNIGHT);
    }

    public void attackFirst(Player enemy, double modifier) {
        int damage = Constants.KNIGHT_ONE_DAMAGE + super.getLevel() * Constants.KNIGHT_ONE_DAMAGE_M;
        double hp = (double)(enemy.getHp() / enemy.getMaxHP());
        double limit = Constants.KNIGHT_ONE_LIMIT + super.getLevel();
        if ( hp > Constants.KNIGHT_ONE_LIMIT ) {
            if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
                damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
            }

            damage += Math.round(modifier * damage);
            enemy.changeHP(damage);
        } else {
            enemy.changeHP(enemy.getHp());
        }

    }

    public void attackSecond(Player enemy, double modifier) {
        int damage = Constants.KNIGHT_TWO_DAMAGE + super.getLevel() * Constants.KNIGHT_TWO_DAMAGE_M;
        int dur = Constants.KNIGHT_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
            damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
        }

        damage += Math.round(modifier * damage);

        enemy.setStun(true);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }

}
