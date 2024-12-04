
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CountSort{
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,2,5,7,9,12,34,2,3,5,6,7,8,16};
        countSortHash(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        int max = array[0];
        for(int num : array){
            if(num>max){
                max = num;
            }
        }

        int[] frequencyArray = new int[max+1];

        for(int num : array){
            frequencyArray[num]++;
        }

        int index = 0;
        for(int i = 0; i < max; i++){
            while(frequencyArray[i]>0){
                array[index] = i;
                index++;
                frequencyArray[i]--;
            }
        }
    }

    public static void countSortHash(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        int max = array[0];
        int min = array[0];
        for(int num : array){
            if(num>max){
                max = num;
            }
        }

         for(int num : array){
            if(num<min){
                min = num;
            }
        }

        Map<Integer,Integer> countMap = new HashMap<>();

        for(int num: array){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        int index = 0;
        for(int i = min; i < max; i++){
           int count = countMap.getOrDefault(i,0);
           for (int j = 0; j < count; j++) {
               array[index] = i;
               index++;
           }
        }
       
    }
}