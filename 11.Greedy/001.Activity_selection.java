import java.util.*;
import java.lang.*;
import java.io.*;

class Activity{
   int start;
   int finish;
   Activity(int start,int finish){
    this.start=start;
    this.finish=finish;
   }
}

class SortByFinish implements Comparator<Activity>{
   public int compare(Activity a1,Activity a2){
     return a1.finish-a2.finish;
   }
}


class Driver{
	public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
      int t=sc.nextInt();
      while(t-->0){
      
         int n=sc.nextInt();
         int []s= new int[n];
         int []f= new int[n];
         for(int i=0;i<n;i++){
          s[i]=sc.nextInt();
         }
        
         for(int i=0;i<n;i++){
          f[i]=sc.nextInt();
         }
         
        
         Activity []a= new Activity[n];
         
         for(int i=0;i<n;i++){
          a[i]= new Activity(s[i],f[i]);
         }  
         Arrays.sort(a, new SortByFinish());
        
         int b=0;
         int count=1;
         for(int i=1;i<n;i++){
            if(a[i].start>=a[b].finish){
            count++;
            b=i;
           }
         }     
        System.out.println(count);
        
      }
   }
}
