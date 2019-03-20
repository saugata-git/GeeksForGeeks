/*
Find the Number Occurring Odd Number of Times
A Solution is to use Hashing. Use array elements as key and their counts as value. 
Create an empty hash table. One by one traverse the given array elements and store counts. 
Time complexity of this solution is O(n). But it requires extra space for hashing.

The Best Solution is to do bitwise XOR of all the elements. XOR of all elements gives us odd occurring element.
Please note that XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.

*/
import java.io.*;
import java.util.HashMap;

class OddOccurrence{

   /*
   int getOddOccurrence(int arr[],int size){

     int res=0;
     for(int i=0;i<size;i++){
       res=res^arr[i];
     }
     return res;
   }
    */

   public static int getOddOccurance(int arr[],int n){

      HashMap<Integer,Integer>hmap=new HashMap<>();

      for(int i=0;i<n;i++){
        if(hmap.cointainsKey(arr[i])){
          int val=hmap.get(arr[i]);
          hmap.put(arr[i],val+1);
        }
        else
          hmap.put(arr[i],1);
      }
    
      for(Integer a :hmap.KeySet()){
        if(hmap.get(a)%2!=0){
          return a;
        }
       return -1;
      }
   } 

   public static void main(String args[]){

     int arr[]=new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
     int n=arr.length;
     System.out.println(getOddOccurance(arr,n));
   }

}
