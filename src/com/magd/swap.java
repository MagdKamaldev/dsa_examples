package com.magd;

import java.util.Arrays;

public class swap {
    public static void main(String[] args) {
        int [] arr = {1,3,67,89};
        swap(arr,0,1);
        System.out.println(Arrays.toString(arr));

    }
    static void swap(int [] arr, int index1,int index2){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
        System.out.println("222222");
    }
}
