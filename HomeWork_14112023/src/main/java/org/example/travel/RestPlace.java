package org.example.travel;

import java.time.Duration;


public enum RestPlace {
    SOFIA_ISTANBUL(6,0, "Istanbul") ,
    BELGRADE_SOFIA (4,17, "Sofia"),
    BUDAPEST_BELGRADE (3,46, "Belgrade"),
    PRAGUE_BUDAPEST (5,10, "Budapest"),
    BERLIN_PRAGUE (3,42, "Prague");

    private int timeTravelHour;
    private int timeTravelMinutes;
    private String cityOfRest;

    RestPlace(int timeTravelHour, int timeTravelMinutes, String cityOfRest) {
        this.timeTravelHour = timeTravelHour;
        this.timeTravelMinutes = timeTravelMinutes;
        this.cityOfRest = cityOfRest;
    }

    public int getTimeTravelHour() {
        return timeTravelHour;
    }

    public int getTimeTravelMinutes() {
        return timeTravelMinutes;
    }

    public String getCityOfRest() {
        return cityOfRest;
    }
}
