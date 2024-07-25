package Array;

import java.util.Arrays;

public class how_many_numbers_smaller_than_current {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8,1,2,2,3})));
    }
    public static  int[] smallerNumbersThanCurrent(int[] nums) {
      int[] ans = new int [nums.length];

      for (int i = 0 ;i<nums.length;i++){
          for(int j = 0;j<nums.length;j++){
              if(nums[i]>nums[j]){
                  ans[i]++;
              }
          }
      }
      return ans;
    }
}
