/*
Minimum number of distinct elements after removing m items
//Time Complexity : O(n)
*/
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DistinctIds{

   static int distinctIds(int arr[],int n,int m){
          /*   int[] freq = new int[n+1];
	     for(int i = 0;i<n;i++)
	     {
	         freq[arr[i]]++;
	     }
	     for(int i = 0;i<freq.length;i++)
	     {
	         if(freq[i]>m)
	         freq[i]-=m;
	         else
	         {   m -=freq[i];
	             freq[i] = 0;
	         }
	     }
            
             
              
	     int count = 0;
	     for(int i = 0;i<freq.length;i++)
	     {
	         if(freq[i]>0)
	         count++;
	     }
	     return count;*/

    TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
     int count=0;
     int size=0;
     //creating the sorted hash table
     for(int i=0;i<n;i++){
        if(map.containsKey(arr[i])==false){
           map.put(arr[i],1);
           size++;
        }
        else
           map.put(arr[i],map.get(arr[i])+1);
     }
     
    
     for(Entry<Integer,Integer> entry:map.entrySet()){
          
           if(entry.getValue()>m){
               map.put(entry.getKey(),entry.getValue()-m);
           }
           else{
               m-=entry.getValue();
               map.put(entry.getKey(),0);
               
          }
         
     }
      
      for(Entry<Integer,Integer> entry:map.entrySet()){
          if(entry.getValue()!=0){
            count++;
          }
      }
     return count;
  }

   public static void main(String args[]){
     int arr[]={2, 4, 1, 5, 3, 5, 3};
     int m=2;
     System.out.println(
     distinctIds(arr,arr.length,m));
    
   }
}
