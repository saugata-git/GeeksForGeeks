/*
Efficient Approach: Use hashing. Use a hash table of size 26 for all the lowercase characters.
Initially, mark presence of each character as ‘0’ (denoting that the character is not present in both the strings). 
Traverse the 1st string and mark presence of each character of 1st string as ‘1’ (denoting 1st string) in the hash table. 
Now, traverse the 2nd string. For each character of 2nd string, check whether its presence in the hash table is ‘1’ or not.
If it is ‘1’, then mark its presence as ‘-1’ (denoting that the character is common to both the strings), else mark 
its presence as ‘2’ (denoting 2nd string).
Time Complexity: O(m + n), where m and n are the sizes of the two strings respectively.
*/
import java.util.*;

class FindUncommon{
     
     static int MAX_char=26;
     static void findUncommon(String str1,String str2){

       int present[]= new int[MAX_CHAR];
       for(int i=0;i<MAX_CHAR;i++){
         present[i]=0;
       }
       int l1=str1.length();
       int l2=str2.length();
   
       for(int i=0;i<l1;i++){
         present[str1.charAt(i)-'a']=1;
       }
     
       for(int i=0;i<l2;i++){
         if(present[str2.charAt(i)-'a']==1 || present[str2.charAt(i)-'a']=-1){
            present[str2.charAt(i)-'a']=-1;
         }
         else{
            present[str2.charAt(i)-'a']=2;
         }
       }
      
       for(int i=0;i<MAX_CHAR;i++){
         if(present[i]==1 || present[i]==2){
            System.out.println((char)(i+'a')+ " ");
         }
       }
     
     }
     public static void main(String args[]){
        String str1="characters";
        String str2="alphabets";
        findUncommon(str1,str2);
     }

}
