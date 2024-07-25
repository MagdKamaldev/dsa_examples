package Bitwise;

public class FindAPowerB {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;
        System.out.println(findAPowerB(a,b));
    }

    private static int findAPowerB(int a ,int b) {
        int answer = 1;
        while(b>0){
        int last = b&1;
        if(last==1){
            answer = answer*a;
        }
        a*=a;
        b>>=1;
    }
    return  answer;
    }
}
