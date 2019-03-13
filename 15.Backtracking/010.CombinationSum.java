import java.util.*;
class combinationSum{


    private static void helper(int[] arr,int start,int target,int sum,List<Integer>list,List<List<Integer>>result){
 
     if(sum>target){
       return;
     }

     if(sum==target){
       result.add(new ArrayList<>(list));
       return;
     }
    
     for(int i=start;i<arr.length;i++){
       list.add(arr[i]);
       helper(arr,i,target,sum+arr[i],list,result);
       list.remove(list.size()-1);
     }
   
   }

   public static List<List<Integer>> cSum(int []arr,int target){
          List<List<Integer>>result= new ArrayList<>();
          List<Integer>list= new ArrayList<>();
          helper(arr,0,target,0,list,result);
          return result;
   }

   public static void main(String args[]){ 
          int arr[]={2,6,3,7};
          System.out.println(cSum(arr,7));
   }

}
