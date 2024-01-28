package pojo;

import model.Actions;

import java.util.concurrent.ThreadLocalRandom;

public class GameCard {
    private static final int COUNT_NUM = 15;
    private static final int ROWS = 3;
    private static final int COLUMNS = 9;
    private static final int COUNT_NUM_IN_ROW = 5;

    private Integer[][] card;

    public GameCard() {
        this.card = generateField();
    }

    public Integer[][] getCard() {
        return card;
    }

    public void setCard(Integer[][] card) {
        this.card = card;
    }

    @Override
    public String toString() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[0].length; j++) {
                System.out.print("|"+(card[i][j]<10?" ":"") + (card[i][j]==0?" ": card[i][j]));
            }
            System.out.print("|\n");
        }
        return "";
    }

    private int getCountNumInColumn(Integer[][] arr, int column) {
        return (arr[0][column] != null ? 1 : 0) + (arr[1][column] != null ? 1 : 0) + (arr[2][column] != null ? 1 : 0);
    }

    public Integer[][] generateField() {
        Integer[][] field;
        boolean isComplianceRequirements;
        do {
            int currentCountNum = 0;
            field = new Integer[ROWS][COLUMNS];
            int countIter = 0;
            while (currentCountNum < COUNT_NUM) {
                int minIter = 1;

                for (int column = 0; column < COLUMNS; column++) {
                    int colNumInColumn = (countIter == 0) ? 0 : getCountNumInColumn(field, column);
                    while (((colNumInColumn == 0 && countIter == 0) ||
                            (colNumInColumn < 2 && countIter > 0)) && currentCountNum < COUNT_NUM) {
                        for (int row = 0; row < ROWS; row++) {
                            if (currentCountNum < COUNT_NUM && field[row][column] == null) {
                                boolean isApply = ThreadLocalRandom.current().nextBoolean();
                                if (isApply) {
                                    int newNum = ThreadLocalRandom.current().nextInt(minIter,
                                            column != 8 ? minIter + 9 : minIter + 10);
                                    if (!isPresentInColumn(field, row, column, newNum)) {
                                        field[row][column] = newNum;
                                        currentCountNum++;
                                        colNumInColumn++;
                                        if (colNumInColumn == 2) break;
                                    }
                                }
                            }
                        }
                    }
                    colNumInColumn = 0;
                    minIter += 10;
                }
                countIter++;
            }
            isComplianceRequirements = isQuantityCondition(field);
        } while (!isComplianceRequirements);
        return field;
    }

    private boolean isQuantityCondition(Integer[][] field){
        for (int i = 0; i < ROWS; i++) {
            int countNums = 0;
            for (int j = 0; j < COLUMNS; j++) {
                if (!(field[i][j] ==null)) countNums++;
            }
            if (!(countNums ==5)) return false;
        }
        return true;
    }

    private boolean isPresentInColumn(Integer[][] field, int row, int column, int num) {
        for (int i = 0; i <= row; i++) {
            if (field[i][column] != null)
                if (field[i][column] == num) {
                return true;
            }
        }
        return false;
    }



}
