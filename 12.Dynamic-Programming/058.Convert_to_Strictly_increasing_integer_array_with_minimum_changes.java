//Convert to an strictly incerasing array
//T(n)=O(n^2)

class dp{

  static int minRemove(int arr[],int n){
      int LIS[]=new int[n];
      int len=0;

      for(int i=0;i<n;i++){
        LIS[i]=1;
      }
      
      for(int i=1;i<n;i++){
         for(int j=0;j<i;j++){
            if(arr[i]>arr[j] && (i-j)<=(arr[i]-arr[j])){
               LIS[i]=Math.max(LIS[i],LIS[j]+1);
            }        
         }
        len=Math.max(len,LIS[i]);
      }
     return n - len;
  }

  public static void main(String args[]){
    int arr[]={1, 2, 6, 5, 4};
    int n=arr.length;
    System.out.println(minRemove(arr, n));
  }
}
