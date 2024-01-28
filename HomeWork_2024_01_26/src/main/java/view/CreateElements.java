package view;

import pojo.GameCard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CreateElements {

    public CreateElements() {
    }

    public static JTable createTable(Integer[][] card){
        return new JTable(new DefaultTableModel(card, new Object[card[0].length][0]) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Integer.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Запрещаем редактирование ячеек
            }
        });
    }

    public static JPanel createCardPanel(GameCard card, String text){
        JPanel userPanel = new JPanel(new BorderLayout());

        JLabel userCardText = new JLabel(text + "  card is: ");
        JTable userCardTable = CreateElements.createTable(card.getCard());
        userCardTable.getTableHeader().setVisible(false);
        userPanel.add(userCardText, BorderLayout.NORTH);
        userPanel.add(userCardTable, BorderLayout.CENTER);
        return userPanel;
    }


}
