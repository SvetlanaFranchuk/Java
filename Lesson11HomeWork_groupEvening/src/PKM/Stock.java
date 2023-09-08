package PKM;

import java.time.LocalDateTime;
//2 Создайте второй класс в том же пакете, в котором будет создаваться первый класс
//(например, класс Университет для класса Студент или класс Завод для класса
//автомобиль). Внутри класса определите метод, который создаёт объект первого класса
//и присвоите ему те поля, которые возможно. Какие поля возможно задать?
//Создайте класс 3 и добавьте поле типа класса 3 в класс 2. При создании объекта
//класса 1 заполните новое поле
public class Stock {
   private double weight;
   private LocalDateTime dateDelivery;
   private LocalDateTime dateSales;
   public Vegetables stockOfVegetables;
   public Sales mainBuyer = new Sales();
   public void createRecord(String newVegetabls, String color){
        Vegetables vegetables = new Vegetables();
        //Внутри класса определите метод, который создаёт объект первого класса (Vegetables)
        //и присвоите ему те поля, которые возможно. Какие поля возможно задать?
        // answer - public и поле без модификатора
        //vegetables.id = 1; //поле публичное - устанавливается
        //vegetables.color = "red"; //поле без модификатора - устанавливается
        //vegetables.type = "potato";// поле приватного модификатора - не устанавливается

        vegetables.setType(newVegetabls);
        vegetables.setColor(color);
        vegetables.productMainBuyer(this.mainBuyer.buyer);
    }
}

