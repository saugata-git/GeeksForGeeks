/*
// largest Fibonacci subset
Below is an efficient solution based on hashing.
Find max in the array
Generate Fibonacci numbers till the max and store it in hash table.
Traverse array again if the number is present in hash table then add it to the result.
*/
import java.util.*;
import java.util.Collection;
class LargestFibSeq{
  
   public static int maximum(int arr[]){
     int max=Integer.MIN_VALUE;
     for(int i=0;i<arr.length;i++){
         if(arr[i]>max){
           max=arr[i];
         }
     }
     return max;
   }

   public static void findFibSubset(int arr[]){

     int max=maximum(arr);
     List<Integer> fib= new ArrayList<Integer>();
     List<Integer>  result= new ArrayList<Integer>();

     int a=0;
     int b=1;
     while(b<max){
        int c=a+b;
        a=b;
        b=c;
        fib.add(c);
     }

    for(int i=0;i<arr.length;i++){
          if(fib.contains(arr[i])){
            result.add(arr[i]);
          }
    }
    System.out.println(result);
   }

   public static void main(String args[]){

    int a[]={ 4, 2, 8, 5, 20, 1, 40, 13, 23 };
    findFibSubset(a);

   }
}
