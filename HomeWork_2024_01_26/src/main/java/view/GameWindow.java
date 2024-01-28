package view;

import model.Actions;
import model.Bag;
import model.GameProcess;
import pojo.GameCard;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public GameCard userCard;
    public GameCard compCard;
    public Bag bag;
    public JTextArea listNumbers;
    public JTextArea userResult;
    public JTextArea compResult;
    public JButton jButton;


    public GameWindow(GameCard userCard, GameCard compCard, Bag bag) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 320);

        Container container = getContentPane();
        container.setLayout(new GridLayout(4,1,2,2));

        JPanel userPanel = CreateElements.createCardPanel(userCard, "Your ");
        JPanel compPanel = CreateElements.createCardPanel(compCard, "Computer ");
        JPanel gameProcessPanel = new JPanel(new BorderLayout());
        JPanel gameResultPanel = new JPanel(new BorderLayout());

        this.listNumbers = new JTextArea();
        this.listNumbers.setLineWrap(true);
        this.jButton = new JButton("Get number");

        gameProcessPanel.add(this.jButton, BorderLayout.WEST);
        gameProcessPanel.add(this.listNumbers);

        this.userResult = new JTextArea("Your numbers: ");
        this.userResult.setLineWrap(true);
        this.compResult = new JTextArea("Computer numbers: ");
        this.compResult.setLineWrap(true);
        JLabel text = new JLabel("      RESULTS:        " );
        gameResultPanel.add(this.userResult, BorderLayout.NORTH);
        gameResultPanel.add(this.compResult, BorderLayout.SOUTH);
        gameResultPanel.add(text);

        container.add(userPanel);
        container.add(compPanel);
        container.add(gameProcessPanel);
        container.add(gameResultPanel);

        setLocationRelativeTo(null);
    }

    public void setListNumbers(String listNumbers) {
        this.listNumbers.setText(listNumbers);
    }

    public void setUserResult(String userNumbers) {
        this.userResult.setText(userNumbers);
    }

    public void setCompResult(String compNumbers) {
        this.compResult.setText(compNumbers);
    }

    public JTextArea getUserResult() {
        return userResult;
    }

    public JTextArea getCompResult() {
        return compResult;
    }

    public JButton getjButton() {
        return jButton;
    }


}