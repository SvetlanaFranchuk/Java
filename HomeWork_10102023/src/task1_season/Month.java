package task1_season;

public enum Month {
    JANUARY(Season.WINTER, 10, -7),
    FEBRUARY(Season.WINTER, 6, -12),
    MARCH(Season.SPRING, 12, -5),
    APRIL(Season.SPRING, 17, 5),
    MAY(Season.SPRING, 18, 7),
    JUNE(Season.SUMMER, 25, 12),
    JULY(Season.SUMMER, 35, 22),
    AUGUST(Season.SUMMER, 22, 17),
    SEPTEMBER(Season.AUTUMN, 18, 10),
    OCTOBER(Season.AUTUMN, 13, 7),
    NOVEMBER(Season.AUTUMN, 14, 5),
    DECEMBER (Season.WINTER, 12, -3);

    static int maxTemperature;
    static int minTemperature;
    public double averageTemperature;
    public Season season;

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public Season getSeason() {
        return season;
    }

    Month(Season season, int maxTemperature, int minTemperature) {
        this.averageTemperature = (maxTemperature + minTemperature) / 2;
        this.season = season;
    }
}
