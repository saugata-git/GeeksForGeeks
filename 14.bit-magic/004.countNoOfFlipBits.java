//Count number of bits to be flipped to convert A to B

class Count{

    public static int countSetBits(int n){
       int count=0;
       while(n!=0){
          count+=n&1;
          n=n>>1;
       }
       return count;
    }
 
    public static int FlippedCount(int a,int b){
     return countSetBits(a^b);
    }
    
    public static void main(String args[]){
      int a=0;
      int b=15;
      System.out.print(FlippedCount(a,b));
    }
}
