import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static class Pair {
        int i,j;
        Pair(int a, int b) {
            i=a;
            j=b;
        }
    }
    
    public static boolean isSafe(int x,int y,int m,int n,int [][]graph,boolean[][]visited) {
        return (x>=0) && (x<m) && (y>=0) && (y<n) && (graph[x][y]!=0) && (!visited[x][y]);
    }
    
    public static int shortest(int[][]graph,int m,int n,int dr,int dc) {
        boolean [][] visited = new boolean[m][n];
        Queue <Pair> q = new LinkedList<>();
        int [][] dist = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        int [] xmove = {0,0,-1,1};
        int [] ymove = {-1,1,0,0};
        q.add(new Pair(0,0));
        while(!q.isEmpty()) {
            Pair p = q.remove();
            visited[p.i][p.j]=true;
            for(int k=0; k<4; k++) {
                int x = p.i+xmove[k];
                int y = p.j+ymove[k];
                if(isSafe(x,y,m,n,graph,visited) && 1+dist[p.i][p.j]<dist[x][y]) {
                    dist[x][y]=1+dist[p.i][p.j];
                    q.add(new Pair(x,y));
                }
            }
        }
        if(graph[0][0]==0) return -1;
        else return dist[dr][dc]==Integer.MAX_VALUE?-1:dist[dr][dc];
    }
    
	public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    int [][] graph = new int[m][n];
		    for(int i=0; i<m; i++) {
		        for(int j=0; j<n; j++) {
		            graph[i][j] = sc.nextInt();
		        }
		    }
		    int dr = sc.nextInt();
		    int dc = sc.nextInt();
		    System.out.println(shortest(graph,m,n,dr,dc));
		}
	}
}
