class kthset{

   static void isKthBitSet(int n,int k){
      
       if(((n>>(k-1))&1)>=1)
          System.out.println("SET");
       else
          System.out.println("NO SET");
   }

   public static void main(String args[]){
     int n=5,k=1;
     isKthBitSet(n,k);
   }
}
