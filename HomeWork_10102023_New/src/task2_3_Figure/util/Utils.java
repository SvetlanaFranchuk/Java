package task2_3_Figure.util;

import task2_3_Figure.shapes.FigureName;

import java.util.Locale;

public class Utils {
    private Utils() {}

    public static String[] splitStr (String userStr){
        String[] result;
        result = userStr.split(" ");
        return result;
    }

    public static FigureName getFigureName(String name){
        return FigureName.valueOf(name.toUpperCase(Locale.ROOT));
    }

    public static double[] getEnterParameter(FigureName figure, String[] partSrt){
        double[] result = new double[figure.getCountParameters()];
        for (int i = 1; i < partSrt.length; i++) {
            result[i-1]=Double.parseDouble(partSrt[i]);
        }
        return result;
    }

    public static  boolean isPresent(String figureName) {
        try {
            Enum.valueOf(FigureName.class, figureName);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isCorrectCountParameters(FigureName figureName, double[] enterParameters){
        int requiredCount = figureName.getCountParameters();
        int userCount = 0;
        for (int i = 0; i < enterParameters.length; i++) {
            if (enterParameters[i]>0) userCount++;
        }
        if (userCount==requiredCount) return true;
        else return false;
    }


}
