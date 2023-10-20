package task2_3_Figure;

import task2_3_Figure.shapes.*;
import task2_3_Figure.util.Parser;
import task2_3_Figure.util.Utils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MainFigure {
    public static void main(String[] args) {
        String str;
        Figure figure;

        boolean isCorrectText=false;

        while (!isCorrectText) {
            str = userStr();
            try {figure =Parser.newFigure(str);
                System.out.println(figure);
                isCorrectText = true;}
            catch (RuntimeException e){
                isCorrectText = false;
            }
     }

       //task3    Создайте массив IPrintable из нескольких фигур и в цикле вызовите метод print у каждой
        System.out.println();
        System.out.println("task3");
       IPrintable[] figureTask3 = {new Circle(7), new Rectangle(3,5), new Triangle(4,7,6),
               new Ellipse(6,8)};
        for (int i = 0; i < figureTask3.length; i++) {
            System.out.println(figureTask3[i]);
         figureTask3[i].print();
         System.out.println();
        }
   }

    static String userStr(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of figure " + Arrays.toString(FigureName.values()) +
                " and characteristics. Use a space to separate parameters: ");
        return scanner.nextLine();
    }


}
