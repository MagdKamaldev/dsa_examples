package Array;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class remove_duplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,2,2,3,3,4,3}));
    }
    public static int removeDuplicates(int[] nums) {

        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }


        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }

     return result.length;
    }
}
