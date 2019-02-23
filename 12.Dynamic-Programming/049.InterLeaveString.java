
//Find if a string is interleaved of two other strings
//Time Complexity: O(MN)
//Auxiliary Space: O(MN

import java.util.*;
class dp{
   
boolean isInterLeaved(String a,String b,String c){
      int M=a.length();
      int N=b.length();
      int O=c.length();
      boolean [][]dp= new boolean[M+1][N+1];

      if((M+N)!=O){
        return false;
      }

      for(int i=0;i<=M;i++){
          for(int j=0;j<=N;j++){

               if(i==0&&j==0){
                  dp[i][j]=true;
               }
                else if(i==0 && b.charAt(j-1)==c.charAt(j-1))
                {
                    dp[i][j]=dp[i][j-1];
                }
                else if(j==0 && a.charAt(i-1)==c.charAt(i-1))
                {
                    dp[i][j]=dp[i-1][j];
                }
                else if(i>0 && j>0 && a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)!=c.charAt(i+j-1))
                {
                    dp[i][j]=dp[i-1][j];
                }
                else if(i>0 && j>0 && a.charAt(i-1)!=c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1))
                {
                    dp[i][j]=dp[i][j-1];
                }
                else if(i>0 && j>0 && a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1))
                {
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];
                }
          }
      }
     
     return dp[M][N];
   }
   
   public static void main(String args[]){

       dp ob=new dp();
       String A="XXY";
       String B="XXZ";
       String C="XXZXXY";     
      
      if(ob.isInterLeaved(A,B,C)){
         System.out.println("yes");
      }
      else{
          System.out.println("no");
      }

   }
}
