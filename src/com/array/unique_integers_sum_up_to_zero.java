package com.array;

import java.util.Arrays;

public class unique_integers_sum_up_to_zero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }
    public static  int[] sumZero(int n) {
     int [] ans = new int[n];

        if(n%2==0){
         for(int i = 0;i<n/2;i++){
             ans[i]=i+1;
             ans[i+n/2]=-(i+1);
         }
        }
       else{
           for(int i = 0; i<n;i++){
               if(i<n/2){
                   ans[i]=i+1;
               } else if (i > n / 2){
                   ans[i]=-(i-n/2);
               }
            }
           }
     return ans;
    }
}
