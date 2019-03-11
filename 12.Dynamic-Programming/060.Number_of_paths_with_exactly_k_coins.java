// A Dynamic Programming based JAVA program  Number of paths with exactly k coins
//Time complexity of this solution is O(m*n*k). 

class kcoins{
  

   static int [][][]dp;

     static int pathCountDPRecDP(int [][]mat, int m, int n, int k){

            if(m<0 || n<0) return 0;
            if(m==0 && n==0)return(k==mat[m][n]?1:0);
            if (dp[m][n][k] != -1) return dp[m][n][k];
            dp[m][n][k] = pathCountDPRecDP(mat, m-1, n, k-mat[m][n]) +pathCountDPRecDP(mat, m, n-1, k-mat[m][n]); 
            return dp[m][n][k];
     }

     static int pathCountDP(int mat[][],int m,int n,int k){

          dp=new int[m][n][k+1]; 
          for(int i=0;i<m;i++) 
            for(int j=0;j<n;j++) 
                for(int l=0;l<k+1;l++) 
                  dp[i][j][l]=-1; 

          return pathCountDPRecDP(mat,m-1,n-1,k);
     }


     public static void main(String []args){ 
        int k = 12; 
	int[][] mat = new int[][]{ 
			new int[] {1, 2, 3}, 
			new int[] {4, 6, 5}, 
			new int[] {3, 2, 1} 
		}; 
         int R=mat.length;
         int C=mat[0].length;
			
          System.out.println(pathCountDP(mat,R,C, k)); 		
     } 
}
