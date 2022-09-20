import java.util.Random;

/**
 * T3: O = TRANS(MP*MR)*V
 */

public class T3 extends Thread {
    int[] V;
    int[][] MP, MR;
    private int[] result;
    private Data d;

    T3(String name, int priority, Data d) {
        setName(name);
        setPriority(priority);
        this.d = d;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task 3 start");
            int n = d.getN();
            int[] V = new int[n];
            int[][] MR = new int [n][n], MP = new int[n][n];
            int max = 10;
            for(int i = 0; i < n; i++){
                V[i] = new Random().nextInt(max);
                for (int j = 0; j < n; j++){
                    MR[i][j] = new Random().nextInt(max);
                    MP[i][j] = new Random().nextInt(max);
                }
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

    public void printMatr(int[][] a, String name){
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
