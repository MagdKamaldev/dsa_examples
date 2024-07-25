package recursion;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args)
    {
        int [] arr= {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr, arr.length);

        System.out.println("Sorted array : ");
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int [] arr, int length){
    boolean swapped = false;
     if(length == 1){
         return;
     }

     for(int i = 0 ; i<length-1;i++){
         if(arr[i]>arr[i+1]){
             swap(arr,i,i+1);
             swapped = true;
         }
     }

     if(!swapped){
         return;
     }

     bubbleSort(arr, length - 1);
    }

    static void swap(int [] arr,int first ,int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
