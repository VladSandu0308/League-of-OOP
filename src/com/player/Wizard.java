package com.player;

import com.constants.Constants;
import com.map.Cell;

public class Wizard extends Player {
    public Wizard(String type, int hp, int x, int y, Cell[][] map) {
        super(type, hp, x, y, map);
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

        int damage = Math.min(enemyHP, maxHP);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += Constants.WIZARD_ONE_KNIGHT * drain;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Constants.WIZARD_LAND_MODIFIER * drain;
        }
        drain *= damage;
        damage = Math.round(drain);

        enemy.changeHP(damage);
    }

    public void attackFirst(Wizard enemy) {

        int enemyHP = enemy.getHp();
        int maxHP = (int) Math.round(Constants.WIZARD_ONE_MAX * enemy.getMaxHP());

        int damage = Math.min(enemyHP, maxHP);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += Constants.WIZARD_ONE_WIZARD * drain;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Constants.WIZARD_LAND_MODIFIER * drain;
        }
        drain *= damage;
        damage = Math.round(drain);

        enemy.changeHP(damage);
    }

    public void attackFirst(Rogue enemy) {

        int enemyHP = enemy.getHp();
        int maxHP = (int) Math.round(Constants.WIZARD_ONE_MAX * enemy.getMaxHP());

        int damage = Math.min(enemyHP, maxHP);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += Constants.WIZARD_ONE_ROGUE * drain;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Constants.WIZARD_LAND_MODIFIER * drain;
        }
        drain *= damage;
        damage = Math.round(drain);
        //System.out.println(damage);
        enemy.changeHP(damage);
    }

    public void attackFirst(Pyromancer enemy) {

        int enemyHP = enemy.getHp();
        int maxHP = (int) Math.round(Constants.WIZARD_ONE_MAX * enemy.getMaxHP());

        int damage = Math.min(enemyHP, maxHP);
        float drain = (float) (Constants.WIZARD_ONE_DAMAGE + super.getLevel() * Constants.WIZARD_ONE_DAMAGE_M);
        drain += Constants.WIZARD_ONE_PYROMANCER * drain;
        if (super.getMap()[super.getX()][super.getY()] == Cell.desert) {
            drain += Math.round(Constants.WIZARD_LAND_MODIFIER * drain);
        }
        drain *= damage;
        damage = Math.round(drain);

        enemy.changeHP(damage);
    }

    public void attackSecond(Knight enemy) {
        double percent = 0.69;
        if (super.getLevel() < 18) {
            percent = Constants.WIZARD_TWO_DAMAGE + super.getLevel() * Constants.WIZARD_TWO_DAMAGE_M;
        }
        int damage = (int) Math.round(percent * super.getBaseDamage() );
        damage += Math.round(Constants.WIZARD_TWO_KNIGHT * damage);
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
        double percent = 0.69;
        if (super.getLevel() < 18) {
            percent = Constants.WIZARD_TWO_DAMAGE + super.getLevel() * Constants.WIZARD_TWO_DAMAGE_M;
            System.out.println(percent);
        }
        System.out.println(super.getBaseDamage());
        int damage = (int) Math.round(percent * super.getBaseDamage() );
        System.out.println(damage);
        damage += Math.round(Constants.WIZARD_TWO_ROGUE * damage);
        System.out.println(damage);
        enemy.changeHP(damage);
    }

    public void attackSecond(Pyromancer enemy) {
        double percent = 0.69;
        if (super.getLevel() < 18) {
            percent = Constants.WIZARD_TWO_DAMAGE + super.getLevel() * Constants.WIZARD_TWO_DAMAGE_M;
        }
        int damage = (int) Math.round(percent * super.getBaseDamage() );

        damage += Math.round(Constants.WIZARD_TWO_PYROMANCER * damage);
        enemy.changeHP(damage);
    }
}
