package Array;

import java.util.Arrays;

public class determine_weather_matrix_can_be_obtained {
    public static void main(String[] args) {
        System.out.println(findRotation(new int[][]{{0,1},{1,0}},new int[][]{{1,0},{0,1}}));
    }
    public static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }

            // Rotate the matrix in-place
            int[][] temp = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[j][k] = mat[n - k - 1][j];
                }
            }
            mat = temp;
        }

        return false;
    }


}
