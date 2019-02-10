// Overlapping Subproblems && optimal substructure
import java.util.*;
public class dp{
 
   static int MAX =100;
   static int [][]dp;
   
   static int largestZigZagSumRec(int mat[][], int i,int j, int n){
   
    if(dp[i][j]!=0)
       return dp[i][j];
       
    if(i==n-1)
       return dp[i][j]= mat[i][j];
       
    int zzs=0;
    for(int k=0;k<n;k++)
      if(k!=j)
        zzs= Math.max(zzs,largestZigZagSumRec(mat, i+1, k, n)); 
        
    return dp[i][j] = (zzs + mat[i][j]); 
   } 
   

   static int largestZigZag(int mat[][],int n){
     int res=0;
     for(int j=0;j<n;j++){
        res=Math.max(res,largestZigZagSumRec(mat, 0, j, n)); 
     }
     return res;
   }
 
  public static void main(String args[]){
    int n=3;
    dp=new int[MAX][MAX];
    int mat[][] = { {4, 2, 1}, 
                    {3, 9, 6}, 
                    {11, 3, 15} }; 
        System.out.println( "Largest zigzag sum: " + largestZigZag(mat, n)); 
    } 
    
}
