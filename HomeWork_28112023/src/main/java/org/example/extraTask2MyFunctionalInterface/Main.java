package org.example.extraTask2MyFunctionalInterface;

public class Main {
    public static void main(String[] args) {
        String str1 = "1Home 2work";
        String str2 = "3Functional3 4interface4";
        String str3 = "Lambda expressions";

        MyFunctionalInterface<String, Double> sumLengthStrs = (a,b,c) ->
                                      Double.valueOf(a.length() + b.length() + c.length());
        System.out.println(checkAndGet(sumLengthStrs, str1, str2, str3));

        MyFunctionalInterface<String, Double> avgLengthStrs = (a,b,c) ->
                (double) (a.length() + b.length() + c.length()) /3;
        System.out.println(checkAndGet(avgLengthStrs, str1, str2, str3));

        MyFunctionalInterface<String, Double> minLengthStrs = (a,b,c) -> (double) min3Str(a,b,c);
        System.out.println(checkAndGet(minLengthStrs, str1, str2, str3));

        MyFunctionalInterface<String, Double> maxDigitStrs = (a,b,c) -> (double) lengthMaxCountDigit(a,b,c);
        System.out.println(checkAndGet(maxDigitStrs, str1, str2, str3));
    }

    private static Double checkAndGet(MyFunctionalInterface<String, Double> myInt,
                                      String str1, String str2, String str3){
        return (str1==null || str2==null || str3==null) ? null: myInt.execute(str1,str2,str3);
    }

    private static int min3Str(String a, String b, String c){
        if (a.length() < b.length() && a.length() < c.length())  return a.length();
        else if (b.length() < a.length() && b.length() < c.length()) return b.length();
        else return c.length();
    }

    private static int countDigit(String str) {
        int countResult=0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) countResult++;
        }
        return countResult;
    }

    private static int lengthMaxCountDigit(String a, String b, String c){
        int countDigitStr1 = countDigit(a);
        int countDigitStr2 = countDigit(b);
        int countDigitStr3 = countDigit(c);
        if (countDigitStr1 > countDigitStr2 && countDigitStr1 > countDigitStr3)  return a.length();
        else if (countDigitStr2 > countDigitStr1 && countDigitStr2 > countDigitStr3) return b.length();
        else return c.length();
    }

}
