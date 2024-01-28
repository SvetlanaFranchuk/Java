package model;

import controller.UserRequest;
import pojo.GameCard;
import view.GameWindow;
import view.PopupMessage;

public class GameProcess {
    public GameProcess() {
    }

    public static boolean checkNumber(GameCard userCard, GameCard compCard, int countRowForWin,
                                      int currentNum, GameWindow gameWindow) {

        int countUserFillRow = 0;
        int countCompFillRow = 0;
        int countCurrentFillRows = 0;

        boolean isUserLucky = Actions.isPresentNumberInCart(userCard, currentNum);
        boolean isCompLucky = Actions.isPresentNumberInCart(compCard, currentNum);

        if (isUserLucky) {
            UserRequest.getPopupMessage("Congratulate. You have number " + currentNum, "Number is present");
            UserRequest.setViewResult(gameWindow, 1, currentNum + ", ");
            countUserFillRow = Actions.getNumbersFillRows(userCard).size();
        }
        if (isCompLucky) {
            UserRequest.getPopupMessage("Computer have number " + currentNum, "Number is present");
            UserRequest.setViewResult(gameWindow, 2, currentNum + ", ");
            countCompFillRow = Actions.getNumbersFillRows(compCard).size();
        }
        if (isUserLucky || isCompLucky)
            countCurrentFillRows = Math.max(countCompFillRow, countUserFillRow);
        if (countCurrentFillRows >= countRowForWin) {
            boolean isCompWin = countCompFillRow >= countUserFillRow;
            UserRequest.getPopupMessage(( isCompWin? "Computer" : "You") + " win!", "Game over");
            if (isCompWin) UserRequest.setViewResult(gameWindow, 2, " Computer win ((");
            else  UserRequest.setViewResult(gameWindow, 1, " You win ))");
            gameWindow.setTitle("Lotto. Game over");
            return true;
        }
        return false;
    }
}
