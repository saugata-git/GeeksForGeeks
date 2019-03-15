// Java program to find first and last occurrence of 
// an elements in given sorted array 
//Time Complexity : O(log n)
//Auxiliary Space : O(1) if we use iterative Binary Search is used
import java.io.*; 

class occ 
{ 
	/*
	public static int first(int arr[], int low, int high, int x, int n) 
	{ 
		if(high >= low) 
		{ 
			int mid = low + (high - low)/2; 
			if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x) 
				return mid; 
			else if(x > arr[mid]) 
				return first(arr, (mid + 1), high, x, n); 
			else
				return first(arr, low, (mid -1), x, n); 
		} 
	return -1; 
	} 

        public static int last(int arr[], int low, int high, int x, int n) 
	{ 
		if (high >= low) 
		{ 
			int mid = low + (high - low)/2; 
			if (( mid == n-1 || x < arr[mid+1]) && arr[mid] == x) 
				return mid; 
			else if (x < arr[mid]) 
				return last(arr, low, (mid -1), x, n); 
			else
				return last(arr, (mid + 1), high, x, n); 
		} 
	return -1; 
	}
        */
        
  public static int b_first(int[] A, int x){
	  int l= 0;
		int r = A.length - 1;
		int result = -1;
		while (l <= r)
		{
			int m = l+(r-l)/2;

			if (x == A[m]) {
				result = m;
				r= m-1;
			}
			else if (x < A[m]) {
				r= m- 1;
			}
			else {
				l= m+ 1;
			}
		}
		return result;
	}
	

       
public static int b_last(int[] A, int x){
    int l= 0;
		int r = A.length - 1;
		int result = -1;
		while (l <= r)
		{
			int m = l+(r-l)/2;

			if (x == A[m]) {
				result = m;
				l= m + 1;
			}
			else if (x < A[m]) {
				r= m- 1;
			}
			else {
				l= m+ 1;
			}
		}
		return result;
	}
	
	
	public static void main (String[] args) 
	{ 
		
		int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8, 8,78}; 
		int n = arr.length; 
		int x = 8; 
		System.out.println("First Occurrence = " +b_first(arr,x)); 
		System.out.println("Last Occurrence = " + b_last(arr,x)); 

	} 
} 
