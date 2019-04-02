import java.util.*; 

public class RelativeSorting{

   public static void sortAccording(int A1[],int A2[],int m,int n){
        
      HashMap<Integer,Integer> hm =new 	HashMap<Integer,Integer>();
      List<Integer > list =new ArrayList<>();
      List<Integer > list1 =new ArrayList<>();

      for(int i=0;i<m;i++){
          if(!hm.containsKey(A1[i])){
              hm.put(A1[i],1);
          }
          else{
            int count= hm.get(A1[i]);
            hm.put(A1[i],count+1);
          }
      }
      for(int i=0;i<n;i++){
          if(hm.containsKey(A2[i])){
             int count1= hm.get(A2[i]);
             while(count1-->0){
                 list.add(A2[i]);
             }
             int x =hm.remove(A2[i]);
          }
      }
     for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
          int val=entry.getKey();
          list1.add(val);
         
     }
     Collections.sort(list1);
     list.addAll(list1);
     System.out.println(list);
    
   }

   public static void main(String args[]){ 
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}; 
        int A2[] = {2, 1, 8, 3}; 
        int m = A1.length; 
        int n = A2.length; 
        System.out.println("Sorted array is "); 
        sortAccording(A1, A2, m, n); 
        
    } 
}
