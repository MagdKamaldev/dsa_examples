package Bitwise;

public class XorFromAtoB {
    public static void main(String[] args) {
    int a = 5;
    int b = 7;
        System.out.println(xorRange(a,b));
    }

    private static int xorRange(int a, int b) {
        int xor1 = xorTill(a-1);
        int xor2 = xorTill(b);
        return xor2^ xor1;
    }

    private static int xorTill(int a) {
        int zeroTillA = 0;
        if(a%4 ==0){
            zeroTillA = a;
        }else if(a%4==1){
            zeroTillA = 1;
        }else if(a%4 == 2){
            zeroTillA = a+1;
        }else {
            zeroTillA = 0;
        }
        return zeroTillA;
    }

}
