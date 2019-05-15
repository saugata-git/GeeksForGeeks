class allSet{

  static String areAllSetBits(int n){
        if(n==0){
         return  "No";
        }
        while(n>0){
           if((n&1)==0){
             return "No";
           }
           n=n>>1;
        }
      return "Yes";
  }

  public static void main(String args[]){
   int n=15;
   System.out.println(areAllSetBits(n));
  }
}
