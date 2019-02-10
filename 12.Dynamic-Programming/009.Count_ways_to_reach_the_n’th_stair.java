// Java program to count number of ways to reach n't stair when 
// a person can climb 1, 2, ..m stairs at a time 
  
class  dp{

  //top down
  static int []dp; 
  static int countWaysUtil(int n, int m){ 
        if(n <= 1) 
            return n; 
                    
        if(dp[n] != 0)
            return dp[n];
        int res=0;  
        for(int i = 1; i<=m && i<=n; i++){
            res+=countWaysUtil(n-i, m);           
        }    
            
        return dp[n]=res; 
  } 
    
  /*  
  bottom up
  static int countWaysUtill(int n,int m){
  
    int res[]= new int[n];
    res[0]=1;res[1]=1;
    for(int i=2;i<n;i++){
      res[i]=0;
      for(int j=1;j<=m && j<=i;j++){
       res[i]+=res[i-j];
      }  
    }
    return res[n-1];
  }
  */
    static int countWays(int s, int m){ 
        //return countWaysUtil(s+1, m);
        dp= new int[s+2];
        return countWaysUtil(s+1, m); 
    } 
  
    public static void main(String[] args){ 
        
        int s = 4, m = 2; 
        System.out.println("Number of ways = " + countWays(s, m)); 
    } 

}  
