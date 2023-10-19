package com.array;

import java.util.Arrays;

public class reshape_matrix {
    public static void main(String[] args) {
        int[][] result = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {

    int [][] answer = new int [r][c];
    int m = mat.length;
    int n = mat [0].length;
    int newRow = 0;
    int newColumn = 0 ;

        if (m * n != r * c) {
            // If the total number of elements doesn't match, can't reshape.
            return mat;
        }

    for(int i = 0;i<m;i++){
        for (int j = 0;j<n;j++){
            answer[newRow][newColumn]=mat[i][j];
            newColumn++;

            if(newColumn==c){
                newRow++;
                newColumn = 0;
            }
        }
    }

    return  answer;
    }
}
