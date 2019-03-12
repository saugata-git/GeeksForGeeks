/*Time Complexity: Since number of Gaps are n-1, there are total 2^(n-1) patters 
each having length ranging from n to 2n-1. Thus overall complexity would be O(n*(2^n))
*/

import java.util.*;

public class ps{

   static void printSubseq(String s){
     char []str=s.toCharArray();
     int n=str.length;
     int opsize=(int)(Math.pow(2,n-1));
  
     for(int i=0;i<opsize;i++){
        for(int j=0;j<n;j++){
           System.out.print(str[j]);
           if((i &(1<<j))>0)
              System.out.print(" ");
        }
     System.out.println();
     }

   }

   public static void main(String args[]){
     String str="ABC";
     printSubseq(str);
   }
}
