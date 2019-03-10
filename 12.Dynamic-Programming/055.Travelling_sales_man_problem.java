//T(n)=O(n^2*2^n)
//S(n)=O(n*2^n)

import java.util.*;
public class tsp{

   public static int tsp(int dist[][],int mask,int pos){ 

      int n=dist.length;
      int visited_all=(1<<n)-1;
      int var_2_pow_n=(int)Math.pow(2,n);
      int dp[][]=new int[var_2_pow_n][n];

      for(int i=0;i<(1<<n);i++){
         for(int j=0;j<n;j++){
          dp[i][j]=-1;
         }
      }
       
      if(mask==visited_all){
       return dist[pos][0];
      }
      if(dp[mask][pos]!=-1){
       return dp[mask][pos];
      }
      int ans=Integer.MAX_VALUE;

      for(int city=0;city<n;city++){
            if((mask&(1<<city))==0){                // checks for particular edge bit mask b->0010
              int newAns=dist[pos][city]+tsp(dist,mask|(1<<city),city);// checks for a->0001 b->0010 ,path from a-to-b ->0011
               ans=Math.min(ans,newAns);
            }
      }

     return dp[mask][pos]=ans;

   }
   public static void main(String args[]){

    int dist[][] = { {0,20,42,25},
                     {20,0,30,34},
                     {42,30,0,10},
                     {25,34,10,0}
                   };
    
    System.out.println("Travelling Saleman Distance is "+ tsp(dist,1,0));  //1->0001,0->starting edge
