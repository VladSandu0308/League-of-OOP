package com.main;

import java.util.Arrays;
import com.map.Map;
import com.map.Cell;


public class Main {

    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        System.out.println(gameInput.getHeight() + gameInput.getLength());
        char[][] inputMap = gameInput.getMap();

        System.out.println(gameInput.getTypes());
        System.out.println(gameInput.getXl());
        System.out.println(gameInput.getYl());
        System.out.println(Arrays.deepToString(gameInput.getMoves()));

        Map map = Map.getInstance(gameInput.getHeight(), gameInput.getLength());
        map.makeMap(inputMap);

        Cell[][] realMap = map.getMap();
        System.out.println(Arrays.deepToString(realMap));

    }
}
