/*
Time complexity of the above solution is O(n).
Count distinct elements in every window
*/
import java.util.HashMap;
class CountDistinctWindow{


    static void countDistinct(int arr[],int k){
       HashMap<Integer,Integer> hm =new HashMap<Integer,Integer>();
       int dist_count=0;

       for(int i=0;i<k;i++){
          if(hm.get(arr[i])==null){
             hm.put(arr[i],1);
             dist_count++;
          }
          else{
             int count=hm.get(arr[i]);
             hm.put(arr[i],count+1);
          }
       }

       System.out.println(dist_count);
  
       for(int i=k;i<arr.length;i++){
       
           if(hm.get(arr[i-k])==1){
              hm.remove(arr[i-k]);
              dist_count--;
           }
           else{
              int count=hm.get(arr[i-k]);
              hm.put(arr[i-k],count-1);
           }
  
           if(hm.get(arr[i])==null){
              hm.put(arr[i],1);
              dist_count++;
           }
           else{
               int count=hm.get(arr[i]);
               hm.put(arr[i],count+1);
           }
         System.out.println(dist_count);
          
       }
    }

    public static void main(String arg[]){ 
        int arr[] =  {1, 2, 1, 3, 4, 2, 3}; 
        int k = 4; 
        countDistinct(arr, k); 
    } 

}
