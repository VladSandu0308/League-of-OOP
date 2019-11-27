package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Pyromancer extends Player {

    public Pyromancer(String type, int hp, int x, int y, Cell[][] map) {
        super(type, hp, x, y, map);
    }

    public void defend(Player enemy) {
        enemy.attackFirst(this);
        enemy.attackSecond(this);
    }

    /*public void defend(Wizard enemy) {
        enemy.attackFirst(this, Constants.WIZARD_ONE_PYROMANCER);
        enemy.attackFirst(this, Constants.WIZARD_TWO_PYROMANCER);
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
    }*/

    public void attackFirst(Knight enemy) {
        int damage = Constants.PYROMANCER_ONE_DAMAGE + super.getLevel() * Constants.PYROMANCER_ONE_DAMAGE_M;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.PYROMANCER_LAND_MODIFIER * damage);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.PYROMANCER_ONE_KNIGHT * damage);
        enemy.changeHP(damage);
    }

    public void attackFirst(Wizard enemy) {
        int damage = Constants.PYROMANCER_ONE_DAMAGE + super.getLevel() * Constants.PYROMANCER_ONE_DAMAGE_M;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.PYROMANCER_LAND_MODIFIER * damage);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.PYROMANCER_ONE_WIZARD * damage);
        enemy.changeHP(damage);
    }

    public void attackFirst(Rogue enemy) {
        int damage = Constants.PYROMANCER_ONE_DAMAGE + super.getLevel() * Constants.PYROMANCER_ONE_DAMAGE_M;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.PYROMANCER_LAND_MODIFIER * damage);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.PYROMANCER_ONE_ROGUE * damage);
        enemy.changeHP(damage);
    }

    public void attackFirst(Pyromancer enemy) {
        int damage = Constants.PYROMANCER_ONE_DAMAGE + super.getLevel() * Constants.PYROMANCER_ONE_DAMAGE_M;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.PYROMANCER_LAND_MODIFIER * damage);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.PYROMANCER_ONE_PYROMANCER * damage);
        enemy.changeHP(damage);
    }

    public void attackSecond(Knight enemy) {
        int damage = Constants.PYROMANCER_TWO_DAMAGE + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M1;
        int dur = Constants.PYROMANCER_TWO_DURTAION;
        int damageNext = Constants.PYROMANCER_TWO_DAMAGE_OT + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M2;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            damageNext += Math.round(Constants.ROGUE_LAND_MODIFIER * damageNext);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.PYROMANCER_TWO_KNIGHT * damage);
        damageNext += Math.round(Constants.PYROMANCER_TWO_KNIGHT * damageNext);
        enemy.setDamageOverTime(damageNext);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }

    public void attackSecond(Wizard enemy) {
        int damage = Constants.PYROMANCER_TWO_DAMAGE + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M1;
        int dur = Constants.PYROMANCER_TWO_DURTAION;
        int damageNext = Constants.PYROMANCER_TWO_DAMAGE_OT + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M2;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            damageNext += Math.round(Constants.ROGUE_LAND_MODIFIER * damageNext);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.PYROMANCER_TWO_WIZARD * damage);
        damageNext += Math.round(Constants.PYROMANCER_TWO_WIZARD * damageNext);
        enemy.setDamageOverTime(damageNext);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }

    public void attackSecond(Rogue enemy) {
        int damage = Constants.PYROMANCER_TWO_DAMAGE + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M1;
        int dur = Constants.PYROMANCER_TWO_DURTAION;
        int damageNext = Constants.PYROMANCER_TWO_DAMAGE_OT + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M2;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            damageNext += Math.round(Constants.ROGUE_LAND_MODIFIER * damageNext);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.PYROMANCER_TWO_ROGUE * damage);
        damageNext += Math.round(Constants.PYROMANCER_TWO_ROGUE * damageNext);
        enemy.setDamageOverTime(damageNext);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }

    public void attackSecond(Pyromancer enemy) {
        int damage = Constants.PYROMANCER_TWO_DAMAGE + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M1;
        int dur = Constants.PYROMANCER_TWO_DURTAION;
        int damageNext = Constants.PYROMANCER_TWO_DAMAGE_OT + super.getLevel() * Constants.PYROMANCER_TWO_DAMAGE_M2;

        if (super.getMap()[super.getX()][super.getY()] == Cell.volcanic) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            damageNext += Math.round(Constants.ROGUE_LAND_MODIFIER * damageNext);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.PYROMANCER_TWO_PYROMANCER * damage);
        damageNext += Math.round(Constants.PYROMANCER_TWO_PYROMANCER * damageNext);
        enemy.setDamageOverTime(damageNext);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }
}
