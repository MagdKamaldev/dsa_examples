package com.array;

import java.util.Arrays;

public class plus_one {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {9,9,9})));
    }
    public static int[] plusOne(int[] digits) {

     for(int i = digits.length-1;i>=0;i--){
         if(digits[i]==9){
             digits[i]=0;
         }else{
             digits[i]++;
             return digits;
         }
     }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;

    }
}
