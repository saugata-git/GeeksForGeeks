import java.util.*;
import java.io.*;

class Element{
    int i,j,dis;
    Element(int i,int j,int dis){
     this.i=i;
     this.j=j;
     this.dis=dis;
    }
}
class Knight{
      
     static boolean isPossible(int i,int j,int n,int m){
       if(i>=0 && i<n && j>=0 && j<m)
         return true;
       return false;
     }
    public static void main(String args[]){
     Scanner sc =new Scanner(System.in);
     int t=sc.nextInt();
      while(t-->0){
       int n=sc.nextInt();
       int m=sc.nextInt();
       boolean [][]af= new boolean[n][m];
       int i=sc.nextInt();
       int j=sc.nextInt();
       int x=sc.nextInt();
       int y=sc.nextInt();
       i--;
       j--;
       x--;
       y--;
       int min=Integer.MAX_VALUE;
       Element e= new Element(i,j,0);
       Queue<Element>q=new LinkedList<>();
       q.add(e);
       
       while(!q.isEmpty()){

         Element temp =q.remove();
         if(temp.i==x && temp.j==y){
           min=temp.dis;
           break;
         }
       
        int[] a={2,1,2,1,-2,-1,-1,-2};
        int[] b={1,2,-1,-2,1,2,-2,-1}; 

        for(int d=0;d<8;d++){
           int ii=temp.i+a[d];
           int jj=temp.j+b[d];
           
           if(isPossible(ii,jj,n,m) && af[ii][jj]==false){
              af[ii][jj]=true;
              q.add(new Element(ii,jj,temp.dis+1));
           }
        } 
       }
       
       if(min<Integer.MAX_VALUE){
         System.out.println(min);
       }
       else{
         System.out.println(-1);
       }


      }
    }

}


