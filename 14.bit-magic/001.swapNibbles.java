/*
0xf0 = 1111 0000 = 240
0x0f = 0000 1111 = 15
*/
class swapNibbles{

   static int swapNibbles(int x){  
      //return((x & 15)<<4 |(x & 240)>>4);
      return((x & 0x0f)<<4 |(x & 0xf0)>>4);
   }

   public static void main(String args[]){
      int x=100;
      System.out.println(swapNibbles(x));
   }

}
