//Unbounded Knapsack (Repetition of items allowed)

public class dp{
 
   public static int max(int i,int j){
        return (i>j)?i:j;
   }

   public static int uknap(int W,int n,int[]val,int[]wt){
      int []dp=new int [W+1];
      for(int i=0;i<=W;i++){
        for(int j=0;j<n;j++){
          if(wt[j]<=i){
           dp[i]=max(dp[i],dp[i-wt[j]]+ val[j]);
          }
        }
      }
       return dp[W];
   }

   public static void main(String args[]){ 
        int W = 100; 
        int val[] = {10, 30, 20}; 
        int wt[] = {5, 10, 15}; 
        int n = val.length; 
        System.out.println(uknap(W, n, val, wt)); 
    } 

}
