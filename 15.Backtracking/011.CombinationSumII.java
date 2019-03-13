
/*
(1) Let us see the difference between Combination Sum and Combination Sum II:
The input of Combination Sum has no dups, but each element can be used for MORE than one time.
The input of Combination Sum II has dups, but each element can be used ONCE.

(2) Let us understand the time complexity of Combination Sum II at the beginning:
O(k * 2 ^ n) is the time complexity of Combination Sum II:
k is average length of each solution, and we need O(k) time to copy new linkedlist when we get one combination.

Solution space:
Since we use one element ONLY for one time, so, for the combinations with k elements, the number of
different choices is C(n, k). And 
most of the time, this number is far smaller than k. But what is the worst case?
int[] arr = {1,1,1,1,1,1,1,1,1}, target is 2, in this case, the number can actually reach C(n,k).

Considering that the combinations may have different length, which range from 0 ~ n. So, there are at most
C(n,0) + C(n,1) + C(n,2) + ... C(n,n) solutions. We know that C(n,0) + C(n,1) + C(n,2) + ... C(n,n) = 2^n. 
Then we got the time complexity of Combination Sum II which is O(k * 2 ^ n).

(3) Then how we convert Combination Sum to Combination Sum II?
For example, given int[] arr = {2, 3, 4, 5, 6} and target is 10 and each element can be used for MORE than once.
Actually, it is same with the problem: given int[] arr = {2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6}, and target 10,
each element can be used for ONLY one time, which is the same description of Combination Sum II.

And you must find that for the new array, each element E, which is smaller than target, will expand to ceil(target/E). 
Assume the new array has length n', we can get the time complexity which is O(k * 2 ^ n') using the same analysis
of Combination Sum II.

*/

import java.util.*;
class combinationSum2{


    private static void helper(int[] arr,int start,int target,List<Integer>list,List<List<Integer>>result){
 
     if(target==0){
       result.add(new ArrayList<>(list));
       return;
     }

     if(target<0){
       return;
     }
    
     int prev=-1;
     for(int i=start;i<arr.length;i++){
       if(arr[i]!=prev){
            list.add(arr[i]);
            helper(arr,i+1,target-arr[i],list,result);
            list.remove(list.size()-1);
            prev=arr[i];
       }
     }
   
   }

   public static List<List<Integer>> cSum(int []arr,int target){
          List<List<Integer>>result= new ArrayList<>();
          List<Integer>list= new ArrayList<>();
          helper(arr,0,target,list,result);
          return result;
   }

   public static void main(String args[]){ 
          int arr[]={1,2,6,3,7};
          System.out.println(cSum(arr,7));
   }

}
