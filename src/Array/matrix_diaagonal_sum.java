package Array;

public class matrix_diaagonal_sum {
    public static void main(String[] args) {
        System.out.println(diagonalSum(new int [][] {{1,2,3},{4,5,6},{7,8,9}}));
    }
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }

        if (n % 2 == 1) {
            int middle = n / 2;
            sum -= mat[middle][middle];
        }

        return sum;
    }
}
