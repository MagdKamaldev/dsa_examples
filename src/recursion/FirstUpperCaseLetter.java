package recursion;

public class FirstUpperCaseLetter {
    public static void main(String args[])
    {
        String str = "geeksforgees";
        char res = first(str,0);
        if (res == 0)
            System.out.println("No uppercase letter");
        else
            System.out.println(res);
    }

    static char first(String str,int index)
    {
        if(index == str.length()){
            return 0;
        }
        if(Character.isUpperCase(str.charAt(index))){
            return str.charAt(index);
        }else{
            return first(str,index+1);
        }
    }
}
