// A Java Program to detect cycle in a graph in directed Graph
//Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).
import java.util.*; 


class Graph { 
	
	private int V;
        private LinkedList<Integer>adj[];
        Graph(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;++i){
          adj[i]= new LinkedList();
        }
       }
       void addEdge(int v,int w){
         adj[v].add(w);
       }
        
     boolean isCyclicUtil(int v,boolean visited[],boolean recStack[]){

          if(recStack[v]==true)
            return true;

          if(visited[v]==true)
            return false;

          visited[v]=true;
          recStack[v]=true;
          
          int i;
          Iterator<Integer>it=adj[v].iterator();
           while(it.hasNext()){
              i=it.next();
              if(!visited[i]){
                  if(isCyclicUtil(i,visited,recStack))
                    return true;
              }
            }
         recStack[v]=false;
         return false; 

        }
 
       boolean isCyclic(){
              boolean[] visited =new boolean[V];
              boolean[] recStack=new boolean[V];
                for(int i=0;i<V;i++)
                     visited[i]=false;

                for(int i=0;i<V;i++){
                   if(!visited[i])
                     if(isCyclicUtil(i,visited,recStack));
                       return true;
                }
                return false;
                
         }
     
	public static void main(String args[]) 
	{ 
		Graph graph = new Graph(4); 
		graph.addEdge(0, 1); 
		graph.addEdge(0, 2); 
		graph.addEdge(1, 2); 
		graph.addEdge(2, 0); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 3); 
		
		if(graph.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't "+ "contain cycle"); 
	} 
} 
