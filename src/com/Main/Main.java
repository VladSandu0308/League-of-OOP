package com.Main;

import java.io.IOException;
import java.util.ArrayList;

import com.map.Map;
import com.map.Cell;
import com.player.*;


public class Main {

    static void changePosition(ArrayList<Player> pl, char[][] moves, int i, int j) {
        char move = moves[i][j];

        switch (move) {
            case 'U':
                pl.get(j).moveUp();
                break;
            case 'D':
                pl.get(j).moveDown();
                break;
            case 'R':
                pl.get(j).moveRight();
                break;
            case 'L':
                pl.get(j).moveLeft();
                break;
            default:
                break;
        }
    }

    static void fight (Player x, Player y) {
        if (y instanceof Wizard) {
            y.defend(x);
            x.defend(y);
        } else {
            x.defend(y);
            y.defend(x);
        }
        int l1 = x.getLevel(), l2 = y.getLevel();
        if (x.getHp() <= 0) {
            int xp = Math.max(0, 200 - (l2 - l1) * 40);
            y.level(xp);
        }

        if (y.getHp() <= 0) {
            int xp = Math.max(0, 200 - (l1 - l2) * 40);
            x.level(xp);
        }
    }

    public static void main(String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        //System.out.println(gameInput.getHeight() + gameInput.getLength());
        char[][] inputMap = gameInput.getMap();

        /*System.out.println(gameInput.getTypes());
        System.out.println(gameInput.getXl());
        System.out.println(gameInput.getYl());
        System.out.println(Arrays.deepToString(gameInput.getMoves()));*/

        Map map = Map.getInstance(gameInput.getHeight(), gameInput.getLength());
        map.makeMap(inputMap);
        Cell[][] realMap = map.getMap();
        //System.out.println(Arrays.deepToString(realMap));

        PlayerFactory playerFactory = PlayerFactory.getInstance();
        playerFactory.makeList(gameInput.getTypes(), gameInput.getXl(), gameInput.getYl(), realMap);
        ArrayList<Player> pl = playerFactory.getPlayers();

        //System.out.println(pl.get(0).getClass());

        // Iteram prin runde
        for (int i = 0; i < gameInput.getRounds(); ++i) {
            //iteram prin jucatori
            System.out.println("Round " + i);
            Leaderboard finish = new Leaderboard(pl, args[1]);
            finish.print();
            System.out.println(" ");
            Player[][] rm = new Player[gameInput.getHeight()][gameInput.getLength()];
            //System.out.println(rm[0][0]);
            for (int j = 0; j < gameInput.getNoPlayers(); ++j) {
                pl.get(j).overTimeDamage();
                if(pl.get(j).getHp() <= 0) {
                    continue;
                }
                pl.get(j).resetBaseDamage();
                if (!pl.get(j).isStun()) {
                    changePosition(pl, gameInput.getMoves(), i, j);
                }
                /*System.out.println("Player " + j);
                System.out.println(gameInput.getHeight());
                System.out.println(gameInput.getLength());
                System.out.println(pl.get(j).getX());
                System.out.println(pl.get(j).getY());
                System.out.println(" ");*/
                if (rm[pl.get(j).getX()][pl.get(j).getY()] == null) {
                    rm[pl.get(j).getX()][pl.get(j).getY()] = pl.get(j);
                    //System.out.println(rm[pl.get(j).getX()][pl.get(j).getY()]);
                } else {
                    //System.out.println("alabal");
                    fight(pl.get(j), rm[pl.get(j).getX()][pl.get(j).getY()]);
                }
            }
        }

        Leaderboard finish = new Leaderboard(pl, args[1]);
        finish.print();

    }
}
