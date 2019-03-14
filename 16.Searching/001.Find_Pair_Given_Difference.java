//Find Pair Given Difference

import java.util.*;

class fp{

   static boolean findPair(int arr[],int n){
       int size=arr.length;
       int i=0,j=1;
       // search for pair
       while(i<size && j<size){
           if(i!=j && arr[j]-arr[i]==n){
              System.out.println("Pair Found: "+arr[i]+"<-->"+arr[j]);
              return true;
           }
           else if(arr[j]-arr[i]<n)
               j++;
           else
               i++;
       }
      System.out.println("No such pair");
      return false;
   }

   public static void main(String args[]){

        int arr[] = {1, 8, 30, 40, 100}; 
        int n = 60; 
        findPair(arr,n);
   }
}
