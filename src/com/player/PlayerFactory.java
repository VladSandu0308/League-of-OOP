package com.player;

import com.constants.Constants;
import com.map.Cell;

import java.util.ArrayList;

public class PlayerFactory {
    private static PlayerFactory instance = null;

    private ArrayList<Player> players = new ArrayList<Player>();

    public void addPlayer(final Player c) {
        players.add(c);
    }

    public void makeList(ArrayList<String> type, ArrayList<Integer> xl, ArrayList<Integer> yl) {
        int i = Constants.ZERO, j = Constants.ZERO;
        Player c;
        System.out.println(type.size());
        for (i = Constants.ZERO; i < type.size(); ++i) {
            switch(type.get(i)) {
                case "W":
                    c = new Wizard(Constants.WIZARD_HP, xl.get(i), yl.get(i));
                    break;
                case "K":
                    c = new Knight(Constants.KNIGHT_HP, xl.get(i), yl.get(i));
                    break;
                case "P":
                    c = new Pyromancer(Constants.PYROMANCER_HP, xl.get(i), yl.get(i));
                    break;
                case "R":
                    c = new Rogue(Constants.ROGUE_HP, xl.get(i), yl.get(i));
                    break;
                default:
                    c = c = new Wizard(0,0,0);
                    break;
            }
            this.addPlayer(c);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }
}

