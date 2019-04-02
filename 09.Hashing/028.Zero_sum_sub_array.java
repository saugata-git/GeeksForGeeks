import java.util.*;

class ZeroSumSubarray{

  static boolean subArrayExists(int arr[]){
  
     HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
     int sum=0;
     for(int i=0;i<arr.length;i++){
        sum+=arr[i];
         
        if(arr[i]==0||sum==0||hm.get(sum)!=null) 
          return true;
         
        hm.put(sum,i);
     }
     return false;
  }
   
  public static void main(String args[]){
  
     int arr[]={-3, 2, 3, 1, 6};
     if(subArrayExists(arr)){
        System.out.println(" Sub array found ");
     } 
     else{
        System.out.println("No sub array found ");
     }
  }
}
