
//Longest Common Substring 
//Time Complexity: O(m*n)
//Auxiliary Space: O(m*n)

public class LCS{

  int max(int a,int b){
    return(a>b)?a:b;
  }

  int lcs(char []X,char []Y,int m,int n){

     int L[][]=new int[m+1][n+1];
     int result=0;

     for(int i=0;i<=m;i++){
       for(int j=0;j<=n;j++){

         if(i==0||j==0)
            L[i][j]=0;
         else if(X[i-1] == Y[j-1]){
            L[i][j]=L[i-1][j-1]+1;
            result = Integer.max(result,L[i][j]); 
         }
         else
            L[i][j]=0;
       }
     }
   return result;
  }

  public static void main(String args[]){

     LCS ob =new LCS();
     String s1="AGGTAB";
     String s2="GXTXAYB";

     char []X=s1.toCharArray();
     char []Y=s2.toCharArray();
     int m=X.length;
     int n=Y.length;
     System.out.println("Length of LC substring  is" + " " + ob.lcs( X, Y, m, n ) );
  } 

}public class LCS{

  int max(int a,int b){
    return(a>b)?a:b;
  }

  int lcs(char []X,char []Y,int m,int n){

     int L[][]=new int[m+1][n+1];
     int result=0;

     for(int i=0;i<=m;i++){
       for(int j=0;j<=n;j++){

         if(i==0||j==0)
            L[i][j]=0;
         else if(X[i-1] == Y[j-1]){
            L[i][j]=L[i-1][j-1]+1;
            result = Integer.max(result,L[i][j]); 
         }
         else
            L[i][j]=0;
       }
     }
   return result;
  }

  public static void main(String args[]){

     LCS ob =new LCS();
     String s1="AGGTAB";
     String s2="GXTXAYB";

     char []X=s1.toCharArray();
     char []Y=s2.toCharArray();
     int m=X.length;
     int n=Y.length;
     System.out.println("Length of LC substring  is" + " " + ob.lcs( X, Y, m, n ) );
  } 

}
