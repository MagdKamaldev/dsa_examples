package binary_search;
import java.util.Arrays;

public class first_and_last_position {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,7,7,7,7,8,9},7)));

    }
    public static int[] searchRange(int[] nums, int target) {
        int [] ans = {-1,-1};
        int start = search(nums,target,true);
        int end = search(nums,target ,false);
        ans[0]=start;
        ans[1]=end;
        return ans;
    }
    static int search (int [] nums,int target,boolean findStart){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                ans = mid;
                if(findStart){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return ans;

    }
}
