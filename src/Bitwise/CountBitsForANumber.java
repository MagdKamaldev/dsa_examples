package Bitwise;

public class CountBitsForANumber {
    public static void main(String[] args) {
        int number = 14;
        int base = 2;
        System.out.println(binaryBits(number));
        System.out.println(bitsFormulaAnyBase(number,base));
    }

    private static int bitsFormulaAnyBase(int number, int base) {
        return (int)(Math.log(number)/Math.log(base))+1;
    }

    private static int binaryBits(int number) {
        int counter = 0;
        while(number>0){
            number>>=1;
            counter++;
        }
        return counter;
    }
}
