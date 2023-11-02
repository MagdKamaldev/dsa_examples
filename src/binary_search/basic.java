package binary_search;

public class basic {
    public static void main(String[] args) {
  int [] arr = {-18,-12,4,0,2,3,4,15,16,18,22,45,89};
  int target = 22;
        System.out.println(binaryserch(arr,target,0,arr.length));
    }
    static int binaryserch(int [] arr,int target,int start ,int end){
       while(start<=end){
       int mid = start+(end-start)/2;
       if(target<arr[mid]){
           end=mid-1;
       }else if(target>arr[mid]){
             start=mid+1;
           }else{
           return mid;
           }
       }
       return -1;
    }
}



