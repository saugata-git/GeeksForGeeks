/*
Union and Intersection of two sorted arrays
Time Complexity : O(m + n)
*/
class FindUnionIntersection{


     static void printUnion(int arr1[],int arr2[]){
   
       int m=arr1[arr1.length-1];
       int n=arr2[arr2.length-1];
       int ans=0;
       if(m>n){
         ans=m;
       }
       else
         ans=n;

       int hashtable[] =new int[ans+1];
       System.out.println(arr1[0]+ " ");
       
       ++hashtable[arr1[0]];

       for(int i=1;i<arr1.length;i++){
         if(arr1[i]!=arr1[i-1]){
            System.out.print(arr1[i]+" ");
            ++hashtable[arr1[i]];
         }
       }
      
       for(int j=0;j<arr2.length;j++){
          if(hastable[arr2[j]]==0){
            System.out.println(arr2[j]+ " ");
            ++hashtable[arr2[j]];
          }
       }
        

     }

     static void printIntersection(int arr1[],int arr2[]){
       int m = arr1.length; 
       int n = arr2.length;
       int i=0,j=0;

       while(i<m && j<n){

         if(arr1[i]<arr2[j]){
           i++;
         }

         else if(arr[j]<arr[i]){
           j++;
         }

         else{
           System.out.print(arr2[j++]+" ");
           i++;
         }
      }
 
    }

    public static void main(String args[]){ 
        int arr1[] = {1, 2, 2, 2, 3}; 
        int arr2[] = {2, 3, 4, 5}; 
       
        printIntersection(arr1, arr2, m, n); 
    } 

}
