//Find length of the largest region in Boolean Matrix
import java.util.*;
import java.io.*;

class Graph{
    
     static int count=0;
     public static void main(String args[]){
      Scanner sc =new Scanner(System.in);
      int t=sc.nextInt();
      while(t-->0){
        int max=0;
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              arr[i][j]=sc.nextInt();
            }
        }
       for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              count=0;
              if(arr[i][j]==1){
               dfs(arr,i,j,m,n);
               if(count>max){
                max=count;
               }
              }
          }
       }
       System.out.println(max);
      }
     }
       
    static void dfs(int arr[][],int i,int j,int m,int n){
       if(i>=m||i<0||j>=n||j<0)
       return;
       if(arr[i][j]==1){
         arr[i][j]=0;
         count++;
         dfs(arr,i,j+1,m,n);
         dfs(arr,i,j-1,m,n);
         dfs(arr,i+1,j,m,n);
         dfs(arr,i-1,j,m,n);
         dfs(arr,i+1,j+1,m,n);
         dfs(arr,i+1,j-1,m,n);
         dfs(arr,i-1,j+1,m,n);
         dfs(arr,i-1,j+1,m,n);
       }
       else
         return;
    }

}
