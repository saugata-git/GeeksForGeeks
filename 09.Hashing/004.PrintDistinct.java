/*
We can Use Hashing to solve this in O(n) time on average. The idea is to traverse the 
given array from left to right and keep track of visited elements in a hash table.
One more advantage of hashing over sorting is, the elements are printed in same order as
they are in input array.
*/
import java.util.*;

class PrintDistinct{

   static void printDistinct(int arr[]){
    
     HashSet<Integer> set= new HashSet<>();
 
     for(int i=0;i<arr.length;i++){
       
       if(!set.contains(arr[i])){
        set.add(arr[i]);
        System.out.print(arr[i]+" ");
       }   
     }
   }

   public static void main(String args[]){
    int arr[]={10, 5, 3, 4, 3, 5, 6};
    printDistinct(arr);
   }
}
