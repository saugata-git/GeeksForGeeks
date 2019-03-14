//For each element in 1st array count elements less than or equal to it in 2nd array
//Time Complexity: O(mlogn + nlogn), considering arr1[] and arr2[] are of sizes m and n respectively.
import java.util.*;
class countEle{


   // method returns the index of largest element  
   // smaller than equal to 'x' in 'arr'. For duplicates 
   // it returns the last index of occurrence of required 
   // element. If no such element exits then it returns -1.  
   static int binary_search(int arr[],int l,int h,int x){
       while(l<=h){
          int mid=(l+h)/2;
          if(arr[mid]<=x){
            l=mid+1;
          }
          else
            h=mid-1;
       }
       return h;
   }    


   static void countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n){
   
       Arrays.sort(arr2);
       for(int i=0;i<m;i++){
         int index=binary_search(arr2,0,n-1,arr1[i]);
         System.out.print((index+1)+" ");
       }
   } 

   public static void main(String[] args) 
    { 
        int arr1[] = {1, 2, 3, 4, 7, 9}; 
        int arr2[] = {0, 1, 2, 1, 1, 4}; 
          
        countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length); 
    } 
}
