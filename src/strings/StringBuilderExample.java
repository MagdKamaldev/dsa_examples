package strings;

public class StringBuilderExample {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("192.168.1.3"));
    }
    public static String defangIPaddr(String address) {
        StringBuilder defangedAddress = new StringBuilder();
        for(char c : address.toCharArray()){
            if(c=='.'){
                defangedAddress.append("[.]");
            }else{
                defangedAddress.append(c);
            }
        }
        return defangedAddress.toString();
    }
}
