/* Java program to remove all adjacent duplicates from a string 
Time Complexity: The time complexity of the solution can be written as T(n) = T(n-k) + O(k) where n is length of the 
input string and k is the number of first characters which are same. Solution of the recurrence is O(n)*/

import java.io.*; 
import java.util.*; 

class RemoveAdjDupRec { 
	// Recursively removes adjacent duplicates from str and returns 
	// new string. las_removed is a pointer to last_removed character 

	static String removeUtil(String str, char last_removed) 
	{ 
			// If length of string is 1 or 0 
			if(str.length()==0 || str.length()==1)
                            return str; 

			// Remove leftmost same characters and recur for remaining 
			// string 
			if(str.charAt(0)==str.charAt(1)){
                             last_removed=str.charAt(0);
                             while(str.length()>1 && str.charAt(0)=str.charAt(1)){
                               str=str.substring(1,str.length());
                             }
                             str=str.substring(1,str.length());
                           return removeUtil(str,last_removed);
                        }

			// At this point, the first character is definiotely different 
			// from its adjacent. Ignore first character and recursively 
			// remove characters from remaining string 
			String rem_str = removeUtil(str.substring(1,str.length()), last_removed); 

			// Check if the first character of the rem_string matches with 
			// the first character of the original string 
			if (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0)) 
			{ 
				last_removed = str.charAt(0); 
				return rem_str.substring(1,rem_str.length()); // Remove first character 
			} 


			// If remaining string becomes empty and last removed character 
			// is same as first character of original string. This is needed 
			// for a string like "acbbcddc" 
			if (rem_str.length() == 0 && last_removed == str.charAt(0)) 
				return rem_str; 

			// If the two first characters of str and rem_str don't match, 
			// append first character of str before the first character of 
			// rem_str 
			return (str.charAt(0) + rem_str); 
	} 

	static String remove(String str) 
	{ 
			char last_removed = '\0'; 
			return removeUtil(str, last_removed);	 
	} 

	
	public static void main(String args[]) 
	{ 
			String str1 = "geeksforgeeg"; 
			System.out.println(remove(str1)); 

	} 
} 

