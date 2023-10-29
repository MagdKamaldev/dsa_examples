package linear_search;

public class basic {
    public static void main(String[] args) {
   int [] nums = {1,2,3,4,5,6};
   int target  = 6;
        System.out.println(linearSearch(nums,target));
        System.out.println(linearSearchBoolean(nums,target));
    }

    static Boolean linearSearchBoolean(int[] arr,int target){
        if(arr.length==0){
            return false;
        }
        for (int element:arr) {
            if(element==target){
                return true;
            }
        }
        return false;
    }

    static int linearSearch(int[] arr,int target){
      if(arr.length==0){
          return -1;
      }
        for (int i = 0; i <arr.length ; i++) {
            int element = arr[i];
            if(element==target){
                return i;
            }

        }
        return -1;
    }
}
