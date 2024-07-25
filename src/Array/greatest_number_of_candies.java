package Array;

import java.util.ArrayList;
import java.util.List;

public class greatest_number_of_candies {
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3},3));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int highestKid=0;
        for(int i = 0 ;i<candies.length;i++){
            if(candies[i]>highestKid){
                highestKid = candies[i];
            }
        }
        for(int i = 0 ;i<candies.length;i++){
            if(candies[i]+extraCandies>=highestKid){
               result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}
