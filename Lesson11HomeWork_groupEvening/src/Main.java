import PKM.*;

import java.time.LocalDateTime;


public class Main {
//    1.Создайте объект этого
//    класса (Vegetables) в программе и попробуйте установить значения для полей.
//    Какие поля возможно установить?

//    Добавьте клонирующий конструктор к классу 1. В программе склонируйте созданный
//    ранее объект. Проверьте с помощью ==, что объекты имеют разные ссылки в памяти.
//    Затем измените объект класса 3, который лежит внутри оригинального объекта класса
//
//    С помощью == сравните ссылочные поля оригинала и клона. Вложенные объекты
//    имеют одинаковую ссылку в памяти?


    public static void main(String[] args) {
        Vegetables potato = new Vegetables();
        //    Какие поля возможно установить?
        // answer - только public
//        potato.id = 1;
//        potato.color = "red"; поле без модификатора - не устанавливается
//        potato.type = "potato" поле приватного модификатора - не устанавливается


        potato.setType("potato");
        potato.setColor("yellow");
        potato.setGroup(GroupOfVegetables.КЛУБНЕПЛОДЫ);
        potato.productMainDelivery(Country.UKRAINA, "tonns");
        potato.productMainBuyer(Country.GERMANY);
        System.out.println("Заведена запись " + potato.id + ". This is " + potato.getType()+ " основной покупатель - "+ potato.getBuyer());

        Vegetables clonePotato = new Vegetables(potato);
        System.out.println(potato == clonePotato); //объекты имеют разные ссылки в памяти

        potato.productMainBuyer(Country.POLISH);
        System.out.println("Изменен основной покупатель для оригинала - " + potato.getBuyer());
        System.out.println("Основной покупатель клона - " + clonePotato.getBuyer());
        //объекты имеют разные ссылки в памяти

    }
}