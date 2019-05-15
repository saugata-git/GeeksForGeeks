class copySetBits{

   static void copySetBits(int x,int y,int l,int r){
      
      if(l<1 || r>32)
        return;
      
      for(int i=l;i<=r;i++){
          int mask=1<<(i-1);
          if((y & mask)!=0){
              x=x|mask;
          }
      }

   }

   public static void main(String args[]){
       int x=10,y=13,l=2,r=3;
       copySetBits(x,y,l,r);
       System.out.println("Modified bit is -> "+ x);
   }
}
