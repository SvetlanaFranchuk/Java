package task1;

public class Elevator {
  private String nameElevator;
  private int currentFloor;

    public Elevator(String nameElevator, int currentFloor) {
        this.nameElevator = nameElevator;
        this.currentFloor = currentFloor;
    }

    public String getNameElevator() {
        return nameElevator;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public String toString() {
        return "Лифт " + nameElevator + " отправляется с этажа " + currentFloor;
    }
}
