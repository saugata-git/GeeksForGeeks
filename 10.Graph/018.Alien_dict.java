import java.util.*;
class Graph{


    private final LinkedList<Integer>[]adj;

    Graph(int V){
      adj =new LinkedList[V];
      for(int v=0;v<V;v++){
          adj[v]= new LinkedList();
        }
    }

   void addEdge(int v ,int e){
    adj[v].add(e);
   }

   private int getNoOfVertices(){
    return adj.length;
   }

   private void topologicalSortUtil(int v,boolean visited[],Stack<Integer>stack){
      visited[v]=true;
      for(int it: adj[v]){
           if(!visited[it]){
            topologicalSortUtil(it,visited,stack);
           }
      }
      stack.push(v);
   }


  void topologicalSort(){
  
     Stack<Integer> stack =new Stack();
     boolean[] visited =new boolean[getNoOfVertices()];

     for(int i=0;i<getNoOfVertices();i++){
       visited[i]=false;
     }

     for(int i=0;i<getNoOfVertices();i++){
        if(!visited[i]){
            topologicalSortUtil(i, visited, stack);
        }
     }
     
    while(!stack.isEmpty()){
     System.out.print((char)('a'+stack.pop())+" ");
    }
  }
}

  public class aliendict{ 

        private static void printOrder(String[]words,int len){

         Graph graph= new Graph(len);
         for(int i=0;i<words.length-1;i++){
           String word1= words[i];
           String word2=words[i+1];
           for(int j=0;j<Math.min(word1.length(),word2.length());j++){
              if (word1.charAt(j) != word2.charAt(j)) 
                { 
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j)- 'a'); 
                    break; 
                }
           }
         }
         graph.topologicalSort();
        }

        public static void main(String args[]){
           String []words={"caa","aaa","aab"};
           int length = words. length;
           printOrder(words,3);
         }
}
