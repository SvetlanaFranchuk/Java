package task2_3_Figure.util;

import task2_3_Figure.shapes.*;

import java.util.Locale;

public class Parser {
    static boolean isCorrectFigure=false;
    static boolean isCorrectCountParameters=false;
    static String figureNameStr;
    static FigureName figureName = null;
    static double[] enterParameters;


    public static Figure newFigure(String str) throws RuntimeException{

        figureNameStr   = Utils.splitStr(str)[0];
        isCorrectFigure = Utils.isPresent(figureNameStr.toUpperCase(Locale.ROOT));

        if (isCorrectFigure) {
            figureName = Utils.getFigureName(figureNameStr);
            enterParameters = Utils.getEnterParameter(figureName, Utils.splitStr(str));

            isCorrectCountParameters = Utils.isCorrectCountParameters(figureName,enterParameters);
            if(!isCorrectCountParameters){
                throw new RuntimeException("Incorrect count of valid parameters. Try again");
            } else {
                return  createFigure(figureName, enterParameters);
            }
        }
        else {
            throw new RuntimeException("Figure is not correct. Try again. ");
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

}
