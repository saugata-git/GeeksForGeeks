//Find position of the only set bit

class setBit{
 
  static boolean isPowerOfTwo(int n){    
     return(n>0 && ((n&(n-1))==0));
  } 
   
  static int findPosition(int n){

     if(!isPowerOfTwo(n))
       return -1;

     int pos=1;
     while((n & 1)==0){
        n=n>>1;
        pos++;
     }
    return pos;
  }
 
  public static void main(String args[]){
     int n=128;
     int pos=findPosition(n);
     if(pos==-1){
       System.out.println("Not found");
     }
     else
       System.out.println("Bit found at position : "+ n);
  }   
}
