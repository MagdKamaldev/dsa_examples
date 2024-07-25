package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
     int[] arr= new int[]{8,56,34,46,89,13,24,2,4,7,6,9,1};
     mergeSortInPlace(arr,0,arr.length);
     System.out.println(Arrays.toString(arr));
    }
    static int[] mergeSort(int[] arr){
        if(arr.length ==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] answer = new int[first.length+second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i<first.length && j< second.length){
            if(first[i]<second[j]){
                answer[k]= first[i];
                i++;
            }else{
                answer[k]= second[j];
                j++;
            }
            k++;
        }

        while(i<first.length){
            answer[k]= first[i];
            i++;
            k++;
        }

        while(j<second.length){
            answer[k]= second[j];
            j++;
            k++;
        }
        return  answer;
    }

    static void mergeSortInPlace(int[] arr,int start, int end){
        if(end-start == 1){
            return;
        }

        int mid = start + (end-start)/2;
        
        mergeSortInPlace(arr,start,mid);
        mergeSortInPlace(arr,mid,end);

        mergeInPlace(arr,start,mid,end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] answer = new int[end - start];  // Temporary array for merged result
        int i = start;  // Pointer for the first half
        int j = mid;    // Pointer for the second half
        int k = 0;      // Pointer for the answer array

        // Step 3: Compare and merge
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                answer[k] = arr[i];  // If the element in the first half is smaller
                i++;  // Move the pointer in the first half
            } else {
                answer[k] = arr[j];  // If the element in the second half is smaller
                j++;  // Move the pointer in the second half
            }
            k++;  // Move the pointer in the answer array
        }

        // Step 4: Copy remaining elements from the first half, if any
        while (i < mid) {
            answer[k] = arr[i];
            i++;
            k++;
        }

        // Step 4: Copy remaining elements from the second half, if any
        while (j < end) {
            answer[k] = arr[j];
            j++;
            k++;
        }

        // Step 5: Copy the merged result back into the original array
        for (int l = 0; l < answer.length; l++) {
            arr[start + l] = answer[l];
        }
    }
}
