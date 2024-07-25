package Array;

import java.util.Arrays;

public class target_array_in_given_order {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(new int[]{1,2,3,4,0}, new int[]{0,1,2,3,0})));
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            for (int j = nums.length - 1; j > index[i]; j--) {
                target[j] = target[j - 1];
            }
            target[index[i]] = nums[i];
        }
        return target;
    }
}
