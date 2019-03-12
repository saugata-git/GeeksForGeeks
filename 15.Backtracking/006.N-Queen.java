//less than T(n)=O(N!)O(N^2)as we using back-tracking
import java.util.*;
public class NQ{

  
  void printSolution(int board[][],int n){
     
     for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            System.out.print(board[i][j]+" ");
        }
        System.out.println();
     }
  }

  boolean isSafe(int board[][],int row,int col,int n){
 
       int i,j;

       /* Check this row on left side */
       for(i=0;i<col;i++)
            if(board[row][i]==1)
               return false;

       /* Check upper diagonal on left side */
       for(i=row,j=col;i>=0&& j>=0;i--,j--)
            if(board[i][j]==1)
               return false;

       /* Check lower diagonal on left side */
       for(i=row,j=col;i<n &&j>=0;i++,j--)
            if(board[i][j]==1)
              return false;

       return true;
   }

  boolean solveNQUtil(int board[][],int col,int n){

       if(col>=n)
          return true;
   
       for(int i=0;i<n;i++){
            if(isSafe(board,i,col,n)){
               board[i][col]=1;
               if(solveNQUtil(board,col+1,n)==true)
                  return true;
               board[i][col]=0;
            }
       }
       return false;
  }



  boolean solveNQ(int n){
  
     int board[][]=new int[n][n];
     for(int i=0;i<n;i++)
       Arrays.fill(board[i],0);
     
     if(solveNQUtil(board,0,n)==false){
       System.out.print("Solution does not exist"); 
       return false; 
     }
     printSolution(board,n);
     return true;
  }


  public static void main(String args[]){

      NQ ob = new NQ();
      ob.solveNQ(4);
  }
}
