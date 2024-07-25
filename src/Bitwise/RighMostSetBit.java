package Bitwise;

public class RighMostSetBit {
    public static int findRightmostSetBitPosition(int n) {

        int rightmostSetBit = n & -n;
        // Isolates the rightmost set bit, making it the only bit set to 1

        int position = 1;
        // Initialize position counter starting from 1

        while (rightmostSetBit > 1) {
            rightmostSetBit >>= 1; // Shift right until the bit becomes 1
            position++; // Increment position for each shift
        }
        // Return the position of the rightmost set bit
        return position;
    }

    public static int brute(int n){
        int count = 1;
        while (n>0){
            if((n&1)==1){
                return count;
            }else{
                count ++;
                n>>=1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 2048;
        int position = findRightmostSetBitPosition(n);
        System.out.println("The position of the rightmost set bit is: " + position);
        System.out.println(brute(n));
    }
}
