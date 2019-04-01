/*
Key Pair
*/
import java.util.*;

class CheckPairSum{
  
   static boolean checkPair(int arr[],int n,int x){

      int sum=x;
     
      HashSet<Integer> s= new HashSet<Integer>();

      for(int i=0;i<n;i++){

         int val=sum-arr[i];

         if(s.contains(val)){
            System.out.println("Pair elements are " +val+" "+arr[i]);
            return true;
         }

         s.add(arr[i]);
      }
      return false;
   }
 
   public static void main(String args[]){
     int arr[]={1 ,4, 45, 6 ,10, 8};
     int n=arr.length;
     int x=16;
       if(checkPair(arr,n,x)==false){
         System.out.println("No pair found");
       }
   }
}
