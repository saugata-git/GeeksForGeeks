class getNonRepeating{

   static int x=0,y=0;
   static void get2NonRepeatingNos(int arr[]){

       int n=arr.length;
       int xor=arr[0];
       int set_bit_no;
       int i;
       for(i=1;i<n;i++){
         xor^=arr[i];
       }
       set_bit_no =(xor & (~(xor-1)));// Get a number which has only one set bit of the xor. 

       for(i=0;i<n;i++){
           if((arr[i] & set_bit_no)==0){
               x=x^arr[i];
           }
           else{
               y=y^arr[i];
           }
       }
   }
   
   public static void main(String args[]){
   
     int arr[]={2, 3, 7, 9, 11, 2, 3, 11};
     get2NonRepeatingNos(arr);
     System.out.println("Two non repeating elements are ->"+x+ " "+y);
   }
}
