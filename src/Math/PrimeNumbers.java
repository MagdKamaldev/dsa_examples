package Math;

public class PrimeNumbers {
    public static void main(String[] args) {
        int x = 18;
        System.out.println(isPrime(x));

    }

    private static boolean isPrime(int x) {
        if(x<=1){
            return false;
        }
        int c = 2;
        while(c*c<=x){
            if(x%c==0){
                return false;
            }
            c++;
        }
        return true;
    }
}
