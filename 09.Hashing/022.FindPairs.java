/*
Time Complexity : O(nlog(n))
Auxiliary Space : O(n)
An Efficient solution of this problem is to hashing. Hash table is implemented using set. 
We store all first array elements in hash table. For elements of second array, we subtract every element from x and check 
the result in hash table. If result is present, we print the element and key in hash (which is an element of first array).
*/
import java.util.*;


public class FindPairs{
 
    public static void findPairs(int arr1[],int arr2[],int n,int m,int x){

         HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
         for(int i=0;i<n;i++){
            map.put(arr1[i],0);
         }
         for(int j=0;j<m;j++){
            if(map.containsKey(x-arr2[j])){
              System.out.println(x-arr2[j]+" "+arr2[j]);
            }
         }
    }

    public static void main(String args[]){
       int arr1[]={1, 0, -4, 7, 6, 4};
       int arr2[]={0 ,2, 4, -3, 2, 1};
       int x=8;
       findPairs(arr1,arr2,arr1.length,arr2.length,x);
    }
}
