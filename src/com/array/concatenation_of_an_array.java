package com.array;

import java.util.Arrays;

public class concatenation_of_an_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1,2,3})));
    }
    public static int[] getConcatenation(int[] nums) {
        int [] ans =  new int [nums.length*2];
        for (int i = 0 ;i<nums.length;i++){
            ans[i]=nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            ans[nums.length+i]=nums[i];
        }
        return  ans;
    }
}
