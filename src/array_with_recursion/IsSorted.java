package array_with_recursion;

public class IsSorted {
    public static void main(String[] args) {
    int index = 0;
    int[]arr = new int[]{1,4,5,7,9};
        System.out.println(isSorted(index,arr));
    }
    static boolean isSorted(int index, int[] arr){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && isSorted(index+1,arr);
    }
}
