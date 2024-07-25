package recursion;

public class Fibo {
    public static void main(String[] args) {
        System.out.println(fibo(50));
    }

    private static int fibo(int n) {
    return (int)((1/Math.sqrt(5)) * (Math.pow(((1+Math.sqrt(5)))/2,n)));
    }

}
