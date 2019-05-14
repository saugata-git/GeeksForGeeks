/*
Time Complexity:
Time Complexity for tree construction is O(n). 
There are total 2n-1 nodes, and value of every node is calculated only once in tree construction.
Time complexity to query is O(Logn).
To query a range minimum, we process at most two nodes at every level and number of levels is O(Logn).
*/
import java.util.*;

class SegmentTreeRMQ{


    int st[];
    void constructST(int arr[],int n){ 

      int height=(int)(Math.ceil(Math.log(n)/Math.log(2)));
      int max_size=2*(int)Math.pow(2,height)-1;
      st=new int[max_size];
      constructSTUtil(arr,0,n-1,0);

    }
 
    int getmid(int si,int ei){
       return si+(ei-si)/2;
    }
    
    int constructSTUtil(int arr[],int ss,int se,int si){
    
     if(ss==se){
        st[si]=arr[ss];
        return arr[ss];
     }
     int mid=getmid(ss,se);
     st[si]=constructSTUtil(arr,ss,mid,2*si+1)+ constructSTUtil(arr,mid+1,se,2*si+2);
     return st[si];
    }
    
    int getmin(int x,int y){
     return (x<y)?x:y;
    }

    int RMQUtil(int ss,int se,int qs,int qe,int si){
       
      if(qs<=ss && qe>=se)
         return st[si];

      if(qs>se || qe<ss)
       return Integer.MAX_VALUE;

      int mid=getmid(ss,se);
      return getmin(RMQUtil(ss,mid,qs,qe,2*si+1),RMQUtil(mid+1,se,qs,qe,2*si+2));
   
    }

    int RMQ(int n,int qs,int qe){

        if(qs<0 || qe>n-1 || qs>qe){
            System.out.println("Invalid Input");
            return -1;
        }
       return RMQUtil(0,n-1,qs,qe,0);
    }


    public static void main(String args[])  
    { 
        int arr[] = {1, 3, 2, 7, 9, 11}; 
        int n = arr.length; 
        SegmentTreeRMQ tree = new SegmentTreeRMQ(); 
        tree.constructST(arr, n); 
        int qs = 1;  
        int qe = 5; 
        System.out.println("Minimum of values in range [" + qs + ", " + qe + "] is = " + tree.RMQ(n, qs, qe)); 
    } 
}
  
