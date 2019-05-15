class OddOccurance{

   static int getOddOccurance(int arr[]){
     int res=0;
     for(int i=0;i<arr.length;i++){
      res=res^arr[i];
     }
     return res;
   }

   public static void main(String args[]){
      int arr[]={2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
      System.out.println(getOddOccurance(arr));
   }
}
