package Math;

public class Sieve {
    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n+1];
        sieve(n,primes);

    }
    static void sieve(int n, boolean[] primes){
        // we start all the values by false, so if the value is not prime we set it to true, so primes are the false one
        for (int i = 2; i*i<=n;i++){
         if(!primes[i]){
             for (int j = i*2; j <= n; j+=i) {
                 primes[j]=true;
             }
         }
        }

        for (int i = 2; i <= n; i++) {
            if(!primes[i]){
                System.out.print(i+" ");
            }
        }

    }
}
