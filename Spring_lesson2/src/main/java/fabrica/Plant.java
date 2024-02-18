package fabrica;

public class Plant {
    public static Plant produceNewPlant(){
        System.out.println("выращиваем новое растение");
        return new Plant();

    }

    private Plant(){}
}
