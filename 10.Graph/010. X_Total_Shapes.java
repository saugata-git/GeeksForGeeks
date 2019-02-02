import java.util.*;
import java.lang.*;
import java.io.*;

class Graph{

       public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int tc =s.nextInt();
        for(int i=0;i<tc;i++){
           int n=s.nextInt();
           int m=s.nextInt();
           String[][]ma= new String[n][m];

           for(int j=0;j<n;j++){
             String[] r=s.next().split("");
             for(int k=0;k<m;k++){
               ma[j][k]=r[k];
             }
           }
         System.out.println(f(n,m,ma));

        }
       }

       public static int f(int n,int m,String[][] ma){
         boolean[][] v =new boolean[n][m];
         int sha=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
             String c =ma[i][j];
             if(!v[i][j] && "X".equals(c)){
                dfs(i,j,ma,v);
                sha++;
             }
           }
         }
        return sha;
       }

       puublic static void dfs(int i,int j, String[][]m, boolean[][]v ){
            if(i<0 ||j<0){
             return;
            }
            if(i>m.length-1||j>m[0].length-1){
                return;
            }
            if(v[i][j]){
                return;
            }
            String c=m[i][j];
            v[i][j]=true;
            if("X".equals(c)){
                 dfs(i+1,j,m,v);
                 dfs(i-1,j,m,v);
                 dfs(i,j+1,m,v);
                 dfs(i,j-1,m,v);
            }
            return;
       }

}
