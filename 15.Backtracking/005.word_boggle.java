// DFS/TRIE/BACKTRACKING
//.Using Trie, we can search the key in O(M) time.where M is maximum string length
/*
we are already looking at n^2*2^(n-1). n^2 because the grid is n by n and so for a 4 by 4 grid there are 16 possible 
starting characters. And 2^(n-1) because of the powerset led by each starting character. 
But we can already see the time complexity with that first pattern: Big-Omega(2^n) which is exponential.


Building a prefix tree our of the dictionary words is O(W * L), 
where W is the number of words in the dictionary and L is the maximum length of a word in the dictionary.
Searching the board will be of the same order as the dictionary since we are not really searching words that are not 
in the dictionary. But in reality it will be more work than that as we still need to backtrack along the
board to construct new words until we can consult the dictionary prefix tree to know whether it exists or not.

*/
class Boggle{

   static final int SIZE=26;
   static final int M=3;
   static final int N=3;

   static class TrieNode{

           TrieNode []Child = new TrieNode[SIZE];
           boolean leaf;
           public TrieNode(){
                 leaf=false;
                 for(int i=0;i<SIZE;i++){
                    Child[i]=null;
                 }
           } 
   }

   static void insert(TrieNode root,String key){
      int n=key.length();
      TrieNode pChild=root;
      for(int i=0;i<n;i++){
          int index=key.charAt(i)-'A';
          if(pChild.Child[index]==null)
               pChild.Child[index]=new TrieNode();
          pChild=pChild.Child[index];
      }
      pChild.leaf=true;
   }

   static boolean isSafe(int i,int j,boolean visited[][]){
       return(i>=0 && i<M && j>=0 &&j<N && !visited[i][j]);
   }


   static void searchWord(TrieNode root, char boggle[][], int i,int j, boolean visited[][], String str){

     if(root.leaf=true)
     System.out.println(str);

     if(isSafe(i,j,visited)){
         visited[i][j]=true;
         for(int K=0;K<SIZE;K++){
             if(root.Child[K]!=null){
                 char ch=(char)(K+'A');

                 if (isSafe(i+1,j+1,visited) && boggle[i+1][j+1]== ch) 
		     searchWord(root.Child[K],boggle,i+1,j+1,visited,str+ch); 

                 if (isSafe(i, j+1,visited)  && boggle[i][j+1]== ch) 
                     searchWord(root.Child[K],boggle,i, j+1, visited,str+ch); 

                 if (isSafe(i-1,j+1,visited) && boggle[i-1][j+1] == ch) 
                     searchWord(root.Child[K],boggle,i-1, j+1,visited,str+ch); 

                 if (isSafe(i+1,j, visited)  && boggle[i+1][j] == ch) 
                     searchWord(root.Child[K],boggle,i+1, j,visited,str+ch); 

                 if (isSafe(i+1,j-1,visited) && boggle[i+1][j-1] == ch) 
                     searchWord(root.Child[K],boggle,i+1, j-1, visited,str+ch);
 
                 if (isSafe(i, j-1,visited)&& boggle[i][j-1] == ch) 
                     searchWord(root.Child[K],boggle,i,j-1, visited,str+ch); 

                 if (isSafe(i-1,j-1,visited) && boggle[i-1][j-1] == ch) 
                     searchWord(root.Child[K],boggle,i-1, j-1,visited,str+ch); 

                 if (isSafe(i-1, j,visited) && boggle[i-1][j]  == ch) 
                     searchWord(root.Child[K],boggle,i-1, j,visited,str+ch); 

             }
         }
        visited[i][j] = false; 
     } 
   } 

   static void findWords(char boggle[][],TrieNode root){

       boolean [][]visited =new boolean[M][N];
       TrieNode pChild =root;
       String str="";
       for(int i=0;i<M;i++){
           for(int j=0;j<N;j++){
               if(pChild.Child[(boggle[i][j])-'A']!=null){
                str=str+boggle[i][j];
                searchWord(pChild.Child[(boggle[i][j])-'A'],boggle,i,j,visited,str);
                str="";
               }
           }
       }
    }




   public static void main(String args[]){

       String  dictionary[]={"GEEKS", "FOR", "QUIZ", "GEE"};
       TrieNode root = new TrieNode();
       int n=dictionary.length;
       for(int i=0;i<n;i++)
             insert(root,dictionary[i]);

       char boggle[][]={{'G','I','Z'}, 
                        {'U','E','K'}, 
			{'Q','S','E'}
                       };
       findWords(boggle,root);
    }

}
