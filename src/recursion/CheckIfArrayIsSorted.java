package recursion;

public class CheckIfArrayIsSorted {
    public static void main(String[] args)
    {

        int[] arr = { 20, 23, 23, 45, 78, 88,66 };
        int n = arr.length;

        // Function Call
        if (arraySortedOrNot(arr, n))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    static boolean arraySortedOrNot(int[] a, int n)
    {
     if(n==1 || n ==0 ){
         return true;
     }

     return a[n-1]>=a[n-2] && arraySortedOrNot(a,n-1);

    }

}
