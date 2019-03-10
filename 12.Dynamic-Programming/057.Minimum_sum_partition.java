//Time Complexity = O(n*sumTotal) where n is number of elements and sum is sum of all elements.
//Note that the above solution is in Pseudo Polynomial Time (time complexity is dependent on numeric value of input).
import java.util.*; 

class minsumpart{ 
	
	static int [][]dp; 
        static int sumTotal;
	public static int findMinRec(int arr[], int i,int sumCalculated, int sumTotal) 
	{ 
	
		if (i == 0) 
			return Math.abs((sumTotal-sumCalculated) -sumCalculated); 

                if(dp[i][sumCalculated] != -1)
                        return dp[i][sumCalculated];

	       
		return dp[i][sumCalculated] =  Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i-1], sumTotal),   findMinRec(arr, i-1,sumCalculated, sumTotal)); 
	} 
	

	
	public static int findMin(int arr[], int n) 
	{ 
		int sumTotal = 0; 
		for (int i = 0; i < n; i++) 
			sumTotal += arr[i]; 
                dp= new int[n+1][sumTotal+1];
                 for(int i=0;i<n+1;i++){
                Arrays.fill(dp[i],-1);
                }
		return findMinRec(arr, n, 0, sumTotal);
                
                
	} 
	
	public static void main(String[] args) 
	{ 
		int arr[] = {36 ,7 ,46, 40}; 
		int n = arr.length; 
		System.out.print("The minimum difference"+ " between two sets is " + findMin(arr, n));

	} 
} 
	
