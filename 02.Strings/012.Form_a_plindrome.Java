/*
Minimum insertions to form a palindrome
Time complexity: O(N^2)
Auxiliary Space: O(N^2)
*/
import java.util.Arrays; 

class FormPalindrome{ 

        static int findMinInsertionDP(char str[],int n){
   
         int table[][]=new int[n][n];
         int l,h,gap;
          for(gap=1;gap<n;gap++){
              for(l=0,h=gap;h<n;l++,h++){
              table[l][h]=(str[l]==str[h])?table[l+1][h-1]:(Integer.min(table[l+1][h],table[l][h-1]))+1;
              }
          } 
          return table[0][n-1];

        }
        public static void main(String args[]){ 
		String str = "geeks"; 
		System.out.println(findMinInsertionDP(str.toCharArray(), str.length())); 
	} 
}
