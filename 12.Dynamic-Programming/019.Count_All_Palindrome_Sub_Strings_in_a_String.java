public class dp{


    static int CountPS(char str[],int n){

         int dp[][]= new int[n][n];
         boolean p[][]= new boolean[n][n];

         for(int i=0;i<n;i++)
            p[i][i]=true; 
    
         for(int i=0;i<n-1;i++){
            if(str[i]==str[i+1]){
              p[i][i+1]=true;
              dp[i][i+1]=1;
            }
         }


         for(int gap=2;gap<n;gap++){
             for(int i=0;i<n-gap;i++){

               int j=gap+i;
               
               // If current string is palindrome 
               if(str[i]==str[j] && p[i+1][j-1])
                  p[i][j]=true;
             
               // Add current palindrome substring ( + 1) 
               // and rest palinrome substring (dp[i][j-1] + dp[i+1][j]) 
               // remove common palinrome substrings (-dp[i+1][j-1]) 
               
               if(p[i][j]==true)
                   dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
               else
                   dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
             }
         }
         return dp[0][n-1];
    } 
    
    public static void main(String[] args) 
    { 
        String str = "abaab"; 
        System.out.println(CountPS(str.toCharArray(), str.length())); 
    } 
} 
    
