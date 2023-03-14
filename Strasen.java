import java.util.Arrays;
public class Strasen {
    public static int[][] strasen(int[][] A, int[][] B) {
        int n = A.length;

        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        } else {
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            split(A, A11, A12, A21, A22);
            split(B, B11, B12, B21, B22);

            int[][] S01 = add(A11, A22);
            int[][] S02 = add(B11, B22);
            int[][] S03 = add(A21, A22);
            int[][] S04 = subtract(B12,B22);
            int[][] S05 = subtract(B21,B11);
            int[][] S06 =add(A11,A12);
            int[][] S07 =subtract(A11,A21);
            int[][] S08 =add(B11,B12);
            int[][] S09 =subtract(A12,A22);
            int[][] S010 =add(B21,B22);

            int[][]P01=strasen(S01,S02);
            int[][]P02=strasen(S03,B11);
            int[][]P03=strasen(A11,S04);
            int[][]P04=strasen(A22,S05);
            int[][]P05=strasen(S06,B22);
            int[][]P06=strasen(S07,S08);
            int[][]P07=strasen(S09,S010);

            int[][]C11=subtract(add(add(P01,P04),P07),P05);
            int[][]C12=add(P03,P05);
            int[][]C21=add(P02,P04);
            int[][]C22=subtract(subtract(add(P01,P03),P02),P06);

            int[][] C=new int[n][n];
            join(C11,C12,C21,C22,C);
            return C;

        }

    }

    private static void split(int[][] A, int[][] A11, int[][] A12, int[][] A21, int[][] A22) {
        int n = A.length / 2;
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, A11[i], 0, n);
            System.arraycopy(A[i], n, A12[i], 0, n);
            System.arraycopy(A[i + n], 0, A21[i], 0, n);
            System.arraycopy(A[i + n], n, A22[i], 0, n);
        }
    }
    private static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    private static void join(int[][] C11, int[][] C12, int[][] C21, int[][] C22, int[][] C) {
        int n = C11.length;

        for (int i = 0; i < n; i++) {
            System.arraycopy(C11[i], 0, C[i], 0, n);
            System.arraycopy(C12[i], 0, C[i], n, n);
            System.arraycopy(C21[i], 0, C[i + n], 0, n);
            System.arraycopy(C22[i], 0, C[i + n], n, n);
        }
    }
    private static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

}




