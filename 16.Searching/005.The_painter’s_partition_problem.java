//The painter’s partition problem 
//The time complexity of the above approach is O(N * log (sum (arr[]))

import java.util.*;
import java.io.*;

class pp{

    static int getMax(int arr[],int n){
      int max=Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
         if(arr[i]>max){
            max=arr[i];
         }
       }
       return max;
    }
    
    static int getSum(int arr[],int n){
       int total=0;
       for(int i=0;i<n;i++){
          total+=arr[i];
       }
       return total;
    }

    static int numberOfPainters(int arr[],int n,int maxlen){

       int total=0,numPainters=1;
       for(int i=0;i<n;i++){
          total+=arr[i];
           if(total>maxlen){
             total=arr[i];
             numPainters++;
          }
       }
       return numPainters;
    }

     static int b_search(int arr[],int n,int k){
    
           int lo=getMax(arr,n);
           int hi=getSum(arr,n);

           while(lo<hi){
              int mid=lo+(hi-lo)/2;
              int requiredPainters=numberOfPainters(arr,n,mid);
              if(requiredPainters<=k)
                   hi=mid;
              else
                  lo=mid+1;
    
           }
          return lo;
      
     }

   public static void main(String args[]){ 
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; 
        int n = arr.length; 
        int k = 3; 
        System.out.println(b_search(arr, n, k)); 
   }
}
