/*
Length of the longest substring with equal 1s and 0s
An efficient solution is to use hashing.
1) Traverse string and keep track of counts of 1s and 0s as count_1 and count_0 respectively.
2) See if current difference between two counts has appeared before 
(We use hashing to store all differences and first index where a difference appears).
If yes, then substring from previous appearance and current index has same number of 0s and 1s.
Time Complexity: O(n)
*/

import java.util.*;

public class MAX_LEN_0_1{

     public static int maxLen(String str){

      Map<Integer,Integer> map =new HashMap<Integer,Integer>();
       map.put(0,-1);
       int res=0;
       int count_0=0,count_1=0;
       for(int i=0;i<str.length();i++){
              if(str.charAt(i)=='0')
                 count_0++;
              else
                 count_1++;

              if(map.containsKey(count_1-count_0))
                  res=Math.max(res,(i - map.get(count_1-count_0))); 

              else
                  map.put(count_1-count_0,i);                
       }
       return res;
     }
   
     public static void main(String args[]){
  
        String str="101010101";
        System.out.println(maxLen(str));
     } 
}
