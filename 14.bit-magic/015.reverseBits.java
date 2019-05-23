class reverseBits{
   /*
   Best solution
   public long reverse(long a) {
      long rev=0;
      for(int i=0;i<32;i++){
        rev<<=1;
        if((a & (1<<i))!=0){ 
           rev|=1;
        }  
    }
    return rev;    
  }
  public static long reverse(long a) {
        long result = 0;
        int i=31;
        while(a>0){
            result+=(a%2)*Math.pow(2,i);
            i--;
            a=a/2;
        }
        return result;
 }	
 */
	
	 
    /*O(n) solution  return signed bit
    public static int reverseBits(int n) {
	for (int i = 0; i < 16; i++) {
		n = swapBits(n, i, 32 - i - 1);
	}
 
	return n;
    }
 
    public static int swapBits(int n, int i, int j) {
	int a = (n >> i) & 1;
	int b = (n >> j) & 1;
 
	if ((a ^ b) != 0) {
		return n ^= (1 << i) | (1 << j);
	}
	return n; 
     }
   */
   //O(log(n)) solution
    public static int sizeof(int n){
        
       int size=0;
       while(n!=0){
          n=n<<1;
         size++;
       }
       return size;
    }
   
   public static int reverseBits(int n) {

       int count = (sizeof(n)*8)-1;
       int reverse_num=n;
       
       n>>=1;
       while(n!=0){
          reverse_num<<=1;
          reverse_num |= n & 1;
          n>>=1;
          count--;
       }
      reverse_num<<=count;
     
     return reverse_num;
   }
 
    public static void main(String args[]){
        int x=1;
        System.out.println(reverseBits(x)); 
    }
}
