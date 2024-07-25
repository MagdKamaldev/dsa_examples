package Bitwise;

public class PsacalRowSum {
    public static void main(String[] args) {
     int n = 5;
        System.out.println(sum(n));
    }

    private static int sum(int n) {
        return 1<<n-1;
    }
}
