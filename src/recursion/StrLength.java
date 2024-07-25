package recursion;

public class StrLength {
    public static void main(String[] args)
    {


        String str ="Geeks";
        System.out.println(recLen(str));
    }

    static int recLen(String str){
      if(str.equals("")) {
          return 0;
      }
      //.subString makes the net iteration has the same String with one character removed
      return recLen(str.substring(1))+1;
    }
}
