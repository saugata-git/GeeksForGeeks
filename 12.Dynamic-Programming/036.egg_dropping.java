
//Time Complexity: O(nk^2)
//Auxiliary Space: O(nk)

class egg{

  static int max(int a,int b){
   return (a>b)?a:b;
  }

  static int eggDrop(int n,int k){
     
    int dp[][]= new int[n+1][k+1];
    int res;
    int i,j,x;
    for(i=1;i<=n;i++){
       dp[i][1]=1;
       dp[i][0]=0;
    }  

    for(j=1;j<=k;j++){
      dp[1][j]=j;
    }

    for(i=2;i<=n;i++){
       for(j=2;j<=k;j++){
          dp[i][j]=Integer.MAX_VALUE;
          for(x=1;x<j;x++){
          res=1+max(dp[i-1][x-1],dp[i][j-x]);
          if(res<dp[i][j]){
             dp[i][j]=res;
          }
       }
     }
    }
    return dp[n][k]; 
   }

   public static void  main(String[] args){ 
        int n = 2, k = 36; 
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+ " floors is "+eggDrop(n,k));    
    } 
}
  


