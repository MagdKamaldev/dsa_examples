package com.array;

import java.util.Arrays;

public class flipping_image {
    public static void main(String[] args) {
        int[][] result = flipAndInvertImage(new int[][] {{1,1,0},{1,0,1},{0,0,0}});
        printImage(result);
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    public static  int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] answer = new int[rows][cols];

    for (int i = 0;i<rows;i++){
        for(int j = 0;j<cols;j++){
            answer[i][j] = image[i][cols - j - 1];
            answer[i][j] = 1 - answer[i][j];

        }
    }
    return answer;
    }
}
