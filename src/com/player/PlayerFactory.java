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

    public void makeList(ArrayList<String> type, ArrayList<Integer> xl, ArrayList<Integer> yl, Cell[][] map) {
        int i = Constants.ZERO, j = Constants.ZERO;
        Player c;
        //System.out.println(type.size());
        for (i = Constants.ZERO; i < type.size(); ++i) {
            switch(type.get(i)) {
                case "W":
                    c = new Wizard("wizard", Constants.WIZARD_HP, xl.get(i), yl.get(i), map, Constants.WIZARD_HP_M);
                    break;
                case "K":
                    c = new Knight("knight",Constants.KNIGHT_HP, xl.get(i), yl.get(i), map, Constants.KNIGHT_HP_M);
                    break;
                case "P":
                    c = new Pyromancer("pyro",Constants.PYROMANCER_HP, xl.get(i), yl.get(i), map, Constants.PYROMANCER_HP_M);
                    break;
                case "R":
                    c = new Rogue("rogue",Constants.ROGUE_HP, xl.get(i), yl.get(i), map, Constants.ROGUE_HP_M);
                    break;
                default:
                    c = c = new Wizard("default", 0,0,0, map, 0);
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

