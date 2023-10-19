package com.array;

public class maximum_sub_array {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
     int currentSum = 0;
     int maxSum = nums[0];
     for(int n:nums){
         if(currentSum<0){
             currentSum= 0;
         }
         currentSum+=n;
         maxSum = Math.max(maxSum,currentSum);
     }
     return  maxSum;
    }
}
