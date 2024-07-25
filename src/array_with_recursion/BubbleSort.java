package array_with_recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
    int[]arr = new int[]{3,5,6,2,7,8,14,56,23,15};
    bubble(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int[] arr,int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
         if(arr[c]>arr[c+1]){
             swap(arr,c,c+1);
         }
         bubble(arr,r,c+1);
        }
        bubble(arr,r-1,0);
    }
    static  void swap(int [] arr,int first ,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr [second] = temp;
    }
}
