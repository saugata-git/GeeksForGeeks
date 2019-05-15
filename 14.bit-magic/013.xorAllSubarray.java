class xorAllSubarray{


   static int function1(int arr[]){
      int res=0;
      int n=arr.length;
      for(int i=0;i<n;i++){
         for(int j=i;j<n;j++){
            for(int k=i;k<=j;k++){
             res^=arr[k];
            }
         }
      }
      return res;
   }

   static int function2(int arr[]){
       
        int res=0;
        int n=arr.length;
        for(int i=0;i<n;i++){

          int freq=(i+1)*(n-1); 
          if((freq%2)==1){
          res=res^arr[i];
          }
        }
   }

   static int function3(int arr[]){
      int n=arr.length;
      if(n%2==0){
       return 0; 
      }
      int res=0;
      for(int i=0;i<n;i+=2){
          res^=arr[i];
      }
    return res;
   }

   public static void main(String args[]){
      int arr[]={3, 5, 2, 4, 6};
      System.out.println(function1(arr));
      System.out.println(function2(arr));
      System.out.println(function3(arr));
   }

}
