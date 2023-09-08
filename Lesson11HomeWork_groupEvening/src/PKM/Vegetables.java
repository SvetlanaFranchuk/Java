package PKM;

public class Vegetables {
//   создайте класс с минимум 3мя полями для одного из объектов
//   реального мира (студент, батарейка, автомобиль…). Одно из полей сделайте публичным,
//   второе – без модификатора доступа, остальные – приватными.

//   Напишите минимум 2 конструктора для класса 1.
//   Реализуйте геттеры и сеттеры для класса 1.
//   Создайте другие методы для класса.

    public long id;
    private String type;
    String color;
    private GroupOfVegetables group;
    private Country provider;   //поставщик
    private String unit;        //единицы измерения
    private Country buyer;      //покупатель

    public Vegetables() {
        this.id++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public GroupOfVegetables getGroup() {
        return group;
    }

    public void setGroup(GroupOfVegetables group) {
        this.group = group;
    }

    public Country getBuyer() {
        return buyer;
    }


    public void productMainDelivery(Country provider, String unit) {
        this.provider = provider;
        this.unit = unit;
    }

    public void productMainBuyer(Country buyer) {
        this.buyer = buyer;
    }

    public Vegetables(Vegetables origin) {
        this.type = origin.type;
        this.color = origin.color;
        this.group = origin.group;
        this.provider = origin.provider;
        this.unit = origin.unit;
        this.buyer = origin.buyer;
    }
}
