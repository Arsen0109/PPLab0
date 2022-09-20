/**
 * T1: MC = MIN(A) * (MA * MD)
 */

import java.util.Random;
public class T1 extends Thread {

    int[] A;
    int[][] MA, MD;
    private int[][] result;
    private Data d;


    T1(String name, int priority, Data d) {
        setName(name);
        setPriority(priority);
        this.d = d;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task 1 start");
//            int n = 3;
            int n = d.getN();
            int[] A = new int[n];
            int[][] MA = new int [n][n], MD = new int[n][n];
            int max = 10;
            for(int i = 0; i < n; i++){
                A[i] = new Random().nextInt(max);
                for (int j = 0; j < n; j++){
                    MA[i][j] = new Random().nextInt(max);
                    MD[i][j] = new Random().nextInt(max);
                }
            }


            result = d.func1(A, MA, MD);
            sleep(500);
            printMatr(result, "MC");

            System.out.println("Task 1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printVect(int[] a, String name){
//        String res = "";
        System.out.print(name + ": [");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
//        return res;
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
}

