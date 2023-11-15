package org.example;

public class MainTask2 {
    public static void main(String[] args) {
        System.out.println(sumCycle(7,2));
        System.out.println(sumRecursia(12,3));
    }

    public static int sumCycle(int n, int m){
        int result=0;
        for (int i = m; i <= n; i+=m) {
            if(i%m==0) result +=i;
        }
        return result;
    }

    public static int sumRecursia(int n, int m){
        int result = 0;
        if (n == 1) return 0; // base condition
        if (n % m == 0)
            result = n + sumRecursia(n - 1,m);
        else
            result = sumRecursia(n-1,m);
        return result;
       }
}

//Написать функцию sum(n, m), вычисляющую сумму тех чисел в диапазоне от 1 до n, которые делятся на m.
//Например:
//sum(7, 2) = 2 + 4 + 6 = 12
//sum(12, 3) = 3 + 6 + 9 + 12 = 30
//Решить задачу:
//а) через цикл
//б) через рекурсию