package com.array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class add_to_array_form_of_int {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        int k = 1;

        List<Integer> result = addToArrayForm(num, k);

        // Print the result
        System.out.println("Resulting List: " + result);
    }
    public static List<Integer> addToArrayForm(int[] num, int k) {
        int number = 0;
        int multiplied = 1;
        List<Integer> result = new ArrayList<>();
        for(int i = num.length-1;i>=0;i--){
            number+=num[i]*multiplied;
            multiplied*=10;
        }
        number+=k;
        while(number>0){
            result.add(number%10);
            number/=10;

        }
        if (result.isEmpty()) {
            result.add(0);
        }

        Collections.reverse(result);
        return  result;
    }

}
