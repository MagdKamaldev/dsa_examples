package array_with_recursion;

public class FindWeatherTargetExists {
    public static void main(String[] args) {
        int index = 0;
        int target = 18;
        int[]arr = new int[]{1,4,5,7,9,18};
        System.out.println(find(arr,19,0));

    }
    static boolean find(int[]arr,int target,int index){
        if(index==arr.length){
            return false;
        }
        return arr[index]== target || find(arr,target,index+1);
    }
}
