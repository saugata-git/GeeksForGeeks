class changeEvenBits{

   static int changeEvenBits(int n){

     int to_substract=0;
     int m=0;
     for(int x=n;x>0;x>>=2){
        if((x&1)>0){
          to_substract+=(1<<m);
        }
         m+=2;
     }
     return (n-to_substract);
   }
   /*
    0xaaaaaaaa=1010 1010 1010 1010 1010 1010 1010 1010
    */
   static int changeEven_Bits(int n){
    return (n & 0xaaaaaaaa);
   }
    
   public static void main(String args[]){
      int n=15;
      System.out.println(changeEvenBits(n));
      System.out.println(changeEven_Bits(n));
   }
}
