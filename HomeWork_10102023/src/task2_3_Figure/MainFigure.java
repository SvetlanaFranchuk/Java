package task2_3_Figure;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MainFigure {
    public static void main(String[] args) {
        String str;
        String figureNameStr;
        FigureName figureName = null;
        double[] enterParameters = {0,0,0};
        Figure figure;

        boolean isCorrectFigure=false;
        boolean isCorrectCountParameters=false;

        while (isCorrectFigure == false || isCorrectCountParameters==false) {
            str = userStr();

            figureNameStr   = Utils.splitStr(str)[0];
            isCorrectFigure = Utils.isPresent(figureNameStr.toUpperCase(Locale.ROOT));

            if (isCorrectFigure) {
                figureName = Utils.getFigureName(figureNameStr);
                enterParameters = Utils.getEnterParameter(Utils.splitStr(str));

                isCorrectCountParameters = Utils.isCorrectCountParameters(figureName,enterParameters);
                if(!isCorrectCountParameters){
                    System.out.println("Incorrect count of valid parameters. Try again");
                }
            }
            else {
                System.out.println("Figure is not correct. Try again. ");
            }
        }

       figure = createFigure(figureName, enterParameters);
       figure.printCountParameters();


       //task3    Создайте массив IPrintable из нескольких фигур и в цикле вызовите метод print у каждой
        System.out.println();
        System.out.println("task3");
       Figure[] figureTask3 = {new Circle(7), new Rectangle(3,5), new Triangle(4,7,6), new Ellipse(6,8)};
        for (int i = 0; i < figureTask3.length; i++) {
         figureTask3[i].printCountParameters();
         figureTask3[i].print();
         System.out.println();
        }
   }

    static Figure createFigure(FigureName figureName, double[] enterParameters ){
        Figure figure = switch (figureName) {
            case CIRCLE -> new Circle(enterParameters[0]);
            case RECTANGLE -> new Rectangle(enterParameters[0], enterParameters[1]);
            case TRIANGLE -> new Triangle(enterParameters[0], enterParameters[1], enterParameters[2]);
            case ELLIPSE -> new Ellipse(enterParameters[0], enterParameters[1]);
        };
        return figure;
    }

    static String userStr(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of figure " + Arrays.toString(FigureName.values()) +
                " and characteristics. Use a space to separate parameters: ");
        return scanner.nextLine();
    }


}
