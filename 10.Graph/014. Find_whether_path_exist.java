
import java.util.*;
import java.lang.*;
import java.io.*;

class pathexist {
    
    static class Pair {
        int i,j;
        Pair(int x,int y) {
            i=x;
            j=y;
        }
    }
    
    public static boolean isSafe(int [][] graph,int x,int y,int n,boolean [][]visited) {
        return (x>=0) && (x<n) && (y>=0) && (y<n) && (graph[x][y]!=0) && (!visited[x][y]);
    }
    
    public static boolean path(int [][] graph, int n) {
        int sr=0, sc=0, dr=0, dc=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j]==1) {
                    sr=i;
                    sc=j;
                }
                
                if(graph[i][j]==2) {
                    dr=i;
                    dc=j;
                }
                if(graph[i][j]!=1) {
                   return false;
                }
                if(graph[i][j]!=2) {
                   return false;
                }
            }
        }
        
        int [] xmove = {-1,+1,0,0};
        int [] ymove = {0,0,-1,+1};
        Queue <Pair> q = new LinkedList<>();
        boolean [][] visited = new boolean[n][n];
        q.add(new Pair(sr,sc));
        while(!q.isEmpty()) {
            Pair p = q.remove();
            visited[p.i][p.j]=true;
            for(int k=0; k<4; k++) {
                int x = p.i+xmove[k];
                int y = p.j+ymove[k];
                if(isSafe(graph,x,y,n,visited)) {
                    q.add(new Pair(x,y));
                }
            }
        }
        return visited[dr][dc];
    }
    
	public static void main (String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int [][] graph = new int[n][n];
		    for(int i=0; i<n; i++) {
		        for(int j=0; j<n; j++) {
		            graph[i][j] = sc.nextInt();
		        }
		    }
		    System.out.println(path(graph,n)==true?1:0);
		}
	}
}
