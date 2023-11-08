package binary_search;

import java.util.Arrays;

public class sorted_matrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        System.out.println(Arrays.toString(search(arr,6)));
    }
    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midElement = matrix[mid / cols][mid % cols];

            if (midElement == target) {
                return new int[]{mid / cols, mid % cols};
            } else if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
