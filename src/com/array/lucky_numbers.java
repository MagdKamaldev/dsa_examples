package com.array;
import java.util.ArrayList;
import java.util.List;

public class lucky_numbers {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };

        List<Integer> result = luckyNumbers(matrix);
        System.out.println("Minimum numbers: " + result);
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {

    List<Integer> numbers = new ArrayList<>();
    for(int i = 0;i<matrix.length;i++){
        int number = 100000;
        int smallestIndex = -1;
        boolean isGreatest = true;
        for(int j = 0 ;j<matrix[i].length;j++){
           int  temp = matrix[i][j];
            if(temp<number){
                number = temp;
                 smallestIndex = j;
            }
        }
        for(int k = 0 ;k<matrix.length;k++){
           if(matrix[k][smallestIndex]>number){
               isGreatest =false;
               break;
           }
        }
        if(isGreatest){
            numbers.add(number);

        }
    }

    return numbers;
    }
}
