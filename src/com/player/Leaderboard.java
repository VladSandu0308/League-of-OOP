package com.player;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {

    private List<Player> board = new ArrayList<Player>();

    public Leaderboard(final List<Player> board) {
        this.board = board;
    }

    public void print() {

        for (var it : board) {
            if (it instanceof Wizard) {
                System.out.print("W ");
            } else if ( it instanceof Knight) {
                System.out.print("K ");
            } else if (it instanceof  Rogue) {
                System.out.print("R ");
            } else if (it instanceof  Pyromancer) {
                System.out.print("P ");
            }
            if (it.getHp() <= 0) {
                System.out.println("dead");
            } else {
                System.out.println(it.getLevel() + " " + it.getXp() + " " + it.getHp() + " " + it.getX() + " " + it.getY());
            }

        }
    }

}
