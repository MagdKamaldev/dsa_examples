package binary_search;

public class peak_of_mountain_arr {
    public static void main(String[] args) {
        System.out.println(peak(new int []{1,2,3,4,6,3,2,1}));
    }
    static int peak (int [] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
           int  mid = start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }else{
               start=mid+1;
            }
        }
        return end;
    }
}
