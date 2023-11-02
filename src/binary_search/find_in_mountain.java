package binary_search;

public class find_in_mountain {
    public static void main(String[] args) {

    }
    static int search(int [] arr,int target){
      int peak = peak(arr);
      int firstTry = orderIgnosticBS(arr,target,0,peak);
      if(firstTry!=-1){
          return firstTry;
      }
     return  orderIgnosticBS(arr,target,peak+1,arr.length-1);

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
    static  int orderIgnosticBS(int [] arr,int target,int start ,int end){
        boolean isAsc = arr[start]<arr[end];
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(isAsc){
                if(target<arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(target>arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}
