import controller.UserRequest;
import model.Actions;
import model.Bag;
import model.GameProcess;
import pojo.GameCard;
import utils.Util;
import view.GameWindow;
import view.PopupMessage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameCard userCard = new GameCard();
        GameCard compCard = new GameCard();
        int countRowForWin= Util.getCountRowsForWin();
        Bag bag = new Bag();

        GameWindow gameWindow = new GameWindow(userCard, compCard, bag);
        gameWindow.setTitle("Lotto. This game will last until "+ countRowForWin + " row(s) are filled");

        SwingUtilities.invokeLater(() -> gameWindow.setVisible(true));
        UserRequest.pushButtonAndPlay(userCard, compCard, countRowForWin, bag, gameWindow);

    }
}