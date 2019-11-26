package com.map;


import com.constants.Constants;

public class Map {
    private static Map instance = null;
    private int height;
    private int length;

    private Cell[][] map;

    private Map(int height, int length) {
        this.height = height;
        this.length = length;
        this.map = new Cell[height][length];
    }


    public void makeMap(char[][] mapInput) {
        int i = Constants.ZERO, j = Constants.ZERO;
        Cell c;

        for (i = 0; i < this.height; ++i) {
            for (j = 0; j < this.length; ++ j) {
                switch(mapInput[i][j]) {
                    case 'L':
                        c = Cell.land;
                        break;
                    case 'V':
                        c = Cell.volcanic;
                        break;
                    case 'D':
                        c = Cell.desert;
                        break;
                    case 'W':
                        c = Cell.woods;
                        break;
                    default:
                        c = Cell.wrong;
                        break;
                }

                map[i][j] = c;

            }
        }
    }

    public Cell[][] getMap() {
        return map;
    }

    public static Map getInstance(int height, int length) {
        if (instance == null) {
            instance = new Map(height, length);
        }
        return instance;
    }
}