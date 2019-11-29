package com.Main;

import java.util.ArrayList;

public class GameInput {
    private ArrayList<String> types = new ArrayList<String>();
    private ArrayList<Integer> xl = new ArrayList<Integer>();
    private ArrayList<Integer> yl = new ArrayList<Integer>();

    private int rounds = 0;
    private int length = 0;
    private int height = 0;
    private int noPlayers = 0;

    private char[][] map = new char[height][length];
    private char[][] moves = new char[rounds][noPlayers];

    public GameInput(ArrayList<String> types, ArrayList<Integer> xl, ArrayList<Integer> yl, int rounds, int length, int height, int noPlayers, char[][] map, char[][] moves) {
        this.types = types;
        this.xl = xl;
        this.yl = yl;
        this.rounds = rounds;
        this.length = length;
        this.height = height;
        this.noPlayers = noPlayers;
        this.map = map;
        this.moves = moves;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<Integer> getXl() {
        return xl;
    }

    public ArrayList<Integer> getYl() {
        return yl;
    }

    public int getRounds() {
        return rounds;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getNoPlayers() {
        return noPlayers;
    }

    public char[][] getMap() {
        return map;
    }

    public char[][] getMoves() {
        return moves;
    }
}
