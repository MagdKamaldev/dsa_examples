package com.array;

public class even_digits {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int [] {12,345,2,6,7896}));
    }
    public static  int findNumbers(int[] nums) {
    int numbers = 0;
    for (int i = 0;i<nums.length;i++){

        if(String.valueOf(nums[i]).length()%2==0){
            numbers++;
        }
    }
    return numbers;
    }
}
