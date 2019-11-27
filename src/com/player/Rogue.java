package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Rogue extends Player {
    public Rogue(int hp, int x, int y, Cell[][] map) {
        super(hp, x, y, map);
    }

    int count = 0;

    public void defendFirst(Wizard enemy) {
        enemy.attackFirst(this);
    }

    public void defendFirst(Pyromancer enemy) {
        enemy.attackFirst(this, Constants.PYROMANCER_ONE_ROGUE);
        enemy.attackSecond(this, Constants.PYROMANCER_TWO_ROGUE);
    }

    public void defendFirst(Rogue enemy) {
        enemy.attackFirst(this, Constants.ROGUE_ONE_ROGUE);
        enemy.attackSecond(this, Constants.ROGUE_TWO_ROGUE);
    }

    public void defendFirst(Knight enemy) {
        enemy.attackFirst(this, Constants.KNIGHT_ONE_ROGUE);
        enemy.attackSecond(this, Constants.KNIGHT_TWO_ROGUE);
    }

    public void attackFirst(Player enemy, double modifier) {
        int damage = Constants.ROGUE_ONE_DAMAGE + super.getLevel() * Constants.ROGUE_ONE_DAMAGE_M;

        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            if (count % 3 == 0) {
                damage += Math.round(Constants.ROGUE_LAND_BONUS * damage);
            }
        }

        damage += Math.round(modifier * damage);
        enemy.changeHP(damage);
        count++;

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

    /*public void attackFirst(Wizard enemy) {
        int damage = Constants.ROGUE_ONE_DAMAGE + super.getLevel() * 20;

        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            if (count % 3 == 0) {
                damage += Math.round(Constants.ROGUE_LAND_BONUS * damage);
            }
        }

        damage += Math.round(Constants.ROGUE_ONE_WIZARD * damage);
        enemy.changeHP(damage);
        count++;


    }

    public void attackFirst(Pyromancer enemy) {
        int damage = Constants.ROGUE_ONE_DAMAGE + super.getLevel() * 20;

        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            if (count % 3 == 0) {
                damage += Math.round(Constants.ROGUE_LAND_BONUS * damage);
            }
        }

        damage += Math.round(Constants.ROGUE_ONE_PYROMANCER * damage);
        enemy.changeHP(damage);
        count++;

    }*/



    public void attackFirst(Knight enemy) {
        int damage = Constants.ROGUE_ONE_DAMAGE + super.getLevel() * 20;

        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            if (count % 3 == 0) {
                damage += Math.round(Constants.ROGUE_LAND_BONUS * damage);
            }
        }

        damage += Math.round(Constants.ROGUE_ONE_KNIGHT * damage);
        enemy.changeHP(damage);

        count++;

    }



    public void attackSecond(Pyromancer enemy) {
        int damage = Constants.ROGUE_TWO_DAMAGE + super.getLevel() * 10;
        int dur = Constants.ROGUE_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            dur *= Constants.TWO;
        }

        damage += Math.round(Constants.ROGUE_TWO_PYROMANCER * damage);

        enemy.setDamageOverTime(damage);
        enemy.setDuration(dur);
        enemy.changeHP(damage);

        enemy.setStun(true);
    }

    public void attackSecond(Rogue enemy) {
        int damage = Constants.ROGUE_TWO_DAMAGE + super.getLevel() * 10;
        int dur = Constants.ROGUE_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            dur *= Constants.TWO;
        }

        damage += Math.round(Constants.ROGUE_TWO_ROGUE * damage);

        enemy.setDamageOverTime(damage);
        enemy.setDuration(dur);
        enemy.changeHP(damage);

        enemy.setStun(true);
    }

    public void attackSecond(Knight enemy) {
        int damage = Constants.ROGUE_TWO_DAMAGE + super.getLevel() * 10;
        int dur = Constants.ROGUE_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.woods) {
            damage += Math.round(Constants.ROGUE_LAND_MODIFIER * damage);
            dur *= Constants.TWO;
        }

        damage += Math.round(Constants.ROGUE_TWO_KNIGHT * damage);

        enemy.setDamageOverTime(damage);
        enemy.setDuration(dur);
        enemy.changeHP(damage);

        enemy.setStun(true);
    }
}
