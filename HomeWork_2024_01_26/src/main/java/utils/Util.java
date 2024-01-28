package utils;

import pojo.GameType;

import java.util.concurrent.ThreadLocalRandom;

public class Util {
    public Util() {
    }

    private static GameType getRandomTypeGame(){
        return switch (ThreadLocalRandom.current().nextInt(0,3)){
            case 0-> GameType.ROW1;
            case 1-> GameType.ROW2;
            case 2-> GameType.ROW3;
            default -> null;
        };
    }

    public static int getCountRowsForWin(){
        GameType gameType = getRandomTypeGame();
        if (gameType==GameType.ROW1) return 1;
        if (gameType==GameType.ROW2) return 2;
        return 3;
    }
}
