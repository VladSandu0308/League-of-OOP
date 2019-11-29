package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Knight extends Player {

    public Knight(String type, int hp, int x, int y, Cell[][] map, int mul) {
        super(type, hp, x, y, map, mul);
    }

    public void defend(Player enemy) {
        enemy.attackFirst(this);
        enemy.attackSecond(this);
    }



    /*public void defend(Wizard enemy) {
        enemy.attackFirst(this, Constants.WIZARD_ONE_KNIGHT);
        enemy.attackSecond(this, Constants.WIZARD_TWO_KNIGHT);
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
    }*/

    public void attackFirst(Knight enemy) {
        int damage = Constants.KNIGHT_ONE_DAMAGE + super.getLevel() * Constants.KNIGHT_ONE_DAMAGE_M;
        double hp = (float)(enemy.getHp()) / (float)(enemy.getMaxHP());
        /*System.out.println(hp);
        System.out.println(enemy.getHp());
        System.out.println(enemy.getMaxHP());*/
        double limit = Constants.KNIGHT_ONE_LIMIT + super.getLevel();
        if ( hp > Constants.KNIGHT_ONE_LIMIT ) {
            if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
                damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
            }
            enemy.setBaseDamage(damage);
            damage += Math.round(Constants.KNIGHT_ONE_KNIGHT * damage);
            enemy.changeHP(damage);
        } else {
            enemy.setBaseDamage(enemy.getHp());
            enemy.changeHP(enemy.getHp());
        }

    }

    public void attackFirst(Wizard enemy) {
        int damage = Constants.KNIGHT_ONE_DAMAGE + super.getLevel() * Constants.KNIGHT_ONE_DAMAGE_M;
        double hp = (float)(enemy.getHp()) / (float)(enemy.getMaxHP());
        double limit = Constants.KNIGHT_ONE_LIMIT + super.getLevel();
        if ( hp > Constants.KNIGHT_ONE_LIMIT ) {
            if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
                damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
            }
            enemy.setBaseDamage(damage);
            damage += Math.round(Constants.KNIGHT_ONE_WIZARD * damage);
            enemy.changeHP(damage);
        } else {
            enemy.setBaseDamage(enemy.getHp());
            enemy.changeHP(enemy.getHp());
        }

    }

    public void attackFirst(Rogue enemy) {
        int damage = Constants.KNIGHT_ONE_DAMAGE + super.getLevel() * Constants.KNIGHT_ONE_DAMAGE_M;
        double hp = (float)(enemy.getHp()) / (float)(enemy.getMaxHP());
        double limit = Constants.KNIGHT_ONE_LIMIT + super.getLevel();
        if ( hp > Constants.KNIGHT_ONE_LIMIT ) {
            if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
                damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
            }
            enemy.setBaseDamage(damage);
            damage += Math.round(Constants.KNIGHT_ONE_ROGUE * damage);
            enemy.changeHP(damage);
        } else {
            enemy.setBaseDamage(enemy.getHp());
            enemy.changeHP(enemy.getHp());
        }

    }

    public void attackFirst(Pyromancer enemy) {
        int damage = Constants.KNIGHT_ONE_DAMAGE + super.getLevel() * Constants.KNIGHT_ONE_DAMAGE_M;
        double hp = (float)(enemy.getHp()) / (float)(enemy.getMaxHP());
        double limit = Constants.KNIGHT_ONE_LIMIT + super.getLevel();
        if ( hp > Constants.KNIGHT_ONE_LIMIT ) {
            if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
                damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
            }
            enemy.setBaseDamage(damage);
            damage += Math.round(Constants.KNIGHT_ONE_PYROMANCER * damage);
            enemy.changeHP(damage);
        } else {
            enemy.setBaseDamage(enemy.getHp());
            enemy.changeHP(enemy.getHp());
        }

    }

    public void attackSecond(Knight enemy) {
        int damage = Constants.KNIGHT_TWO_DAMAGE + super.getLevel() * Constants.KNIGHT_TWO_DAMAGE_M;
        int dur = Constants.KNIGHT_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
            damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.KNIGHT_TWO_KNIGHT * damage);

        enemy.setStun(true);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }

    public void attackSecond(Wizard enemy) {
        int damage = Constants.KNIGHT_TWO_DAMAGE + super.getLevel() * Constants.KNIGHT_TWO_DAMAGE_M;
        int dur = Constants.KNIGHT_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
            damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.KNIGHT_TWO_WIZARD * damage);

        enemy.setStun(true);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }

    public void attackSecond(Rogue enemy) {
        int damage = Constants.KNIGHT_TWO_DAMAGE + super.getLevel() * Constants.KNIGHT_TWO_DAMAGE_M;
        int dur = Constants.KNIGHT_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
            damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.KNIGHT_TWO_ROGUE * damage);

        enemy.setStun(true);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }

    public void attackSecond(Pyromancer enemy) {
        int damage = Constants.KNIGHT_TWO_DAMAGE + super.getLevel() * Constants.KNIGHT_TWO_DAMAGE_M;
        int dur = Constants.KNIGHT_TWO_DURTAION;


        if (super.getMap()[super.getX()][super.getY()] == Cell.land) {
            damage += Math.round(Constants.KNIGHT_LAND_MODIFIER * damage);
        }
        enemy.setBaseDamage(damage);
        damage += Math.round(Constants.KNIGHT_TWO_PYROMANCER * damage);

        enemy.setStun(true);
        enemy.setDuration(dur);
        enemy.changeHP(damage);
    }

}
