package Bitwise;

public class FindUniqueInNRepeats {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 3, 2, 3, 7}; // Example array
        int n = 3; // Each number except one appears 3 times

        int uniqueNumber = findUnique(nums, n);
        System.out.println("The unique number is: " + uniqueNumber);
    }

    public static int findUnique(int[] nums, int n) {
        // Create an array to hold count of bits
        int[] bitCount = new int[32];

        // Count the number of times each bit is set across all numbers
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        // Construct the unique number from the bits
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % n != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}
