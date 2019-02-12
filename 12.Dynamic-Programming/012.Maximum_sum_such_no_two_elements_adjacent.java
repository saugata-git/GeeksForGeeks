//Maximum sum such that no two elements are adjacent      
//T(n)=O(n)

class MaxSum{

   int FindMaxSum(int arr[],int n){
    
     int incl=arr[0];
     int excl=0;
     int excl_new;
   
     for(int i=0;i<n;i++){
       excl_new=(incl>excl)?incl:excl;
       incl=excl+arr[i];
       excl=excl_new;
     }
     return(incl>excl)?incl:excl;
   }

   public static void main(String[] args){ 
        MaxSum sum = new MaxSum(); 
        int arr[] = new int[]{5, 5, 10, 100, 10, 5}; 
        System.out.println(sum.FindMaxSum(arr, arr.length)); 
    } 

   
}
