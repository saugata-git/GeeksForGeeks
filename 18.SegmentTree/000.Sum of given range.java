/*
//Representation of Segment trees
1. Leaf Nodes are the elements of the input array.
2. Each internal node represents minimum of all leaves under it.

An array representation of tree is used to represent Segment Trees.
For each node at index i, the left child is at index 2*i+1, right child at 2*i+2 and the parent is at (i-1)/2


How does above segment tree look in memory?
Like Heap, segment tree is also represented as array. 
The difference here is, it is not a complete binary tree.
It is rather a full binary tree (every node has 0 or 2 children) and
all levels are filled except possibly the last level. 
Unlike Heap, the last level may have gaps between nodes. Below are values in segment tree array for the above diagram.

Below is memory representation of segment tree for input array {1, 3, 5, 7, 9, 11}
st[] = {36, 9, 27, 4, 5, 16, 11, 1, 3, DUMMY, DUMMY, 7, 9, DUMMY, DUMMY}

The dummy values are never accessed and have no use. 
This is some wastage of space due to simple array representation. 
We may optimize this wastage using some clever implementations, but code for sum and update becomes more complex.

Construction of Segment Tree from given array
We start with a segment arr[0 . . . n-1]. and every time we divide the current segment into two halves
(if it has not yet become a segment of length 1), and then call the same procedure on both halves,
and for each such segment, we store the sum in the corresponding node.
All levels of the constructed segment tree will be completely filled except the last level. 
Also, the tree will be a Full Binary Tree because we always divide segments in two halves at every level.
Since the constructed tree is always a full binary tree with n leaves, there will be n-1 internal nodes.
So total number of nodes will be 2*n – 1. Note that this does not include dummy nodes.

What is total size of array representing segment tree?
If n is a power of 2, then there are no dummy nodes. So size of segment tree is 2n-1 (n leaf nodes and n-1) internal nodes.
If n is not a power of 2, then size of tree will be 2*x – 1 where x is smallest power of 2 greater than n. 
For example, when n = 10, then size of array representing segment tree is 2*16-1 = 31.
An alternate explanation for size is based on heignt. Height of the segment tree will be log2(n). 
Since the tree is represented using array and relation between parent and child indexes must be maintained,
size of memory allocated for segment tree will be 2*2^(log2(n))-1.

Time Complexity:
Time Complexity for tree construction is O(n). 
There are total 2n-1 nodes, and value of every node is calculated only once in tree construction.
Time complexity to query is O(Logn). 
To query a sum, we process at most four nodes at every level and number of levels is O(Logn).
The time complexity of update is also O(Logn). 
To update a leaf value, we process one node at every level and number of levels is O(Logn).
*/


import java.util.*;

class SegmentTree{

   int st[];

   SegmentTree(int arr[],int n){
         int x= (int)(Math.ceil(Math.log(n)/Math.log(2)));
         int max_size=2 * (int)Math.pow(2,x) -1;
         st=new int[max_size];
         constructSTUtil(arr,0,n-1,0);
   }
 
   int getMid(int s,int e){
       return s+(e-s)/2;  
   }
   
    int constructSTUtil(int arr[],int ss,int se,int si){
     
     if(ss == se){
        st[si]=arr[ss];
        return arr[ss];
     }     

     int mid=getMid(ss,se);
     st[si]=constructSTUtil(arr,ss,mid,si*2+1)+constructSTUtil(arr,mid+1,se,si*2+2);
     return st[si];
    
   }

   int getSumUtil(int ss,int se,int qs,int qe,int si){
 
        if(qs<=ss && qe>=se)
            return st[si];

        if(qs>se || qe<ss)
            return 0;
        int mid=getMid(ss,se);
        return getSumUtil(ss,mid,qs,qe,2*si+1)+ getSumUtil(mid+1,se,qs,qe,2*si+2);   
   }

   void updateValueUtil(int ss,int se,int i,int diff,int si){
     if(i<ss || i>se){
         return;
     }
     st[si]=st[si]+diff;
     if(se!= ss){
          int mid=getMid(ss,se);
          updateValueUtil(ss,mid,i,diff,2*si+1);
          updateValueUtil(mid+1,se,i,diff,2*si+2);
     }
   }


   void updateValue(int arr[],int n,int i,int new_val){
    
     if(i<0 || i>n-1){
          System.out.println("Invalid Input");
          return;
     }

     int diff =new_val-arr[i];
     arr[i]=new_val;
     updateValueUtil(0,n-1,i,diff,0);
   }
    

   int getSum(int n,int qs,int qe){
       
       if(qs< 0 || qe >n-1 || qs>qe){
          System.out.println("Invalid Input");
          return -1;
       }
       return getSumUtil(0,n-1,qs,qe,0);
   }


   public static void main(String args[]){
     
      int arr[]={1,3,5,7,9,11};
      int n=arr.length;
      SegmentTree tree =new SegmentTree(arr,n);

      System.out.println(tree.getSum(n,1,3));

      tree.updateValue(arr,n,1,10);

      System.out.println(tree.getSum(n,1,3));
   }
}
