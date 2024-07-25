package Array;

import java.util.Arrays;

public class max_wealth {
    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][] {{1,2,3,},{1,2,3,4}}));
    }
    public static int maximumWealth(int[][] accounts) {
    int max_wealth = 0;
    for (int i = 0;i<accounts.length;i++) {
        int arraysum = 0;
        arraysum = Arrays.stream(accounts[i]).sum();
        if (arraysum > max_wealth) {
            max_wealth = arraysum;
        }
    }
    return max_wealth;
    }
}
