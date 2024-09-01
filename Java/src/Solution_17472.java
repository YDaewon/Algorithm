import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution_17472 {
	 static int n, m, island, cost;
	 static int [][] map;
	 static int [][] map_visit;
	 static List<Node> graph;
	 static int [] dy = {-1,1,0,0};
	 static int [] dx = {0,0,-1,1};
	 static int [] parent;
	 static int [][] temp;
	 static Scanner sc =new Scanner(System.in);
	 public static void main(String args[]) {
		 init();
		 sol();
		 System.out.println(cost >= 99999999 ? -1 : cost);
	 }
	  
	 static void init() {
		 n = sc.nextInt();
		 m = sc.nextInt();
		 cost = 0;
		 map = new int[n][m];
		 map_visit = new int[n][m];
		 for(int i = 0; i < n; i++) {
			 for(int j = 0; j < m; j++) {
				 map[i][j] = sc.nextInt();
			 }
		 }
		 get_island();

		 for(int i = 0; i < n; i++) {
			 for(int j = 0; j < m; j++) {
				 System.out.print(map[i][j] + " ");
			 }
			 System.out.println();
		 }
		 graph = new ArrayList<>();
		 parent = new int [island];	 
		 temp = new int[island][island];
		 for(int i = 1; i < island; i++) {
			 for(int j = 1; j < island; j++) {
				 temp[i][j] = 99999999;
			 }
		 }
		 for(int i = 0; i < n; i++) {
			 for(int j = 0; j < m; j++) {
				 if(map[i][j] != 0) {
					 make_graph(i, j);
				 }
			 }
		 }
		 for(int i = 1; i < island; i++) {
			 for(int j = 1; j < island; j++) {
				 graph.add(new Node(i, j, temp[i][j]));
			 }
		 }
		 for(int j = 1; j < island; j++) {
			 parent[j] = j;
		 }
		 for(int i = 1; i < island; i++) {
			 for(int j = 1; j < island; j++) {
				 System.out.print(temp[i][j] + " ");
			 }
			 System.out.println();
		 }
		 Collections.sort(graph);
	 }
	 
	 static int find(int a) {
		 if(a == parent[a]) return a;
		 return find(parent[a]);
	 }
	 
	 static void union(int a, int b) {
		 a = find(a);
		 b = find(b);
		 if(a < b) parent[b] = a;
		 else parent[a] = b;
	 }
	 
	 static void sol() {
			for(int i = 0; i < graph.size();i++) {
				if (find(graph.get(i).f) != find(graph.get(i).s)) {
					cost += graph.get(i).cost;
					union(graph.get(i).f, graph.get(i).s);
				}
			}
	 }
	 
	 static void make_graph(int y, int x) {
		 int f = map[y][x];
		 for(int i = 0 ; i < 4; i++) {
			 int ny = y +dy[i];
			 int nx = x + dx[i];
			 if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			 int cost = 0;
			 boolean end = false;
			 while(map[ny][nx] == 0) {
				 ny += dy[i];
				 nx += dx[i];
				 if(ny < 0 || ny >= n || nx < 0 || nx >= m) {
					 end = true;
					 break;
				 }
				 cost++;
			 }
			 if(!end) {
				 int s = map[ny][nx];
				 if(cost < 2) continue;
				 temp[f][s] = Math.min(cost, temp[f][s]);
				 temp[s][f] = Math.min(cost, temp[s][f]);
			 }
		 }
	 }
	 
	 static void get_island() {
		 island = 1;
		 for(int i = 0; i < n; i++) {
			 for(int j = 0; j < m; j++) {
				 if(map[i][j] != 0 && map_visit[i][j] == 0) {
					 dfs(1, i, j);
					 island++;
				 }
			 }
		 }
	 }
	  
	 static void dfs(int val, int y, int x) {
		 if(map[y][x] == val) {
			 map_visit[y][x] = 1;
			 map[y][x] = island;
			 for(int i = 0 ; i < 4; i++) {
				 int ny = y + dy[i];
				 int nx = x + dx[i];
				 if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
				 if(map_visit[ny][nx] == 0) {
					 dfs(val, ny, nx);
				 }
			 }
		 }
	 }
	 
	 static class Node implements Comparable<Node>{
		int f,s,cost;
		Node(int f, int s, int cost){
			 this.f = f;
			 this.s = s;
			 this.cost = cost;		
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	 }
}
