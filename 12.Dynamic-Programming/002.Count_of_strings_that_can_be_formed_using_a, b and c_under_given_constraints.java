//Time Complexity : O(n) Auxiliary Space : O(n)
class dp{
   static int n;
   static int [][][] memo;
   static int countStr(int n,int bc,int cc){

        if(bc < 0 || cc < 0)
            return 0;

        if(n == 0)
            return 1;

        if(bc == 0 && cc == 0)
            return 1;

        if(memo[n][bc][cc] != 0)
            return memo[n][bc][cc];

        return memo[n][bc][cc] = countStr(n-1,bc,cc) + countStr(n-1,bc-1,cc) + countStr(n-1,bc,cc-1);
    }
    /* 
    Time Complexity : O(1)
    Auxiliary Space : O(1)
    static int countStr(int n){
          return 1+(n*2)+(n*((n*n)-1)/2);
    } 
    */
   public static void main (String[] args){ 
      int n = 3; 
      int bcount=1;
      int ccount=2;
      memo = new int [n+1][bcount+1][ccount+1];
      System.out.println( countStr(n,bcount,ccount)); 
   } 
}
