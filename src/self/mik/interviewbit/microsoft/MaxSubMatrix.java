package self.mik.interviewbit.microsoft;

public class MaxSubMatrix {

    private int findMin(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

    private int findMaxSubSquareMatrix(int[][] M) {
        int[][] sub = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            sub[i][0] = M[i][0];
        }
        for (int j = 0; j < M[0].length; j++) {
            sub[0][j] = M[0][j];
        }
        int max = 0;
        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    sub[i][j] = findMin(sub[i - 1][j], sub[i - 1][j - 1], sub[i][j - 1]) + 1;
                    max = max > sub[i][j] ? max : sub[i][j];
                } else {
                    sub[i][j] = M[i][j];
                }
            }
        }
        printmatrix(sub);
        return max;
    }
    private void printmatrix(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public void testMaximumSubMatrix() {
        int M[][] = {{0, 1, 1, 0, 1},
                     {1, 1, 1, 1, 0},
                     {0, 1, 1, 1, 0},
                     {1, 1, 1, 1, 0},
                     {1, 1, 1, 1, 1},
                     {0, 0, 0, 0, 0}};
        System.out.println(findMaxSubSquareMatrix(M));
    }

}
