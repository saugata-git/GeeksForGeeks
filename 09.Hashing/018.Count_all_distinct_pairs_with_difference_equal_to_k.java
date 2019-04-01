/*
1) Initialize count as 0.
2) Insert all distinct elements of arr[] in a hash map.  While inserting, 
   ignore an element if already present in the hash map.
3) Do following for each element arr[i].
   a) Look for arr[i] + k in the hash map, if found then increment count.
   b) Look for arr[i] - k in the hash map, if found then increment count.
   c) Remove arr[i] from hash table. 

A very simple case where hashing works in O(n) time is the case where range of values is very small
*/

import java.util.*; 
class CountPairsWithDiffK{

   
   static int countPairsWithDiffK(int arr[], int n, int k){ 
     int count=0;
     int MAX=100;
     boolean hashmap[]= new boolean[MAX];

     for(int i=0;i<n;i++){
         hashmap[arr[i]] = true; 
     }

     for(int i=0;i<n;i++){
        int x=arr[i];
        if(x-k>=0 && hashmap[x-k])
          count++;
        if(x+k<MAX && hashmap[x+k])
          count++;
        hashmap[x]=false;
     }
     return count;
   }

   public static void main(String[] args){ 
      int arr[] = {1, 5, 3, 4, 2}; 
      int n = arr.length; 
      int k = 3; 
      System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k)); 
   } 

} 
  
