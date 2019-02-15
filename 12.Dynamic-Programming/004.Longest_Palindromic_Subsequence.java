//Longest Palindromic subsequence
//T(n)=O(m*n)
class dp{
 
    static int max(int x,int y){
     return (x>y)?x:y;
    }

    static int lps(String seq){
    int n =seq.length();
    int i,j,cl;
    int L[][]=new int[n][n];
    for(i=0;i<n;i++)
       L[i][i]=1;
    
     
   for(cl=2;cl<=n;cl++){
         for(i=0;i<n-cl+1;i++){
            j=i+cl-1;
           // If there are only 2 characters and both are same
           if(seq.charAt(i)==seq.charAt(j) && cl == 2)
              L[i][j]=2;

           // If there are more than two characters, and first and last characters are same
           else if (seq.charAt(i) == seq.charAt(j)) 
              L[i][j] = L[i+1][j-1] + 2; 

           // IF first and last characters are not same
           else
              L[i][j] = max(L[i][j-1], L[i+1][j]); 
            } 
        }         
        return L[0][n-1]; 
    }

 
    public static void main(String args[]){ 
        String seq = "GEEKSFORGEEKS"; 
        int n = seq.length(); 
        System.out.println("The lnegth of the lps is "+ lps(seq)); 
    } 
} 
