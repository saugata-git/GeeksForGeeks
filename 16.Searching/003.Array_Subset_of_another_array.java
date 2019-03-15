// Java code to find whether an array is subset of another array
//1) Sort both arrays: arr1[] and arr2[] O(mLogm + nLogn)
//2) Use Merge type of process to see if all elements of sorted arr2[] are present in sorted arr1[].
// Time Complexity: O(mLogm + nLogn)

import java.util.Arrays; 
class issubset
{ 
	
	static boolean isSubset(int arr1[], int arr2[], int n, int m) 
	{ 
		int i = 0, j = 0; 
			
		if(m > n) 
		   return false; 
		
		Arrays.sort(arr1); 
		Arrays.sort(arr2);  


               while(i<n && j<m){

                    if(arr1[i]<arr2[j]){
                       i++;
                    }
                    else if(arr1[i]==arr2[j]){
                         i++;
                         j++;
                    }
                    else if(arr1[i]>arr2[j]){
                      return false;
                    }
               }
              if(j<m)
                   return false;
              else
                 return true;

	} 
		
	public static void main(String[] args) 
	{ 
		int arr1[] = {11, 1, 13, 21, 3, 7}; 
		int arr2[] = {11, 3, 7, 1}; 
		
		int n = arr1.length; 
		int m = arr2.length; 
		
		if(isSubset(arr1, arr2, n, m)) 
		   System.out.println("arr2 is a subset of arr1"); 
		else
		   System.out.println("arr2 is not a subset of arr1"); 
	} 
} 
 
