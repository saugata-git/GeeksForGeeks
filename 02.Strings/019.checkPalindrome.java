 public int isPalindrome(String A){

   int n=A.length();
   if(n==0){
      return 1; 
   }
   return isPalRec(A,0,n-1);
 }
 
 public static int isPalRec(String A,int s,int e){
 
    if(s==e){
       return 1;
    }
    if(A.charAt(s)!=A.charAt(e)){
      return 0;
    }
    if(s<e+1){
       return idPalRec(A,s+1,e-1);
    }
   return 1;
 }
