//Time complexity of the above dynamic programming solution is O(mn).
//Note the count can also be calculated using the formula (m-1 + n-1)!/(m-1)!(n-1)!.  --O(1)
class dp{

   static int nop(int m,int n){
   
    int count[][]= new int[m][n];
    for(int i=0;i<m;i++)
      count[i][0]=1;
    for(int j=0;j<n;j++)
      count[0][j]=1;
      
     for(int i=1;i<m;i++){ 
        for (int j=1;j<n;j++){
            count[i][j]=count[i-1][j]+count[i][j-1];
        }
     }   
           
      return count[m-1][n-1];         
   }
   
   //space optimized method
    static int nop1(int m,int n){
    
        int[] dp = new int[n]; 
        dp[0] = 1; 
        for(int i=0;i<m;i++){ 
           for (int j=1;j<n;j++){
              dp[j]+=dp[j-1];
        }
     }  
     return dp[n-1];
    
    }
   
   
   public static void main(String args[]) 
    { 
        System.out.println(nop(3, 3)); 
        System.out.println(nop1(3, 3)); 
    } 

}
