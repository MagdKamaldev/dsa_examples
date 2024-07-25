package Bitwise;

public class FindNumberOfSetBits {
    public static void main(String[] args) {
        int number = 45;
        System.out.println(numberOfSetBits(number));
    }

    private static int numberOfSetBits(int number) {
        int answer = 0;
        while(number>0){
            number = number & number-1;
            answer++;
        }
        return answer;
    }
}
