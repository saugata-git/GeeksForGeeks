import java.util.*;
import java.lang.*;
import java.io.*;

class Graph{
   
    public static void main(String[] args){
      Scanner sc =new Scanner(System.in);
      int t= sc.nextInt();
      while(t-->0){
        int n=sc.nextInt();
        int [][]arr=new int[n][n];
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
            arr[i][j]=sc.nextInt();
           }
        }
      
      System.out.println(f(arr,0));
      }
    }
   
    private static int f(int [][]arr,int row){
     if(row>=arr.length)
      return 0;
     int sum=Integer.MAX_VALUE;
     for(int i=0;i<arr.length;i++){  
      sum=Math.min(sum,arr[row][i]);
     }
     sum+=f(arr,row+1);
     return sum;
    }
}
