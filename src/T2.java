import java.util.Random;

/**
 * T2: MF = k*MG - h*MK*ML
 */

public class T2 extends Thread {
    int h, k;
    int[][] ML, MG, MK;
    private int[][] result;
    private Data d;

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
            int[][] ML = new int [n][n], MG = new int[n][n], MK = new int[n][n];
            int k, h;
            int max = 10;
            k = new Random().nextInt(max);
            h = new Random().nextInt(max);
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    ML[i][j] = new Random().nextInt(max);
                    MG[i][j] = new Random().nextInt(max);
                    MK[i][j] = new Random().nextInt(max);

                }
            }
            result = d.func2(k, h, MG, MK, ML);
            printMatr(result, "MF");
            sleep(250);
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
}
