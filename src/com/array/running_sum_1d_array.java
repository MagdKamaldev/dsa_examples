package com.array;

import java.util.Arrays;

public class running_sum_1d_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1,1,1,1,1})));
    }
    public static  int[] runningSum(int[] nums) {
        int [] ans =  new int [nums.length];
        ans[0]=nums[0];
        for (int i=1;i<nums.length;i++){
          ans[i] = ans[i-1]+nums[i];
        }
        return  ans;
    }
}
