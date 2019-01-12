//Total number of possible Binary Search Trees and Binary Trees with n keys

import java.io.*;
class BST{

   static int factorial(int n){
    int res=1;
     for(int i=1;i<=n;++i){
      res*=i;
    }
    return res;
   }
   static int binomialCoeff(int n,int k){
     int res =1;
     // Since C(n, k) = C(n, n-k) 
     if(k>n-k)
         k=n-k;

     for(int i=0;i<k;i++){
    // [n*(n-1)*---*(n-k+1)] /  
    // [k*(k-1)*---*1] 
      res*=(n-i);
      res/=(i+1);
     }
     return res;
   }
  
// A Binomial coefficient based function to find  
// nth catalan number in O(n) time 
//C_n=C(n,k)/(n+1) ;


   static int catalan(int n){
    int c=binomialCoeff(2*n,n);
    return c/(n+1);
   }

static int countBST(int n){
      int count=catalan(n);
      return count;
}

static int countBT(int n){
      
    int count=catalan(n);
    return count*factorial(n);

}


   public static void main (String[] args) 
    { 
    int count1, count2, n = 5; 
  
    // find count of BST and  
    // binary trees with n nodes 
    count1 = countBST(n); 
    count2 = countBT(n);  
  
    // print count of BST and  
    // binary trees with n nodes 
    System.out.println("Count of BST with "+  
                            n +" nodes is "+  
                                    count1); 
    System.out.println("Count of binary " +  
                             "trees with "+  
                         n + " nodes is " +  
                                   count2); 
   } 
}
