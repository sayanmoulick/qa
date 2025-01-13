package graph;

import java.util.*;

class Graph{
	class Edge{
		int v, w;
		public Edge(int v, int w) {
			this.v= v;
			this.w = w;
		}
		@Override
		public String toString() {
			return "["+ v + "," + w +"]";
		}
	}
	List<Edge> G[];
	public Graph(int n) {
		/*
		List<Integer> l[] = new LinkedList[10];
		for(int i=0; i<10; i++)
			l[i] = new LinkedList<integer>();
		 */
		G = new LinkedList[n];
		for(int i=0; i<10; i++)
			G[i] = new LinkedList<Edge>();
	}
	public void addEdge(int u, int v, int w) {
		G[u].add(0, new Edge(v, w));
	}
	boolean isConnected(int u, int v) {
		for (Edge i: G[u])
			if(i.v==v) return true;
		return false;
	}
	@Override
	public String toString() {
		String result = "";
		for(int i=0; i<G.length; i++)
			result+=i +"==>"+ G[i];
		return result;
	}
}
public class AdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(10);
		g.addEdge(0, 2, 10);
		g.addEdge(0, 5, 15);
		
		System.out.println(g);
		System.out.println(g.isConnected(0,5));
	}

}
