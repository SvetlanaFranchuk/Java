package controller;

import model.Bag;
import model.GameProcess;
import pojo.GameCard;
import view.GameWindow;
import view.PopupMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRequest {
    public static void pushButtonAndPlay (GameCard userCard, GameCard compCard, int countRowForWin, Bag bag,
                                          GameWindow gameWindow){
       gameWindow.getjButton().addActionListener(new ActionListener() {
           StringBuilder listNumber = new StringBuilder();
           int currentNum = 0;
           boolean isEnd = false;
           @Override
            public void actionPerformed(ActionEvent e) {
               if (!isEnd) {
                   if (bag.getBag().size() > 1) {
                       currentNum = bag.takeCurrentNumber();
                       listNumber.append(currentNum).append(", ");
                   } else {
                       listNumber.append(" the bag is empty");
                       isEnd = true;
                       currentNum = 0;
                   }
                   gameWindow.setListNumbers(listNumber.toString());
                   if (currentNum >0) {
                       isEnd = GameProcess.checkNumber(userCard, compCard, countRowForWin, currentNum, gameWindow);
                   }
               }

           }
        });
    }

    public static void getPopupMessage(String text, String title) {
        PopupMessage popupMessage = new PopupMessage();
        popupMessage.showMessage(text, title);
    }

    public static void setViewResult(GameWindow gameWindow, int nomPlayer, String newText){
        if (nomPlayer == 1)
            gameWindow.setUserResult(gameWindow.getUserResult().getText() + newText);
        else
            gameWindow.setCompResult(gameWindow.getCompResult().getText() + newText);
    }
}
