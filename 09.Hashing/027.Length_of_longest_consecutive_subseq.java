import java.io.*;
import java.util.*;

class ArrayElements{

    static int findLongestConseqSubseq(int arr[],int n){
    
       HashSet<Integer> s = new HashSet<Integer>();
       
       for(int i=0;i<n;i++){
          s.add(arr[i]);
       }
       
       for(int i=0;i<n;i++){
       
          if(!s.conatins(arr[i]-1)){
               int j= arr[i];
               while(s.contains(j)){
                j++;
               }
               
               if(ans<j-arr[i]){
                  ans=j-arr[i];
               }
          }
       }
       return ans;
    }

   
    public static void main(String args[]){
   
     int arr[]={1, 9, 3, 10, 4, 20, 2};
     int n=arr.length;
     System.out.println("Length of the longest consecutive subsequence "+ findLongestConSubSeq(arr,n));
   }
}
