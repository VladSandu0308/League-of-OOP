package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Pyromancer extends Player {

    public Pyromancer(int hp, int x, int y, Cell[][] map) {
        super(hp, x, y, map);
    }

    public void defend(Wizard enemy) {
        enemy.attackFirst(this);
    }

    public void defend(Pyromancer enemy) {
        enemy.attackFirst(this, Constants.PYROMANCER_ONE_PYROMANCER);
        enemy.attackSecond(this, Constants.PYROMANCER_TWO_PYROMANCER);
    }

    public void defend(Rogue enemy) {
        enemy.attackFirst(this, Constants.ROGUE_ONE_PYROMANCER);
        enemy.attackSecond(this, Constants.ROGUE_TWO_PYROMANCER);
    }

    public void defend(Knight enemy) {
        enemy.attackFirst(this, Constants.KNIGHT_ONE_PYROMANCER);
        enemy.attackSecond(this,Constants.KNIGHT_TWO_PYROMANCER);
    }

    public void attackFirst(Player enemy, double modifier) {
        int damage = Constants.PYROMANCER_ONE_DAMAGE + super.getLevel() * Constants.PYROMANCER_ONE_DAMAGE_M;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.PYROMANCER_LAND_MODIFIER * damage);
        }

        damage += Math.round(modifier * damage);
        enemy.changeHP(damage);

    }

    public void attackSecond(Player enemy, double modifier) {
        int damage = Constants.PYROMANCER_TWO_DAMAGE + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M1;
        int dur = Constants.PYROMANCER_TWO_DURTAION;
        int damageNext = Constants.PYROMANCER_TWO_DAMAGE_OT + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M2;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            damageNext += Math.round(Constants.ROGUE_LAND_MODIFIER * damageNext);
        }

        damage += Math.round(modifier * damage);
        damageNext += Math.round(modifier * damageNext)
        enemy.setDamageOverTime(damageNext);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }
}
