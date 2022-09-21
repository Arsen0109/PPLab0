import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
 * T3: O = TRANS(MP*MR)*V
 */

public class T3 implements Runnable {
    int[] V;
    int[][] MP, MR;
    public int[] result;
    public Data d;

    T3(Data d) {
        this.d = d;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task 3 start");
            int n = d.getN();
            V = new int[n];
            MR = new int [n][n];
            MP = new int[n][n];
            int max = 10;
            if (n > 4){
                for(int i = 0; i < n; i++){
                    V[i] = new Random().nextInt(max);
                    for (int j = 0; j < n; j++){
                        MR[i][j] = new Random().nextInt(max);
                        MP[i][j] = new Random().nextInt(max);
                    }
                }
            }else{
                V = vectorInput(n, "V");
                MR = matrixInput(n, "MR");
                MP = matrixInput(n, "MP");
            }

            result = d.func3(MP, MR, V);
            sleep(1000);
            printVect(result, "O");
            System.out.println("Task 3 end");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printVect(int[] a, String name){
        System.out.print(name + ": [");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }
    public int[] vectorInput(int n, String name) {
        int[] vector = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n ; i++){
            System.out.printf("Input vector element #%d in vector %s %n", i, name);
            vector[i] = sc.nextInt();
        }
        return vector;
    }

    public int[][] matrixInput(int n, String name) {
        int[][] matrix = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ;
                 j++){
                System.out.printf("Input matrix element #[%d][%d] in matrix %s%n", i, j, name);
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
}
