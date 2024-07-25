package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
     int[] nums = new int[]{45,34,26,57,89,1,3,21,14,6,8,9};
     sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    static void sort(int[] nums,int low ,int high){
        if(low>=high){
            return;
        }
        int s = low;
        int e = high;
        int mid = s+(e-s)/2;
        int pivot = nums[mid];
        while(s<=e){
            while(nums[s]<pivot){
                s++;
            }
            while(nums[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp = nums[s];
                nums[s]=nums[e];
                nums[e]= temp;
                s++;
                e--;
            }
        }
        // now pivot is at a correct index so sort the two other halves
        sort(nums,low,e);
        sort(nums,s,high);
    }
}
