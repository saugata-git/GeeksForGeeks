class dp{
  
   static void printBrackets(int brac[][],int i,int j){
    if(i==j){
     System.out.print((char)('A'+i-1));
    }
    else{
      System.out.print("(");
      printBrackets(brac,i,brac[i][j]);
      printBrackets(brac,brac[i][j]+1,j);
      System.out.print(")");
 
    }
   }
   static void mcm(int p[],int  n){

          int [][] m = new int[n][n];
          int [][] brackets = new int[n][n];
			
	   for (int l = 1; l < n-1; l++){
    	       for (int i = 1; i < n - l; i++){
    		   int  j = i + l;
    	           int min = Integer.MAX_VALUE;
    	           for (int k = i; k < j; k++){	    
			int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
			if (q < min){
			     min = q;
			     brackets[i][j] = k;
			}
        	   }
        	m[i][j] = min;
    	        }
	   }
          System.out.println("Multiplication order");
	  printBrackets(brackets,1,n-1);
          System.out.println();
	  System.out.println("No of operations--> "+m[1][n-1]);
   }	
   public static void main(String args[]){ 
	int arr[] = {2, 40, 2, 40, 5} ; 
	int size = arr.length; 
        mcm(arr,size);
  }
}
