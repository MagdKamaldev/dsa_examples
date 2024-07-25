package Bitwise;

public class FindWeatherNumberIsAPowerOftwo {
    public static void main(String[] args) {
        int number = 16;
        System.out.println(PowerOrNot(number));
        System.out.println(AndNumberMinusOne(number));
    }

    private static boolean AndNumberMinusOne(int number) {
        if(number==0){
            return false;
        }
        return  (number & number-1) == 0;
    }

    private static boolean PowerOrNot(int number) {
        int counter = 0;
        while(number>0){
            int last = number&1;
            if(last ==1){
                counter++;
            }
            number >>=1;
        }
        return counter == 1;
    }


}
