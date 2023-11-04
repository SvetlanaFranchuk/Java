public class Main {
    public static void main(String[] args) {
        int n=5;
        int m=6;
        int[][] a,matrx;
        int count=0;
       // Оценить временную сложность фрагментов алгоритмов:

        //a) O(n*m)
        for (int i = 0; i < n; ++i) {     //i = 0,1,2,3,...n
            for (int j = 1; j < m; ++j) { //j=1,2,...m
                a[i][j]++;                //n*m
            }
        }

        //b) O(n!)
        for (int i = 0; i < n-1; ++i) {         //i=0,1,2,3,4
            for (int j = 0; j < n-i; ++j) {     //j=0..5  0..4  0..3  0..2  0..1
                a[i][j]++;                      //(n!)
            }
        }


        //c) O(n*log(n))
        for (int i = 0; i < n; ++i) {           //i=0,1,2,3,4  n
            for (int j = 1; j < n; j *= 3) {    //j=1,3        n/3
                a[i][j]++;
            }
        }


        //d) O(1000(n-1) = O(n)
        for (int i = 0; i < 1000; ++i) {        //1000
            for (int j = 1; j < n; ++j) {       //n-1
                ++count;                        //1000*(n-1)
            }
        }


        //e) O(n*log(n)
        for (int i = 0; i < n; ++i) {           //n     i=0,1,2,3,4
            for (int j = 0; j < n/3; ++j) {     //n/3   j=0..1  0..1
                matrx[i][i]++;                  //n*n/3
            }
        }
    }
}