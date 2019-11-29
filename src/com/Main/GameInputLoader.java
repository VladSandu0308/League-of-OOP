package com.Main;

import java.util.ArrayList;

import fileio.FileSystem;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        ArrayList<String> types = new ArrayList<String>();
        ArrayList<Integer> xl = new ArrayList<Integer>();
        ArrayList<Integer> yl = new ArrayList<Integer>();

        int rounds = 0;
        int length = 0;
        int height = 0;
        int noPlayers = 0;

        char[][] map = new char[100][100];
        char[][] moves= new char[100][100];

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            height = fs.nextInt();
            length = fs.nextInt();
            map = new char[height][length];
            for (int i = 0; i < height; ++i) {
                String temp = fs.nextWord();

                for(int j = 0; j < temp.length(); ++j) {

                    map[i][j] = temp.charAt(j);
                }
            }

            noPlayers= fs.nextInt();

            for (int i = 0; i < noPlayers; ++i) {
                types.add(fs.nextWord());
                xl.add(fs.nextInt());
                yl.add(fs.nextInt());
            }

            rounds = fs.nextInt();
            moves = new char[rounds][noPlayers];
            for(int i = 0; i < rounds; ++i) {
                String temp = fs.nextWord();
                for(int j = 0; j < temp.length(); ++j) {
                    moves[i][j] = temp.charAt(j);
                }
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(types, xl, yl, rounds, length, height, noPlayers, map, moves);
    }
}
