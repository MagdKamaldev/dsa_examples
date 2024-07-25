package Array;

public class cells_with_Odd_Values_in_a_Matrix {
    public static void main(String[] args) {

    }
    public static int oddCells(int m, int n, int[][] indices) {
     int [][] ans = new int [m][n];
     int k = indices.length;
     int count = 0;
     for (int i = 0;i<k;i++){
         for(int j = 0;j<n;j++){
             ans[indices[i][0]][j]++;
         }
         for (int j = 0;j<m;j++){
             ans[j][indices[i][1]]++;
         }
     }
     for (int i = 0;i<m;i++){
         for(int j = 0;j<n;j++){
             if(ans[i][j]%2!=0){
                 count++;
             }
         }
     }
     return count;
    }
}
