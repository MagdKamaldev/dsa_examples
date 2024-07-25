package Array;

public class highest_altitude {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int [] {-4,-3,-2,-1,4,3,2}));
    }
    public static int largestAltitude(int[] gain) {
      int [] altitudes = new int[gain.length+1];
      altitudes[0]=0;
      int largest = 0;
      int gainIndex = 0;
      for(int i = 1;i <gain.length+1;i++){
              altitudes[i]=altitudes[gainIndex]+gain[gainIndex];
              gainIndex++;
              if(altitudes[i]>largest){
                  largest = altitudes[i];
              }
      }

      return largest;
    }
}
