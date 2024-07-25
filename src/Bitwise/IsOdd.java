package Bitwise;

public class IsOdd {
    public static void main(String[] args) {
        int number = 68;
        System.out.println(isOdd(number));
    }

    private static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
