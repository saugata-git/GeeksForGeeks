import java.util.*;
import java.lang.Math;
public class tsp{
    

    public static int  tsp(int dist[][],int mask,int pos,int n){

      int VISITED_ALL = (1<<n) -1;
      int  var_2_pow_n=(int)Math.pow(2,n);
      int dp[][]=new int[var_2_pow_n][4];

        for(int i=0;i<(1<<n);i++){
          for(int j=0;j<n;j++){
             dp[i][j] = -1;
          }
        }
	
	   if(mask==VISITED_ALL){
		     return dist[pos][0];
	   }
	   if(dp[mask][pos]!=-1){
	       return dp[mask][pos];
	   }	
	   int ans = Integer.MAX_VALUE;
     
  	for(int city=0;city<n;city++){
	         	if((mask&(1<<city))==0){
			             int newAns = dist[pos][city] + tsp(dist ,mask|(1<<city), city,n);
			             ans = Math.min(ans, newAns);
		        }
   	}
	
	   return dp[mask][pos] = ans;
   } 
      


  
  public static void main(String args[]){
    int n=4;
    int dist[][] = { {0,20,42,25},
                     {20,0,30,34},
                     {42,30,0,10},
                     {25,34,10,0}
                   };
      
   System.out.println("Travelling Saleman Distance is "+ tsp(dist,1,0,n));
   
  }
}
