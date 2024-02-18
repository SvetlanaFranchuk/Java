package org.example.dto.congratulate;

public enum Holiday {
    HAPPY_BIRTHDAY ("Дорогой %s, поздравляю тебя с Днем рождения"),
    MARCH_8 ("Дорогой %s, поздравляю тебя с 8 March"),
    NEW_YEAR ("Дорогой %s, поздравляю тебя с 8 Новым годом"),
    INDEPENDECE_DAY ("Дорогой %s, поздравляю тебя с 8 Новым годом");

    private final String congratulation;

    Holiday(String congratulation) {
        this.congratulation = congratulation;
    }

    public String getCongratulation(){
        return congratulation;
    }


}
