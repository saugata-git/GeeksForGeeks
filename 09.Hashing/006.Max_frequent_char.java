/*
Maximum Freqent character in a string 
//Time Complexity : O(n)
*/
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FreqChar{

   static char freqChar(char arr[],int n){
        

     Map<Character,Integer> map=new HashMap<Character,Integer>();
     int count=0;
    
     for(int i=0;i<n;i++){
        if(map.containsKey(arr[i])==false){
           map.put(arr[i],1);
        }
        else
           map.put(arr[i],map.get(arr[i])+1);
     }
     
     int max=Integer.MIN_VALUE;
     char max_char='\0';
     for(Entry<Character,Integer> entry:map.entrySet()){
          
           if(entry.getValue()>max){
              max=entry.getValue();
              max_char=entry.getKey();
           }
     }
      
      
     return max_char;
  }

   public static void main(String args[]){
     String str="aaabaaacccddd";
     char arr[]=str.toCharArray();
     System.out.println(freqChar(arr,arr.length));
    
   }
}
