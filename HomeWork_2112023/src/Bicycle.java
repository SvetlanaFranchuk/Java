import enums.PartBicycle;

import java.util.Locale;

/**
 * class for creating bicycle
 * this class has inner classes for creating part of bicycle
 */
public class Bicycle {

    private final SteeringWheel steeringWheel;
    private final Saddle saddle;
    private final Frame frame;
    private final Gear gear;
    private final Wheel wheel1;
    private final Wheel wheel2;

    public Bicycle(SteeringWheel steeringWheel, Saddle saddle, Frame frame, Gear gear, Wheel wheel1, Wheel wheel2) {
        this.steeringWheel = steeringWheel;
        this.saddle = saddle;
        this.frame = frame;
        this.gear = gear;
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public Saddle getSaddle() {
        return saddle;
    }

    public Frame getFrame() {
        return frame;
    }

    public Gear getGear() {
        return gear;
    }

    public Wheel getWheel1() {
        return wheel1;
    }

    public Wheel getWheel2() {
        return wheel2;
    }

    /**
     *метод расчета нанесенного ущерба
     * @param part - часть велосипеда
     * @param damage - ущерб
     * @param <P> - наследуется от внутреннего класса-родителя ЧастиВелосипеда PartOfBicycle
     */
    public <P extends PartOfBicycle> void changeMarginSafety(P part, int damage) {
        int oldMarginSafety = part.getMarginSafety();
        if (oldMarginSafety > damage) {
            part.setMarginSafety(oldMarginSafety - damage);
            String strPart;
            if (part.getId()==5) strPart = "Front wheel";
            else if (part.getId()==6) strPart = "Rear wheel";
            else strPart = part.getPart().toString().toLowerCase(Locale.ROOT);
            System.out.println("The " + strPart + " is damaged. Damage = " + damage + " point");
        } else {
            part.setMarginSafety(0);
            System.out.println((char)27+"[31m"+"Ups! " + part.getPart().toString() + " is broke."+(char)27+"[0m");
        }
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                steeringWheel.toString().toLowerCase(Locale.ROOT) + "\n" +
                saddle.toString().toLowerCase(Locale.ROOT) + "\n" +
                frame.toString().toLowerCase(Locale.ROOT) + "\n" +
                gear.toString().toLowerCase(Locale.ROOT) + "\n" +
                "Front "+wheel1.toString().toLowerCase(Locale.ROOT) + "\n" +
                "Rear "+ wheel2.toString().toLowerCase(Locale.ROOT) +
                '}';
    }

    /**
     * ancestor class for creating bicycle parts
     */
    static class PartOfBicycle {
        PartBicycle part;
        int marginSafety;
        int id;

        public PartOfBicycle(PartBicycle part, int marginSafety, int id) {
            this.part = part;
            this.marginSafety = marginSafety;
            this.id = id;
        }

        public PartBicycle getPart() {
            return part;
        }

        public int getMarginSafety() {
            return marginSafety;
        }

        public int getId() {
            return id;
        }

        public void setMarginSafety(int marginSafety) {
            this.marginSafety = marginSafety;
        }

        @Override
        public String toString() {
            return part + ", marginSafety=" + marginSafety;
        }
    }

    /**
     * class for creating a Steering wheel
     */
    static class SteeringWheel extends PartOfBicycle {
        public SteeringWheel() {
            super(PartBicycle.STEERING_WHEEL, 15, 1);
        }
    }

    /**
     * class for creating a Saddle
     */
    static class Saddle extends PartOfBicycle {
        public Saddle() {
            super(PartBicycle.SADDLE, 30, 2);
        }
    }

    /**
     * class for creating a frame
     */
    static class Frame extends PartOfBicycle {
        public Frame() {
            super(PartBicycle.FRAME, 20, 3);
        }
    }

    /**
     * class for creating a gear
     */
    static class Gear extends PartOfBicycle {
        public Gear() {
            super(PartBicycle.GEAR, 17, 4);
        }
    }

    /**
     * class for creating a wheel
     */
    static class Wheel extends PartOfBicycle {
        public Wheel(int id) {
            super(PartBicycle.WHEEL, 12, id);
        }
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

// Метод getDamage можно написать значительно короче, используя полиморфизм,
// т.к. все части велосипеда наследуют PartOfBicycle.



//Создайте класс Велосипед. Типы полей этого класса должны быть объявлены как внутренние классы
//// (руль, седло, колесо, передачи, рама и т.д.). Каждая часть велосипеда помимо описания характеристик
//// хранит запас прочности. Когда запас прочности равен 0, часть велосипеда ломается.