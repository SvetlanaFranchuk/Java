package model;

import pojo.GameCard;

import java.util.ArrayList;
import java.util.List;

public class Actions {

    public Actions() {
    }

    public static boolean isPresentNumberInCart(GameCard card, int num) {
        Integer[][] currentCard = card.getCard();
        for (int i = 0; i < currentCard.length; i++) {
            for (int j = 0; j < currentCard[0].length; j++) {
                if (currentCard[i][j] != null) {
                    if (currentCard[i][j] == num) {
                        currentCard[i][j] = null;
                        card.setCard(currentCard);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<Integer> getNumbersFillRows(GameCard card){
        Integer[][] currentCard = card.getCard();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < currentCard.length; i++) {
            int countNullInRow = 0;
            for (int j = 0; j < currentCard[0].length; j++) {
                if (currentCard[i][j] == null) countNullInRow++;
            }
            if (countNullInRow == currentCard[0].length) {
                result.add(i);
            }
        }
        return result;
    }
}