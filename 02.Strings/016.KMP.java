/*
KMP Algorithm for Pattern Searching
T(n)=O(m+n)

*/

class KMP{

   public static void KMPSearch(String pat,String txt){

      int M=pat.length();
      int N=txt.length();
      
      // create lps[] that will hold the longest prefix suffix values for pattern
      int lps[]= new int[M];
      
      // index for pat[] 
      int j=0;
      
      // Preprocess the pattern (calculate lps[] array) 
      computeLPSArray(pat,M,lps);
      
      // index for txt[] 
      int i=0;
      while(i<N){
          if(pat.charAt(j)==txt.charAt(i)){
             j++;
             i++;
          }
          if(j==M){
            System.out.println("Pattarn found at index "+(i-j));
            j=lps[j-1];
          } 
          
          // mismatch after j matches 
          else if(i<N && pat.charAt(j)!=txt.charAt(i)){
            if(j!=0)
               j=lps[j-1];
            else
               i++;
          }
      }

   }

   public static void computeLPSArray(String pat,int M ,int lps[]){
   
    // length of the previous longest prefix suffix 
    int len=0;
    int i=1;
    
    // lps[0] is always 0
    lps[0]=0;
    
     // the loop calculates lps[i] for i = 1 to M-1
    	while(i<M){
          if(pat.charAt(i)==pat.charAt(len)){
            len++;
            lps[i]=len;
            i++;
          }
          else{                      // (pat[i] != pat[len]) 
                 // This is tricky. Consider the example. AAACAAAA and i = 7. The idea is similar to search step.
                 // Also, note that we do not increment i here 
                 if(len!=0){
                     len=lps[len-1];
                     
                 }
                 else{    // if (len == 0)
                  lps[i]=len;
                  i++;
                 }
          }
       }
   }

   public static void main(String args[]){
      String txt="ABABDABACDABABCABAB";
      String pat="ABABCABAB";
      KMPSearch(pat,txt);
   }
}
