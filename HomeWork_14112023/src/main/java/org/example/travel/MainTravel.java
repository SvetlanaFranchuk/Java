package org.example.travel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss", Locale.ROOT);

        System.out.print("Enter the start date and time of the trip using next format: dd-MM-yyyy HH:mm:ss ");
        LocalDateTime startTravel = LocalDateTime.parse(scanner.nextLine(), formatter);
        System.out.println(startTravel);

        RestPlace place1 = RestPlace.BERLIN_PRAGUE;
        RestPlace place2 = RestPlace.PRAGUE_BUDAPEST;
        RestPlace place3 = RestPlace.BUDAPEST_BELGRADE;
        RestPlace place4 = RestPlace.BELGRADE_SOFIA;
        RestPlace place5 = RestPlace.SOFIA_ISTANBUL;

        List<RestPlace> travelList = new ArrayList<>();
        travelList.add(place1);
        travelList.add(place2);
        travelList.add(place3);
        travelList.add(place4);
        travelList.add(place5);

        makeSchedule(travelList, startTravel);

    }

    public static void makeSchedule(List<RestPlace> travelList, LocalDateTime startDateTime){
        LocalDateTime dateTimeAchievement;
        int hour;
        int minutes;

        System.out.println("Your itinerary: ");
        for (RestPlace r:travelList) {
            hour = r.getTimeTravelHour();
            minutes = r.getTimeTravelMinutes();
            dateTimeAchievement = startDateTime.plusHours(hour).plusMinutes(minutes);
            System.out.println("City: " + r.getCityOfRest() + ". You will be there at: " + dateTimeAchievement +
                    ". It will take: " + hour + " hours, " + minutes +  " minutes");
            startDateTime = dateTimeAchievement;
        }
    }
}
