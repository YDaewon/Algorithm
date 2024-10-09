import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	static Scanner sc =new Scanner(System.in);
	static int v, e, start;
	static List<Node> [] nodes;
	static int [] dist;
	public static void main(String[] args) {
		init();
		sol();
	}
	
	static void init() {
		v = sc.nextInt();
		e = sc.nextInt();
		start =sc.nextInt();
		nodes = new ArrayList[v+1];
		for(int i = 1; i <= v; i++) nodes[i] = new ArrayList<>();
		for(int i = 0; i < e; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			int cost = sc.nextInt();
			nodes[f].add(new Node(s, cost));
		}
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
	}
	
	static void sol() {
		dijkstra();
		for(int i=1;i<=v;i++){
	        if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
	        else System.out.println(dist[i]);
	    }
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node p = pq.poll();
			for(Node node : nodes[p.s]) {
				int nxt_cost = node.cost + p.cost;
				if(dist[node.s] > nxt_cost) {
					dist[node.s] = nxt_cost;
					pq.offer(new Node(node.s, nxt_cost));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int s, cost;
		Node(int s, int cost){
			this.s = s;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
}
