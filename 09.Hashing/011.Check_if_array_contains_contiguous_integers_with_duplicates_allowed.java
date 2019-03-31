/*
Check if array contains contiguous integers with duplicates allowed
Time Complexity: O(n)
Auxiliary Space: O(n)
*/

import java.util.*;
class ContigiousElements{

   static Boolean areElementsContiguous(int arr[],int n){
    
      HashSet<Integer> hs= new HashSet<Integer>();
      
      for(int i=0;i<n;i++)
          hs.add(arr[i]);
      int count=1;
      int curr_ele=arr[0]-1;
      while(hs.contains(curr_ele)==true){
         count++;
         curr_ele--;
      }
     
      curr_ele=arr[0]+1;
      while(hs.contains(curr_ele)==true){
         count++;
         curr_ele++;
      }
    
      return (count==(hs.size()));
   }

   public static void main(String args[]){
     int arr[] = { 5, 2, 3, 6, 4, 4, 6, 6 }; 
        int n = arr.length; 
          
        if (areElementsContiguous(arr, n)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
   }
}
