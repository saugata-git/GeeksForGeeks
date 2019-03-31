/*
Find the length of largest subarray with 0 sum

We can Use Hashing to solve this problem in O(n) time. 
The idea is to iterate through the array and for every element arr[i], calculate sum of elements form 0 to i
(this can simply be done as sum += arr[i]). If the current sum has been seen before, then there is a zero sum array.
Hashing is used to store the sum values, so that we can quickly store sum and find out whether the current sum is seen
before or not.

*/
import java.util.*;

class MaxLenZeroSumSub{

   public static int maxLen(int arr[]){
  
       HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
       int sum=0;
       int max_len=0;

       for(int i=0;i<arr.length;i++){
           sum+=arr[i];

           if(arr[i]==0 && max_len==0)
               max_len=1;

           if(sum==0)
             max_len=i+1;

         int prev_i=hm.get(sum);
         if(prev_i != null)
              max_len=Math.max(max_len,i-prev_i);
         else
           hm.put(sum,i);
       }
       return max_len;
   }

   public static void main(String args[]){
    
    int arr[]={15, -2, 2, -8, 1, 7, 10, 23};
    System.out.println("Length of the longest 0 sum subarray is "+ maxLen(arr)); 

   }
}
