/**
 * T1: MC = MIN(A) * (MA * MD)
 */

import java.util.Random;
import java.util.Scanner;

public class T1 extends Thread {

    int[] A;
    int[][] MA, MD;
    public int[][] result;
    public Data d;


    T1(String name, int priority, Data d) {
        setName(name);
        setPriority(priority);
        this.d = d;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task 1 start");
            int n = d.getN();
            A = new int[n];
            MA = new int [n][n];
            MD = new int[n][n];
            if (n > 4){
                int max = 10;
                for(int i = 0; i < n; i++){
                    A[i] = new Random().nextInt(max);
                    for (int j = 0; j < n; j++){
                        MA[i][j] = new Random().nextInt(max);
                        MD[i][j] = new Random().nextInt(max);
                    }
                }
            }else {
                A = vectorInput(n, "A");
                MA = matrixInput(n, "MA");
                MD = matrixInput(n, "MD");
            }

            result = d.func1(A, MA, MD);
            sleep(500);
            printMatr(result, "MC");

            System.out.println("Task 1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printMatr(int[][] a, String name){
//        String res = "";
        System.out.println(name + ":");
        for(int i = 0; i < a.length; i++){
            System.out.print("[");
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("]");
        }
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

