package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersection_of_two_arrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1},new int []{2,2})) );
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> listOfInt = new ArrayList<Integer>();

        for(int i = 0 ; i<nums1.length;i++){
            for(int j = 0 ; j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    listOfInt.add(nums1[i]);
                    i++;
                }
            }
        }
        int[] arrayOfInt = new int[listOfInt.size()];
        for(int i = 0;i< listOfInt.size();i++){
            arrayOfInt[i] = listOfInt.get(i);
        }
        return  arrayOfInt;
    }
}
