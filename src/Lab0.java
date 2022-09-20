/**
 * Parallel programming.
 * Labwork 0. Java.
 *
 * Neroda Arsen
 * IO-04
 *
 * T1: MC = MIN(A) * (MA * MD)
 * T2: MF = k*MG - h*MK*ML
 * T3: O = TRANS(MP*MR)*V
 */

public class Lab0 extends Thread {

    public static void main(String[] args) {
        (new Lab0()).start();
    }

    @Override
    public void run() {
        setName("Lab 0");
        System.out.println("Lab 0 start\n");
        int n = 10;
        Data data = new Data(n);
        T1 t1 = new T1("T1", Thread.MAX_PRIORITY, data);
        T2 t2 = new T2("T2", Thread.NORM_PRIORITY, data);
        T3 t3 = new T3("T3", Thread.MIN_PRIORITY, data);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nLab 0 end");
    }
}

