import java.util.*;

class dp{

  static int MaxDotProduct(int A[],int B[],int m,int n){
     int dp[][]=new int [n+1][m+1];
     for(int[] row:dp){
         Arrays.fill(row,0);
     }

     for(int i=1;i<=n;i++){   
         for(int j=i;j<=m;j++){
          dp[i][j]=Math.max(dp[i-1][j-1]+(A[j-1]*B[i-1])), dp[i][j-1]); 
         }
     }
  return dp[m][n];
  }

  public static void main(String[] args) { 
    int A[] = {2, 3, 1, 7, 8}; 
    int B[] = {3, 6, 7}; 
    int m = A.length; 
    int n = B.length; 
    System.out.print(MaxDotProduct(A, B, m, n)); 
 } 
}
