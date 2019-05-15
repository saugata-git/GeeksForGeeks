// binary representaion of a number

class  binaryRep{

    //recursive using falling stack
    static void binRec(int n){
     if(n>1){
        binRec(n/2);
     }
     System.out.print(n%2);
    }

    //recursive bitwise using falling stack
    static void binBitRec(int n){
         if(n>1){
            binBitRec(n>>1);
         }
         System.out.print(n&1);      
    }

   public static void main(String args[]){
       binRec(7);
       System.out.println();
       binBitRec(8);
   }

}
