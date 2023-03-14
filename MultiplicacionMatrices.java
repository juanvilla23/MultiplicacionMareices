
import java.util.Arrays;

class MultiplicacionMatrices {
    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;

        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        } else {
            int[][] A11 = new int[n/2][n/2]; int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2]; int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2]; int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2]; int[][] B22 = new int[n/2][n/2];

            split(A, A11, A12, A21, A22);
            split(B, B11, B12, B21, B22);

            int[][] P01 =multiply(A11,B11);
            int[][] P02 =multiply(A12,B21);
            int[][] P03 =multiply(A11,B12);
            int[][] P04 =multiply(A12,B22);
            int[][] P05 =multiply(A21,B11);
            int[][] P06 =multiply(A22,B21);
            int[][] P07 =multiply(A21,B12);
            int[][] P08 =multiply(A22,B22);

            int[][] C11 =add(P01,P02);
            int[][] C12 =add(P03,P04);
            int[][] C21 =add(P05,P06);
            int[][] C22 =add(P07,P08);

            int[][] C = new int[n][n];
            join(C11, C12, C21, C22, C);

            return C;
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

    private static void split(int[][] A, int[][] A11, int[][] A12, int[][] A21, int[][] A22) {
        int n = A.length / 2;

        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, A11[i], 0, n);
            System.arraycopy(A[i], n, A12[i], 0, n);
            System.arraycopy(A[i+n], 0, A21[i], 0, n);
            System.arraycopy(A[i+n], n, A22[i], 0, n);
        }
    }

    private static void join(int[][] C11, int[][] C12, int[][] C21, int[][] C22, int[][] C) {
        int n = C11.length;

        for (int i = 0; i < n; i++) {
            System.arraycopy(C11[i], 0, C[i], 0, n);
            System.arraycopy(C12[i], 0, C[i], n, n);
            System.arraycopy(C21[i], 0, C[i+n], 0, n);
            System.arraycopy(C22[i], 0, C[i+n], n, n);
        }
    }

    /**
     * Adds two matrices of the same size
     * @param A First matrix
     * @param B Second matrix
     * @return result of adding A + B
     */
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


    public static void main(String[] args) {
        Strasen s =new Strasen();
        int[][] A = {{1,2,3,4}, {1,2,3,4},{1,2,3,4},{1,2,3,4}};
        int[][] B = {{1,2,3,4}, {1,2,3,4},{1,2,3,4},{1,2,3,4}};

        int[][] C = multiply(A, B);
        int[][]C2=Strasen.strasen(A,B);

        System.out.println(Arrays.deepToString(C));
        System.out.println(Arrays.deepToString(C2));

    }

}