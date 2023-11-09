package binary_search;

public class sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }
    public static int mySqrt(int x) {
        double sqrt = x/2;
        double t;
       do{
       t = sqrt;
       sqrt=(t+(x/t))/2;
       }while((t-sqrt)!=0);
        int y = (int)sqrt;
        return y;
    }
}
