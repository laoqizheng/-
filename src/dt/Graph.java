package dt;

import java.util.LinkedList;

public class Graph {
	public int v;
	public LinkedList<Integer> adj[];
	public Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}
	public void addEdge(int s,int t) {
		adj[s].add(t);
		adj[t].add(s);
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public LinkedList<Integer>[] getAdj() {
		return adj;
	}
	public void setAdj(LinkedList<Integer>[] adj) {
		this.adj = adj;
	}
}
