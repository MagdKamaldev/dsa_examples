package strings;

public class PlaceHolders {
    public static void main(String[] args) {
        // %s - String Placeholder
        String name = "John";
        String message1 = String.format("Hello, %s!", name);
        System.out.println(message1);

        // %d - Integer Placeholder
        int age = 25;
        String message2 = String.format("I am %d years old.", age);
        System.out.println(message2);

        // %f - Floating-Point Placeholder
        double price = 19.99;
        String message3 = String.format("The price is %.2f dollars.", price);
        System.out.println(message3);

        // %c - Character Placeholder
        char grade = 'A';
        String message4 = String.format("My grade is %c.", grade);
        System.out.println(message4);

        // %b - Boolean Placeholder
        boolean isJavaFun = true;
        String message5 = String.format("Java is fun: %b", isJavaFun);
        System.out.println(message5);

        // %n - Newline Placeholder
        String multilineMessage = String.format("Line 1%nLine 2");
        System.out.println(multilineMessage);

        // %% - Percent Sign
        double percentage = 0.75;
        String message6 = String.format("The percentage is %.0f%%.", percentage * 100);
        System.out.println(message6);
    }
}
