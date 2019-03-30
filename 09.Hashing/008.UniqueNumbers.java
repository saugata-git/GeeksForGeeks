import java.util.*;
class UniqueNumbers{

   static void printUnique(int l,int r){
     for(int i=l;i<=r;i++){
        int num=i;
        boolean visited[]=new boolean[10];
        while(num!=0){
            if(visited[num%10])
               break;
            visited[num%10]=true;
            num=num/10;
        }
        if(num==0)
          System.out.print(i+" ");
     }
   }

   public static void main(String args[]){
     int l=1,r=20;
     printUnique(l,r);
   }
}
