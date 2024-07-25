package Array;

import java.util.Arrays;

public class transpose_matrix {
    public static void main(String[] args) {
        int[][] originalMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposedMatrix = transpose(originalMatrix);

        // Print the original matrix
        System.out.println("Original Matrix:");
        printMatrix(originalMatrix);

        // Print the transposed matrix
        System.out.println("Transposed Matrix:");
        printMatrix(transposedMatrix);
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] answer = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                answer[j][i] = matrix[i][j];
            }
        }

        return answer;
    }
}
