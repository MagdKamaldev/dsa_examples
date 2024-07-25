package Math;

public class BinarySearchSquareRoot {
    public static void main(String[] args) {
        int p = 15;
        int n = 80;
        System.out.println(squreRoot(p,n));
    }

    private static double squreRoot(int p, int n) {
      int s = 0;
      int e = n;
      double root = 0.0;
      while(s<=e){
          int m = s+(e-s)/2;
          if(m*m==n){
              return m;
          }else if(m*m>n){
              e = m-1;
          }else{
              s= m+1;
          }
      }

      double inc = 0.1;
        for (int i = 0; i < p; i++) {
            while(root*root<n){
             root+=inc;
            }
            root-=inc;
            inc/=10;
        }
      return root;
    }
}
