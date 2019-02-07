//Time Complexity: O(n Log n)
import java.util.*;
import java.lang.*;
import java.io.*;
class MinHeight{

        public static int minDiff(int[] arr,int n,int k){
          int small=arr[0]+k;
          int big=arr[n-1]-k;
          if(small>big){
            int tmp=big;
            big=small;
            small=tmp;
          }
          int ans=arr[n-1]-arr[0];
          for(int i=1;i<n-1;i++){
               int sub=arr[i]-k;
               int add=arr[i]+k;

             if(sub>=small || add<=big){
                continue;
               }          
             if(big-sub<=add-small){
                small=sub;
             }else{
                big=add;
             }
           }
          return Math.min(ans,big-small);
          
        }

	public static void main (String[] args) {
       	 Scanner scan = new Scanner(System.in);
    	 int t = scan.nextInt();
    	 while (t-- > 0) {
    	     int k = scan.nextInt();
        	 int n = scan.nextInt();
        	 
        	 int[] arr = new int[n];
        	 for (int i = 0; i < n; i++) {
        	     arr[i] = scan.nextInt();
        	 }
        	 Arrays.sort(arr);
        	 System.out.println(minDiff(arr, n, k));
    	  }
	 }
	 
}
