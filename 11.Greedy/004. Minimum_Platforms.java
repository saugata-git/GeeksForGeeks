//Time Complexity: O(nLogn), assuming that a O(nLogn) sorting algorithm for sorting arr[] and dep[].


import java.util.*;
import java.lang.*;
import java.io.*;

class MinPlat{

          public static int  findPlatform(int start[],int end[],int n){
             Arrays.sort(start);
             Arrays.sort(end);
             int pneed=0,result=1;
             int i=1,j=0;
             while(i<n && j<n){
                if(start[i]<=end[j]){
                   pneed++;
                   i++;
                   if(result<pneed){
                     result=pneed;
                   }
                }
                else{
                      j++;
                      pneed--;
                } 
             }
            return result;
         }
         public static void main (String[] args) {
	      Scanner sc=new Scanner(System.in);
	      int t=sc.nextInt();		 
	      while(t-- > 0){
		    int n=sc.nextInt();
		    int []start=new int[n];
		    int []end=new int[n];
		    
		    for(int i=0;i<n;i++){
		        start[i]=sc.nextInt();
		    }
		    
		    for(int i=0;i<n;i++){
		        end[i]=sc.nextInt();
		    }
		    System.out.println(findPlatform(start,end,n));
       }
	}

}
