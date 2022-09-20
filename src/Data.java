import java.util.Arrays;
import java.util.Scanner;
/**
 * T1: C = A-B*(MA*MC)*e
 * T2: MF = MF*MG*k
 * T3: O = sort(P)*(MR*MT)
 *
 */
public class Data {
    private int n;

    public int getN() {
        return n;
    }

    public Data(int n) {
        this.n = n;
    }

    public int[] vectorInput() {
        int[] vector = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n ; i++){
            vector[i] = sc.nextInt();
        }
        return vector;
    }

    public int[][] matrixInput() {
        int[][] matrix = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ;
                 j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public int[] func3(int[][] MP, int[][] MR, int[] V) {
        return vectorMatrixMult(V, matrixTrans(matrixMult(MP, MR)));
    }

    public int[][] func2(int k, int h, int[][] MG, int[][] MK, int[][] ML) {
        return matrixDiff(intMatrixMult(k, MG), intMatrixMult(h, matrixMult(MK, ML)));
    }

    public int[][] func1(int[] A, int[][] MA, int[][] MD) {
        return intMatrixMult(vectorMin(A), matrixMult(MA, MD));
    }

    private int[] vectorAdd(int[] a, int[] b) {
        if (a.length != n || b.length != n) {
            System.out.println("null");
            return null;
        }
        int[] c = new int[n];
        for (int i = 0; i < n ; i++){
            c[i] = a[i] + b[i];
        }
        return c;
    }

    private int vectorMax(int[] a) {
        int c = a[0];
        for(int i = 0; i < a.length; i++){
            if (a[i] > c){
                c = a[i];
            }
        }
        return c;
    }

    private int vectorMin(int[] v){
        int min = v[0];
        for (int i = 0; i < v.length; i++){
            if (v[i] < min){
                min = v[i];
            }
        }
        return min;
    }

    private int[] vectorDiff(int[] a, int[] b) {
        if (a.length != n || b.length != n) {
            return null;
        }
        int[] c = new int[n];
        for (int i = 0; i < n ; i++){
            c[i] = a[i] - b[i];
        }
        return c;
    }

    private int [][] matrixDiff(int[][] A, int[][] B){
        int[][] C = new int[n][n];
        for (int i = 0; i <n ; i++){
            for (int j = 0; j < n; j++){
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    private int[][] matrixTrans(int[][] ma) {
        int buf;
        for (int i = 0; i < ma.length ; i++){
            for (int j = 0; j <=i; j++){
                buf = ma[i][j];

                ma[i][j] = ma[j][i];
                ma[j][i] = buf;
            }
        }
        return ma;
    }

    private int[] vectorMatrixMult(int[] a, int[][] ma) {
        if (a.length != n || ma.length != n) {
            return null;
        }
        int[] c = new int[n];
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){
                c[i] += a[j] * ma[j][i];
            }
        }
        return c;
    }

    private int[] vectorMult(int[] a, int[] b) {
        if (b.length !=n || a.length != n) {
            return null;
        }
        int[] c = new int[n];
        for (int i = 0; i < n ; i++){
            c[i] = a[i] * b[i];
        }
        return c;
    }

    private int[][] matrixMult(int[][] ma, int[][] mb) {
        if (ma.length != n || mb.length != n) {
            return null;
        }
        int[][] c = new int[n][n];
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){
                for (int k = 0; k < n ; k++){
                    c[i][j] += ma[i][k] * mb[k][j];
                }
            }
        }
        return c;
    }

    private int[] intVectorMult(int a, int[] b) {
        int[] c = new int[n];
        for (int i = 0; i < n ; i++){
            c[i] = a * b[i];
        }
        return c;
    }

    private int[][] intMatrixMult(int a, int[][] b) {
        int[][] c = new int[n][n];
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++) {
                c[i][j] = a * b[i][j];
            }
        }
        return c;
    }

    private int[] vectorSort(int[] a) {
        if (a.length != n) {
            return null;
        }
        int[] c = Arrays.copyOf(a, n);
        Arrays.sort(c);
        int[] res = new int[c.length];
        for (int i = c.length; i > 0; i--){
            res[i-1] = c[c.length - i];
        }
        return res;
    }

    private int[][] matrixSort(int[][] a){
        if (a.length != n) {
            return null;
        }
        int[][] c = new int[a.length][a[0].length];
        for (int i = 0; i < c.length; i++){
            c[i] = vectorSort(a[i]);
        }

        return c;

    }
}


