package Array;

import java.util.Arrays;

public class array_shuffle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{1,2,3,4,5,6},3)));
    }
    public static int[] shuffle(int[] nums, int n) {
        int [] result =  new int [2*n];
        for(int i = 0 ; i < n;i++){
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return  result;
    }
}
