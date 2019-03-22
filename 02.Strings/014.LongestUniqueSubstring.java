/*
Time Complexity: O(n + d) where n is length of the input string and d is number of characters in input string alphabet.
For example, if string consists of lowercase English characters then value of d is 26.
Auxiliary Space: O(d)
*/

public class LongestUniqueSubstring{

  static final int NO_OF_CHARS=256;
  static int longestUniqueSubstr(String str){

     int n=str.length();
     int cur_len=1;
     int max_len=1;
     int prev_index;
     int visited[]= new int[NO_OF_CHARS];

     for(int i=0;i<NO_OF_CHARS;i++){
       visited[i]=-1;
     }
     visited[str.charAt(0)]=0;
     for(int i=1;i<n;i++){
        prev_index=visited[str.charAt(i)];
        if(prev_index==-1 ||i-cur_len>prev_index){
        cur_len++;
        }
        else{
            if(cur_len>max_len){
             max_len=cur_len;
             }
            cur_len=i-prev_index;
        }
       visited[str.charAt(i)]=i;
     }

     if(cur_len > max_len){ 
        max_len = cur_len; 
     }  
        return max_len; 
  }


  public static void main(String args[]){
    String str="ABDEFGABEF";
    int len=longestUniqueSubstr(str);
    System.out.println("Length of LongestUniqueSubstring is "+ len);
  }
}
