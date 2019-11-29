package com.player;

import fileio.implementations.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Leaderboard {

    private List<Player> board = new ArrayList<Player>();
    private FileWriter fileWriter;

    public Leaderboard(final List<Player> board, final String out) throws IOException {
        this.board = board;
        this.fileWriter = new FileWriter(out);
    }

    public void print() throws IOException {

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
            //System.out.println(it.getHp());
            if (it.getHp() <= 0) {
                System.out.println("dead");
            } else {
                System.out.println(it.getLevel() + " " + it.getXp() + " " + it.getHp() + " " + it.getX() + " " + it.getY());
            }

        }

        for (var it : board) {
            if (it instanceof Wizard) {
                fileWriter.writeWord("W ");
            } else if ( it instanceof Knight) {
                fileWriter.writeWord("K ");
            } else if (it instanceof  Rogue) {
                fileWriter.writeWord("R ");
            } else if (it instanceof  Pyromancer) {
                fileWriter.writeWord("P ");
            }
            if (it.getHp() <= 0) {
                fileWriter.writeWord("dead");
            } else {
                fileWriter.writeWord(it.getLevel() + " " + it.getXp() + " " + it.getHp() + " " + it.getX() + " " + it.getY());

            }
            fileWriter.writeNewLine();

        }
        fileWriter.writeNewLine();
        fileWriter.close();
    }

}
