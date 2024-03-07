package strings;

public class Comparison {
    public static void main(String[] args) {
        String magd = new String("magd");
        String b = new String("magd");
        
        System.out.println(magd==b);
        //false, for == operator checks if they are pointing to the same value
        System.out.println(magd.equals(b));
        //true, for .equals checks only for the value
    }
}
