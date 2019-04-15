import java.util.*;


public class prims{

   class node1{
         int dest;
         int weight;
         node1(int a,int b){
            dest=a;
            weight=b;
         }
   }

   class node{
        int vertex;
        int key; 
   }

   static class Graph{
   
      int V;
      LinkedList<node1>[] adj;
      Graph(int e){
          V=e;
          adj= new LinkedList[V];
          for(int i=0;i<V;i++){
             adj[i]=new LinkedList<>();
          }
     }

   }

   void addEdge(Graph graph,int src,int dest,int weight){

       node1 node0= new node1(dest,weight);
       node1 node = new node1(src,weight);
       graph.adj[src].addLast(node0);
       graph.adj[dest].addLast(node); 

   }

   class comparator implements Comparator<node>{
   
       public int compare(node node0,node node1){
          return node0.key-node1.key;
       }
   }

   void prims_mst(Graph graph){
      
     Boolean[] mstset= new Boolean[graph.V];
     node[] e = new node[graph.V];
     int[] parent =new int[graph.V];

     for(int i=0;i<graph.V;i++){
         e[i]= new node();
     }
     for(int i=0;i<graph.V;i++){
         mstset[i]=false;
         e[i].key=Integer.MAX_VALUE;
         e[i].vertex=i;
         parent[i]=-1;
     }

     mstset[0]=true;
     e[0].key=0;

     PriorityQueue<node> queue =new  PriorityQueue<>(graph.V,new comparator());
    
     for(int i=0;i<graph.V;i++){
         queue.add(e[i]);
     }


     while(!queue.isEmpty()){
 
         node n=queue.poll();
         mstset[n.vertex]=true;
         for(node1 iter : graph.adj[n.vertex]){
           if(mstset[iter.dest]==false){
              if(e[iter.dest].key>iter.weight){
                   queue.remove(e[iter.dest]);
                   e[iter.dest].key=iter.weight;
                   queue.add(e[iter.dest]);
                   parent[iter.dest]=n.vertex;
              }
           }
        }

     }
     
     
   
     for (int i = 1; i < graph.V; i++) 
            System.out.println(parent[i] + " "+ "-"  + " " + i); 


   }

   public static void main(String[] args) 
    { 
        int V = 9; 
  
        Graph graph = new Graph(V); 
  
        prims e = new prims(); 
  
        e.addEdge(graph, 0, 1, 4); 
        e.addEdge(graph, 0, 7, 8); 
        e.addEdge(graph, 1, 2, 8); 
        e.addEdge(graph, 1, 7, 11); 
        e.addEdge(graph, 2, 3, 7); 
        e.addEdge(graph, 2, 8, 2); 
        e.addEdge(graph, 2, 5, 4); 
        e.addEdge(graph, 3, 4, 9); 
        e.addEdge(graph, 3, 5, 14); 
        e.addEdge(graph, 4, 5, 10); 
        e.addEdge(graph, 5, 6, 2); 
        e.addEdge(graph, 6, 7, 1); 
        e.addEdge(graph, 6, 8, 6); 
        e.addEdge(graph, 7, 8, 7); 
  
        e.prims_mst(graph); 
    } 

}
