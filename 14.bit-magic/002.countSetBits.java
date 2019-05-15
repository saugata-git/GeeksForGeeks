class countSet{

  static int countSetBits(int n){
     int count=0;
     while(n>0){
       count+=(n & 1);
       n=n>>1;
     }
     return count;
  }
   //recursive
    static int countSetBitsUtil( int n){ 
      if(n<=0){
      return 0;
      }
      return (((n%2==0)?0:1)+countSetBitsUtil(n/2));
    } 

  

  public static void main(String args[]){
     int n=15;
     System.out.println(countSetBits(n));
     System.out.println(countSetBitsUtil(n));
  }
}
