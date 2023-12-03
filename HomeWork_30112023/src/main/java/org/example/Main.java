package org.example;

import org.example.house.House;
import org.example.house.Flat;
import org.example.house.Room;
import org.example.house.TypeRoom;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        House house = new House(List.of(
                new Flat(1,List.of(
                        new Room(TypeRoom.LIVING_ROOM, 18.0),
                        new Room(TypeRoom.BED_ROOM, 9.7),
                        new Room(TypeRoom.BATH_ROOM,7.3),
                        new Room(TypeRoom.KITCHEN, 11.3),
                        new Room(TypeRoom.CORRIDOR, 2.5))),
                new Flat(2,List.of(
                        new Room(TypeRoom.LIVING_ROOM, 14.6),
                        new Room(TypeRoom.BED_ROOM, 9.2),
                        new Room(TypeRoom.BED_ROOM, 10.8),
                        new Room(TypeRoom.BATH_ROOM,6.3),
                        new Room(TypeRoom.KITCHEN, 9.8),
                        new Room(TypeRoom.CORRIDOR, 3.5))),
                new Flat(3,List.of(
                        new Room(TypeRoom.LIVING_ROOM, 21.3),
                        new Room(TypeRoom.BED_ROOM, 16.7),
                        new Room(TypeRoom.BED_ROOM, 18.3),
                        new Room(TypeRoom.BED_ROOM, 12.7),
                        new Room(TypeRoom.BATH_ROOM,8.3),
                        new Room(TypeRoom.KITCHEN, 10.5),
                        new Room(TypeRoom.CORRIDOR, 2.2),
                        new Room(TypeRoom.TOILET, 2.3),
                        new Room(TypeRoom.STUDY, 5.6)))));
        System.out.println("Our house");
        System.out.println(house);

        //Посчитайте суммарную жилую площадь дома.
        double sumSquareAllFlat = house.getFlatNumber().stream()
                .flatMap(flat -> flat.getRooms().stream())
                .mapToDouble(Room::getSquare).sum();
        System.out.println("\nПлощадь всех квартир в доме: "+sumSquareAllFlat);

        //Среди всех квартир найдите квартиру, площадь которой больше 100 кв. м.
        // Если такая квартира найдена, то выведите её площадь.
        // В противном случае выведите сообщение, что такой квартиры нет
        Optional<Double> squareFlats = Optional.of(house.getFlatNumber().stream()
                .mapToDouble(flat -> flat.getRooms().stream()
                        .mapToDouble(Room::getSquare).sum())
                .filter(a -> a >= 100)
                .sum());
        System.out.println("Квартира с площадью 100 и более кв.м " +
                (Optional.of(0.0).equals(squareFlats)  ? "отсутствует": squareFlats));

        //Старый дом расселяют. В новом доме жильцы должны получить квартиры большей
        //площади. Создайте новый список квартир дома, увеличив площадь каждой комнаты на
        //30%
        House newHouse = new House(
                house.getFlatNumber().stream()
                .map(flat -> new Flat(
                        flat.getNumber(),
                        flat.getRooms().stream()
                                .map(room -> new Room(room.getType(), room.getSquare() * 1.3))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList()));
        System.out.println("\nНовый дом с увеличенной площадью квартир");
        System.out.println(newHouse);

        //Дан список, каждый элемент которого – это мапа площадей комнат (комната -
        //площадь). Создайте новые квартиры с комнатами заданных площадей.
        House house2 = new House(List.of(
                new Flat(1, List.of(
                       new Room(TypeRoom.LIVING_ROOM, getSquare(TypeRoom.LIVING_ROOM)),
                       new Room(TypeRoom.BED_ROOM, getSquare(TypeRoom.BED_ROOM)),
                       new Room(TypeRoom.KITCHEN, getSquare(TypeRoom.KITCHEN)),
                       new Room(TypeRoom.BATH_ROOM, getSquare(TypeRoom.BATH_ROOM)))),
                new Flat(2, List.of(
                        new Room(TypeRoom.BED_ROOM, getSquare(TypeRoom.BED_ROOM)),
                        new Room(TypeRoom.BED_ROOM, getSquare(TypeRoom.BED_ROOM)),
                        new Room(TypeRoom.KITCHEN, getSquare(TypeRoom.KITCHEN)),
                        new Room(TypeRoom.BATH_ROOM, getSquare(TypeRoom.BATH_ROOM)))),
                new Flat(3, List.of(
                        new Room(TypeRoom.LIVING_ROOM, getSquare(TypeRoom.LIVING_ROOM)),
                        new Room(TypeRoom.BED_ROOM, getSquare(TypeRoom.BED_ROOM)),
                        new Room(TypeRoom.KITCHEN, getSquare(TypeRoom.KITCHEN)),
                        new Room(TypeRoom.STUDY, getSquare(TypeRoom.STUDY)),
                        new Room(TypeRoom.TOILET, getSquare(TypeRoom.TOILET)),
                        new Room(TypeRoom.CORRIDOR, getSquare(TypeRoom.CORRIDOR)),
                        new Room(TypeRoom.BATH_ROOM, getSquare(TypeRoom.BATH_ROOM))))
                ));
        System.out.println("\nНовый дом с произвольным набором квартир по заданной мапе площадей:");
        System.out.println(house2);

       }

    //Дан список, каждый элемент которого – это мапа площадей комнат (комната -
    //площадь). Создайте новые квартиры с комнатами заданных площадей.
       private static double getSquare(TypeRoom typeRoom){
        List<Map<TypeRoom, Double>> roomsSquare = List.of(
                Map.of(TypeRoom.LIVING_ROOM, 15.2),
                Map.of(TypeRoom.BED_ROOM, 10.3),
                Map.of(TypeRoom.BATH_ROOM, 6.7),
                Map.of(TypeRoom.KITCHEN, 12.4),
                Map.of(TypeRoom.STUDY, 8.3),
                Map.of(TypeRoom.TOILET, 3.8),
                Map.of(TypeRoom.CORRIDOR, 5.2) );
        return  roomsSquare.stream()
                .filter(el-> el.containsKey(typeRoom))
                .mapToDouble(el -> el.get(typeRoom))
                .findFirst()
                .orElse(0);
    }

}