package task1;

public class MainElevator {
    public static void main(String[] args) {
        Elevator A = new Elevator("A", 0);
        Elevator B = new Elevator("B", 8);
        int countFloor = 19;
        int callFloor = 1;
        System.out.println(findNearestElevator(A, B, callFloor));

    }

    private static Elevator findNearestElevator(Elevator A, Elevator B, int callFloor) {
        int curA = A.getCurrentFloor();
        int curB = B.getCurrentFloor();
        int difA = curA >= callFloor ? curA - callFloor : callFloor - curA;
        int difB = curB >= callFloor ? curB - callFloor : callFloor - curB;

        return difA < difB ? A : B;
    }

}
//1. Задача: вызов лифта
//В доме два лифта. Реализовать алгоритм отправки наиближайшего на вызывающий этаж. Алгоритм будет применяться в
// домах разной этажности.
//
//Пример:
//в доме 19 этажей
//работают лифт А и лифт В
//лифт А находиться на 0 этаже
//лифт В находиться на 8 этаже
//вызов: 1 этаж
//отправляем лифт А