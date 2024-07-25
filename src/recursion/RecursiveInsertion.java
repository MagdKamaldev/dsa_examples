package recursion;

import java.util.Arrays;

public class RecursiveInsertion {
    public static void main(String[] args)
    {
        int arr[] = {12, 11, 13, 5, 6};

        insertionSortRecursive(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSortRecursive(int [] arr, int n)
    {
        if(n > arr.length-2){
            return;
        }

        for (int j = n+1; j>0 ; j--) {
            if(arr[j]<arr[j-1]){
                swap(arr,j,j-1);
            }else{
                break;
            }
        }

        insertionSortRecursive(arr,n+1);

    }

    static void swap(int [] arr,int first ,int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
