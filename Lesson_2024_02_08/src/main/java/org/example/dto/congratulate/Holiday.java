package org.example.dto;

public enum Holiday {
    HAPPY_BIRTHDAY ("Дорогой %s, поздравляю тебя с Днем рождения"),
    MARCH_8 ,
    NEW_YEAR,
    INDEPENDECE_DAY;

    private final String congratulation;

    Holiday(String congratulation) {
        this.congratulation = congratulation;
    }

    public String getCongratulation(){
        return congratulation;
    }


}
