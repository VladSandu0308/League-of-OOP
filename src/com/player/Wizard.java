package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Wizard extends Player {
    public Wizard(int hp, int x, int y, Cell[][] map) {
        super(hp, x, y, map);
    }

    public void defendFirst(Wizard enemy) {
        enemy.attackFirst(this);
    }

    public void defendFirst(Pyromancer enemy) {
        enemy.attackFirst(this, Constants.PYROMANCER_ONE_WIZARD);
        enemy.attackSecond(this, Constants.PYROMANCER_TWO_WIZARD);
    }

    public void defendFirst(Rogue enemy) {
        enemy.attackFirst(this, Constants.ROGUE_ONE_WIZARD);
        enemy.attackSecond(this, Constants.ROGUE_TWO_WIZARD);
    }

    public void defendFirst(Knight enemy) {
        enemy.attackFirst(this, Constants.KNIGHT_ONE_WIZARD);
        enemy.attackSecond(this, Constants.KNIGHT_TWO_WIZARD);
    }

    public void attackFirst(Player enemy, double modifier) {

        int enemyHP = enemy.getHp();
        int maxHP = Math.round(Constants.WIZARD_ONE_MAX * enemy.getMaxHP())

        int damage = Math.min(enemyHP, maxHP);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += modifier * drain;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Constants.WIZARD_LAND_MODIFIER * drain;
        }
        drain *= damage;
        damage = Math.round(drain);

        enemy.changeHP(damage);

    }

    public void attackSecond(Player enemy, double modifier) {
        int damage = Constants.ROGUE_TWO_DAMAGE + super.getLevel() * Constants.ROGUE_TWO_DAMAGE_M;
        int dur = Constants.ROGUE_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            dur *= Constants.TWO;
        }

        damage += Math.round(modifier * damage);

        enemy.setDamageOverTime(damage);
        enemy.setDuration(dur);
        enemy.changeHP(damage);

        enemy.setStun(true);
    }


}
