import java.util.*;
import java.lang.*;
import java.io.*;

class FloodFill{
     static int prev,z;
     public static void main(String args[]){
          Scanner sc =new Scanner(System.in);
          int t =sc.nextInt();
          while(t-->0){
             int n=sc.nextInt();
             int m=sc.nextInt();
             int ar[][]= new int[n][m];

              for(int i=0;i<n;i++){
                 for(int j=0;j<n;j++){
                    ar[i][j]=sc.nextInt();
                 }
              }

            boolean visited[][]= new boolean[n][m];
            int x=sc.nextInt(),y=sc.nextInt();
            z=sc.nextInt();
            prev=ar[x][y];
            floodfill(ar,visited,x,y);
            
             for(int i=0;i<n;i++){
                 for(int j=0;j<m;j++){
                   System.out.println(ar[i][j]+" ");
                 }
               System.out.println();
             }
          }
     }
     static void floodfill(int ar[][],boolean visited[][],int row,int col){
        if(row<0 || row>=arlength ||col<0||col>ar.length)
          return;
        if(visited[row][col])
         return;
        if(ar[row][col]==prev){
          visited[row][col]=true;
          ar[row][col]=z;
          floodfill(ar,visited,row+1,col);
          floodfill(ar,visited,row-1,col);
          floodfill(ar,visited,row,col-1);
          floodfill(ar,visited,row,col+1);
        }
        else
          return;

     }   
   
}
