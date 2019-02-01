import java.util.*; 
import java.io.*;
class Graph { 
	
	  static int M=6;
          static int N=6;
          static void floodFillUtill(char mat[][],int x,int y,char prevV,char newV){
             if(x<0 || x>=M || y<0 ||y>=N)
                return;
             if(mat[x][y]!=prevV)
                return;

              mat[x][y]=newV;
             floodFillUtill(mat,x+1,y,prevV,newV);
             floodFillUtill(mat,x-1,y,prevV,newV);
             floodFillUtill(mat,x,y+1,prevV,newV);
             floodFillUtill(mat,x,y-1,prevV,newV);
          }

          static void replaceSurrounded(char mat[][]){
             
             for(int i=0;i<M;i++)
                for(int j=0;j<N;j++)
                   if(mat[i][j]=='O')
                      mat[i][j]='-';
           
             for(int i=0;i<M;i++)
                if(mat[i][0]=='-')
                   floodFillUtill(mat,i,0,'-','O');
             for(int i=0;i<M;i++)
                if(mat[i][N-1]=='-')
                   floodFillUtill(mat,i,N-1,'-','O');
             
             for(int i=0;i<N;i++)
                if(mat[0][i]=='-')
                   floodFillUtill(mat,0,i,'-','O');
             for(int i=0;i<N;i++)
                if(mat[M-1][i]=='-')
                   floodFillUtill(mat,M-1,i,'-','O');


             for(int i=0;i<M;i++)
                for(int j=0;j<N;j++)
                   if(mat[i][j]=='-')
                      mat[i][j]='X';

          }


          public static void main (String[] args){ 
             char[][] mat = {{'X', 'O', 'X','O', 'X', 'X'}, 
                             {'X', 'O', 'X', 'X', 'O', 'X'}, 
                             {'X', 'X', 'X', 'O', 'X', 'X'}, 
                             {'O', 'X', 'X', 'X', 'X', 'X'}, 
                             {'X', 'X', 'X','O', 'X', 'O'}, 
                             {'O', 'O', 'X', 'O', 'O', 'O'}}; 
               for (int i = 0; i < M; i++){ 
                   for (int j = 0; j < N; j++) 
                         System.out.print(mat[i][j] + " ");       
               System.out.println(""); 
               }
               System.out.println("");
              replaceSurrounded(mat); 
      
               for (int i = 0; i < M; i++){ 
                   for (int j = 0; j < N; j++) 
                         System.out.print(mat[i][j] + " ");       
               System.out.println(""); 
              } 
    } 
} 
