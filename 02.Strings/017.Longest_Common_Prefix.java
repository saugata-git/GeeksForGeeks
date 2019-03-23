class LongestCommonPrefix{

    static final int ALPHABATE_SIZE=26;

    static class TrieNode{

      TrieNode[] children =new TrieNode[ALPHABATE_SIZE];
      boolean isLeaf;

      public TrieNode(){
         isLeaf=false;
         for(int i=0;i<ALPHABATE_SIZE;i++)
           children[i]=null;
      }
    };


    static TrieNode root;
    static int indexs;

    static void insert(String key){

      int length=key.length();
      int index;

      TrieNode pCrawl=root;

      for(int level=0;level<length;level++){

          index=key.charAt(level)-'a';
          if(pCrawl.children[index]==null){
             pCrawl.children[index]=new TrieNode();
          }
          pCrawl=pCrawl.children[index];
      }

      //mark last node as leaf
      pCrawl.isLeaf=true;
    }
    

    static int countChildren(TrieNode node){

      int count =0;
      for(int i=0;i<ALPHABATE_SIZE;i++){
            if(node.children[i]!=null){
              count++;
              indexs=i;
            }
      }
      return (count);
    }


    static void constructTrie(String arr[],int n){
      
       for(int i=0;i<n;i++)
          insert(arr[i]);
       return;
    }

    static String walkTrie(){
      
       TrieNode pCrawl= root;
       indexs=0;
       String prefix="";
       while(countChildren(pCrawl)==1 && pCrawl.isLeaf==false){
          pCrawl=pCrawl.children[indexs];
          prefix+=(char)('a'+indexs);
       }
       return prefix;
    }
   
    static String commonPrefix(String arr[],int n){
      root= new TrieNode();
      constructTrie(arr,n);
      return walkTrie();
    }

    public static void main(String args[]){

      String arr[]={"geeksforgeeks","geeks","geek","geezer"};
      int n =arr.length;
      String ans=commonPrefix(arr,n);
      if(ans.length()!=0){
        System.out.println("The Longest Common Prefix is "+ ans); 
      }
      else{
        System.out.println("No longest Common Prefix");
      }
    }
}
