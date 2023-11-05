import enums.TypeObstacle;

import java.util.Locale;
import java.util.Random;

/**
 * utilitarian class for creating different Obstacles
 */
public class Obstacles {
    //яма, бордюр, битое стекло, лужа
    public Obstacles() {
    }

    /**
     * метод генерирует случайное препятствие из ENUM TypeObstacle
     * случайный уровень разрушения и случайный номер части велосипеда,
     * которая будет повреждена
     * @param bicycle - велосипед
     */
    public static void createObstacle(Bicycle bicycle){
        TypeObstacle[] obstacles = new TypeObstacle[]{TypeObstacle.POTHOLE, TypeObstacle.BORDER,
                TypeObstacle.BROKEN_GLASS, TypeObstacle.PUDDLE};
        Random rnd = new Random();
        int damage = rnd.nextInt(1,3);
        int partBikeId = rnd.nextInt(1,7);
        System.out.print("Oh no, it`s a " + obstacles[rnd.nextInt(4)].toString().toLowerCase(Locale.ROOT) + ". ") ;
        getDamage(damage,partBikeId,bicycle);
    }

    /**
     * метод, который в зависимости от переданной части велосипеда, вызывает метод расчета запаса прочности
     * конкретной детали
     * @param damage - степень разрушения
     * @param partBikeId - часть велосипеда (ИД)
     * @param bicycle - велосипед
     */
    public static void getDamage(int damage, int partBikeId, Bicycle bicycle){
        if (partBikeId == 1)
            bicycle.changeMarginSafety(bicycle.getSteeringWheel(),damage);
        else if (partBikeId == 2)
            bicycle.changeMarginSafety(bicycle.getSaddle(),damage);
        else if (partBikeId == 3)
            bicycle.changeMarginSafety(bicycle.getFrame(),damage);
        else if (partBikeId == 4)
            bicycle.changeMarginSafety(bicycle.getGear(),damage);
        else if (partBikeId == 5)
            bicycle.changeMarginSafety(bicycle.getWheel1(),damage);
        else if (partBikeId == 6)
            bicycle.changeMarginSafety(bicycle.getWheel2(),damage);
    }
}
