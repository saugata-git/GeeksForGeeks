/*
Check if there exist two elements in an array whose sum is equal to the sum of rest of the array
Time complexity : O(n). 
Time complexity hash search and insert is assumed as O(1) here.
*/
import java.util.*;

class CheckPair{
  
   static boolean checkPair(int arr[],int n){

      int sum=0;
      for(int i=0;i<n;i++){
         sum+=arr[i];
      }

      // If sum of array is not even than we can not divide it into two part
      if(sum % 2 != 0){
        return false;
      } 
      sum=sum/2;

      HashSet<Integer> s= new HashSet<Integer>();

      for(int i=0;i<n;i++){

         int val=sum-arr[i];

         if(s.contains(val)&& val==(int) s.toArray()[s.size()-1]){
            System.out.println("Pair elements are "+ arr[i]+" "+val);
            return true;
         }

         s.add(arr[i]);
      }
      return false;
   }
 
   public static void main(String args[]){
     int arr[]={2, 11, 5, 1, 4, 7};
     int n=arr.length;
       if(checkPair(arr,n)==false){
         System.out.println("No pair found");
       }
   }
}
