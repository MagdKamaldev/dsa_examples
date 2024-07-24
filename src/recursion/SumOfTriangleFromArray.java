package recursion;

import java.util.Arrays;

public class SumOfTriangleFromArray {
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5 };
        printTriangle(A);
    }
    static void printTriangle(int[] A){
        if(A.length <1){
            return;
        }
        int[] temp = new int[A.length - 1];
        for(int i = 0 ; i < A.length-1; i++){
            temp[i]= A[i]+A[i+1];
        }

        System.out.println(Arrays.toString(A));
        printTriangle(temp);


    }
}
