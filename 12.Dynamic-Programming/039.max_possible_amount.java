
//Optimal Strategy for a Game 


import java.io.*; 

class dp{ 

	
	static int optimalStrategyOfGame(int arr[], int n) 
	{ 
		
		int table[][] = new int[n][n]; 
		int gap, i, j, x, y, z; 

             for(gap=0;gap<n;++gap){
               for(i=0,j=gap;j<n;++i,++j){

                 x=((i+2)<=j)?table[i+2][j]:0;
                 y=((i+1)<=(j-1))?table[i+1][j-1]:0;
                 z=(i<=(j-2))?table[i][j-2]:0;

                 table[i][j]=Math.max(arr[i]+Math.min(x,y),arr[j]+Math.min(y,z));
               }
             }
           return table[0][n - 1]; 
	} 

	
	public static void main(String[] args) 
	{ 
		int arr1[] = { 8, 15, 3, 7 }; 
		int n = arr1.length; 
		System.out.println("" + optimalStrategyOfGame(arr1, n)); 

	
	} 
} 
