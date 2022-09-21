import java.util.Random;
import java.util.Scanner;

/**
 * T2: MF = k*MG - h*MK*ML
 */

public class T2 extends Thread {
    int h, k;
    int[][] ML, MG, MK;
    public int[][] result;
    public Data d;

    T2(String name, int priority, Data d) {
        setName(name);
        setPriority(priority);
        this.d = d;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task 2 start");
            int n = d.getN();
            ML = new int [n][n];
            MG = new int[n][n];
            MK = new int[n][n];
            int max = 10;
            if (n > 4){
                k = new Random().nextInt(max);
                h = new Random().nextInt(max);
                for(int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        ML[i][j] = new Random().nextInt(max);
                        MG[i][j] = new Random().nextInt(max);
                        MK[i][j] = new Random().nextInt(max);

                    }
                }
            }else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter k: ");
                k = scanner.nextInt();
                System.out.println("Enter h: ");
                h = scanner.nextInt();
                MG = matrixInput(n, "MG");
                MK = matrixInput(n, "MK");
                ML = matrixInput(n, "ML");

            }

            result = d.func2(k, h, MG, MK, ML);
            sleep(200);
            printMatr(result, "MF");
            System.out.println("Task 2 end");
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
