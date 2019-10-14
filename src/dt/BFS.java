package dt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	public void bfs(int s,int t,Graph graph) {
		if(s<0||t<0) {
			return;
		}
		if(s==t) {
			System.out.println("两站点相同");
			return;
		}
		int v=graph.getV();
		LinkedList<Integer>[] adj=graph.getAdj();
		boolean[] visited = new boolean[v];
		visited[s] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		int[] prev = new int[v];
		for(int i=0; i<v;i++) {
			prev[i] = -1;
		}
		while(queue.size() != 0) {
			int w =queue.poll();
			for(int i=0; i<adj[w].size();++i) {
				int q = adj[w].get(i);
				while(!visited[q]) {
					prev[q] = w;
					if(q == t) {
						print(prev,s,t);
						return;
					}
					visited[q] = true;
					queue.add(q);
				}
			}
		}
	}
	public void print(int[] prev, int s,int t) {
		int tt=t;
		int num=2;
		Stack<Integer> stack=new Stack<Integer>();
		while(prev[t]!=-1&&s!=t){
			stack.push(prev[t]);
			t=prev[t];
		}
		List<String> line = new ArrayList<String>();
		while(!stack.empty()){
			int e=stack.pop();
			String name=new init().station_name.get(e);
			line.add(name);
		}
		String name=new init().station_name.get(tt);
		line.add(name);
		System.out.print(line.get(0));
		for(int i=1;i<line.size()-1;i++) {
			int x=transfer(line.get(i-1),line.get(i));
			int y=transfer(line.get(i),line.get(i-1));
			int x1=transfer(line.get(i),line.get(i+1));
			int y1=transfer(line.get(i+1),line.get(i));
			if(x<=0) {
				x=y;
			}
			if(x1<=0) {
				x1=y1;
			}
			if(x==x1) {
				System.out.print("->"+line.get(i));
				num++;
			}
			else {
				System.out.print("->"+line.get(i)+"(换乘"+num(x1)+")");
				num++;
			}
		}
		System.out.print("->"+line.get(line.size()-1));
		System.out.println();
		System.out.println("共"+num+"站");
	}
	public int transfer(String n,String m) {
		int p=-1;
		int flag=0;
		int o=0;
		for(List<String> lline:new init().lineSet) {
			for(int i=0;i<lline.size()-1;i++) {
				if(n.equals(lline.get(i))&&m.equals(lline.get(i+1))||
				   n.equals(lline.get(0))&&m.equals(lline.get(lline.size()-1))||
				   m.equals(lline.get(0))&&n.equals(lline.get(lline.size()-1))) {
					p=o;
					flag=1;
					break;
				}
			}
			if (flag==1) break;
			o++;
		}
		return p;
	}
	public String num(int p) {
		String n=null;
		switch(p) {
		case 0:n=("1号线");break;
		case 1:n=("2号线");break;
		case 2:n=("4号线");break;
		case 3:n=("大兴线");break;
		case 4:n=("5号线");break;
		case 5:n=("6号线");break;
		case 6:n=("7号线");break;
		case 7:n=("8号线北");break;
		case 8:n=("8号线南");break;
		case 9:n=("9号线");break;
		case 10:n=("10号线");break;
		case 11:n=("13号线");break;
		case 12:n=("14号线西");break;
		case 13:n=("14号线东");break;
		case 14:n=("15号线");break;
		case 15:n=("16号线");break;
		case 16:n=("八通线");break;
		case 17:n=("房山线");break;
		case 18:n=("昌平线");break;
		case 19:n=("亦庄线");break;
		case 20:n=("燕房线");break;
		case 21:n=("S1线");break;
		case 22:n=("西郊线");break;
		case 23:n=("首都机场线");break;
		}
		return n;
	}
}
