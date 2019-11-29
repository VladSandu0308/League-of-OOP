package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Wizard extends Player {

    public Wizard(String type, int hp, int x, int y, Cell[][] map, int mul) {
        super(type, hp, x, y, map, mul);
    }

    public void defend(Player enemy) {
        enemy.attackFirst(this);
        enemy.attackSecond(this);
    }


    /*public void defend(Wizard enemy) {
        enemy.attackFirst(this, Constants.WIZARD_ONE_WIZARD);
        enemy.attackFirst(this, Constants.WIZARD_TWO_WIZARD);
    }

    public void defend(Pyromancer enemy) {
        enemy.attackFirst(this, Constants.PYROMANCER_ONE_WIZARD);
        enemy.attackSecond(this, Constants.PYROMANCER_TWO_WIZARD);
    }

    public void defend(Rogue enemy) {
        enemy.attackFirst(this, Constants.ROGUE_ONE_WIZARD);
        enemy.attackSecond(this, Constants.ROGUE_TWO_WIZARD);
    }

    public void defend(Knight enemy) {
        enemy.attackFirst(this, Constants.KNIGHT_ONE_WIZARD);
        enemy.attackSecond(this, Constants.KNIGHT_TWO_WIZARD);
    }*/

    public void attackFirst(Knight enemy) {

        int enemyHP = enemy.getHp();
        int maxHP = (int) Math.round(Constants.WIZARD_ONE_MAX * enemy.getMaxHP());
        //System.out.println(maxHP);
        int damage = Math.min(enemyHP, maxHP);
        //System.out.println(damage);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += Constants.WIZARD_ONE_KNIGHT * drain;
        drain *= damage;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Math.round(Constants.WIZARD_LAND_MODIFIER * drain);
        }

        damage = Math.round(drain);
        System.out.println(damage);
        enemy.changeHP(damage);
    }

    public void attackFirst(Wizard enemy) {

        int enemyHP = enemy.getHp();
        int maxHP = (int) Math.round(Constants.WIZARD_ONE_MAX * enemy.getMaxHP());
        //System.out.println(maxHP);
        int damage = Math.min(enemyHP, maxHP);
        //System.out.println(damage);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += Constants.WIZARD_ONE_WIZARD * drain;
        drain *= damage;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Math.round(Constants.WIZARD_LAND_MODIFIER * drain);
        }

        damage = Math.round(drain);
        System.out.println(damage);
        enemy.changeHP(damage);
    }

    public void attackFirst(Rogue enemy) {

        int enemyHP = enemy.getHp();
        int maxHP = (int) Math.round(Constants.WIZARD_ONE_MAX * enemy.getMaxHP());
        //System.out.println(maxHP);
        int damage = Math.min(enemyHP, maxHP);
        //System.out.println(damage);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += Constants.WIZARD_ONE_ROGUE * drain;
        drain *= damage;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Math.round(Constants.WIZARD_LAND_MODIFIER * drain);
        }

        damage = Math.round(drain);
        enemy.changeHP(damage);
    }

    public void attackFirst(Pyromancer enemy) {

        int enemyHP = enemy.getHp();
        int maxHP = (int) Math.round(Constants.WIZARD_ONE_MAX * enemy.getMaxHP());
        //System.out.println(maxHP);
        int damage = Math.min(enemyHP, maxHP);
        //System.out.println(damage);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += Constants.WIZARD_ONE_PYROMANCER * drain;
        drain *= damage;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Math.round(Constants.WIZARD_LAND_MODIFIER * drain);
        }

        damage = Math.round(drain);
        //System.out.println(damage);
        enemy.changeHP(damage);
    }

    public void attackSecond(Knight enemy) {
        float percent = 0.69f;
        if (super.getLevel() < 18) {
            percent = (float) (Constants.WIZARD_TWO_DAMAGE + super.getLevel() * Constants.WIZARD_TWO_DAMAGE_M);
        }

        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            percent += Constants.WIZARD_LAND_MODIFIER * percent;
        }

        percent += percent *  Constants.WIZARD_TWO_KNIGHT;
        int damage = (int) Math.round(percent * super.getBaseDamage() );
        enemy.changeHP(damage);
    }

    public void attackSecond(Wizard enemy) {
        /*double percent = 0.69;
        if( !(enemy instanceof Wizard ) ) {
            if (super.getLevel() < 18) {
                percent = Constants.WIZARD_TWO_DAMAGE + super.getLevel() * Constants.WIZARD_TWO_DAMAGE_M;
            }
            int damage = (int) Math.round(percent * super.getBaseDamage() );
            damage += Constants.WIZARD_TWO_WIZARD * damage;
            enemy.changeHP(damage);
        }*/
    }

    public void attackSecond(Rogue enemy) {
        float percent = 0.69f;
        if (super.getLevel() < 18) {
            percent = (float) (Constants.WIZARD_TWO_DAMAGE + super.getLevel() * Constants.WIZARD_TWO_DAMAGE_M);
        }

        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            percent += Constants.WIZARD_LAND_MODIFIER * percent;
        }

        percent += percent *  Constants.WIZARD_TWO_ROGUE;
        int damage = (int) Math.round(percent * super.getBaseDamage() );
        enemy.changeHP(damage);
    }

    public void attackSecond(Pyromancer enemy) {
        float percent = 0.69f;
        if (super.getLevel() < 18) {
            percent = (float) (Constants.WIZARD_TWO_DAMAGE + super.getLevel() * Constants.WIZARD_TWO_DAMAGE_M);
        }

        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            percent += Constants.WIZARD_LAND_MODIFIER * percent;
        }

        percent += percent *  Constants.WIZARD_TWO_PYROMANCER;
        int damage = (int) Math.round(percent * super.getBaseDamage() );
        enemy.changeHP(damage);
    }
}
