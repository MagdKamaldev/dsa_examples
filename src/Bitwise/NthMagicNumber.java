package Bitwise;

public class NthMagicNumber {
    public static void main(String[] args) {
        int number = 1;
        System.out.println(magic(number));
    }

    private static int magic(int number) {
        int answer = 0;
        int base = 5;
        while(number > 0){
            int last = number & 1;
            answer += last * base;
            base *= 5;
            number >>=1 ;
        }
        return answer;
    }

}
