class swapBits{

    public  static int swapBits(int n ,int i,int j){
    
          int a=(n>>i) & 1;
          int b=(n>>j) & 1;

          if((a^b)!=0){ 
            return  n^=(1<<i)|(1<<j);
          } 
      return n;
    }
   
    public static void main(String args[]){
       int n=8;
       System.out.println(swapBits(n,0,3));

    } 
}
