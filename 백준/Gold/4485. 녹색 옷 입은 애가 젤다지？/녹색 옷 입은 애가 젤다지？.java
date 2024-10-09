import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	static Scanner sc =new Scanner(System.in);
	static int n = 1, DoongDDangE;
	static int [][] map;
	static boolean [][] visit;
	public static void main(String[] args) {
		int t= 1;
		while(true) {
			n = sc.nextInt();
			if(n == 0) break;
			init();
			sol();
			System.out.println("Problem " + t + ": " + DoongDDangE);
			t++;
		}
	}
	
	static void init() {
		DoongDDangE = Integer.MAX_VALUE;
		map = new int [n][n];
		visit = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}
	
	static void sol() {
		PriorityQueue<Point> Fat = new PriorityQueue<>();
		Fat.offer(new Point(0,0,map[0][0]));
		visit[0][0] = true;
		while(!Fat.isEmpty()) {
			Point p = Fat.poll();
			if(p.y == n-1 && p.x == n-1) DoongDDangE = Math.min(DoongDDangE, p.cost);
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if(ny > n-1 || ny < 0 || nx > n-1 || nx < 0) continue;
				if(!visit[ny][nx]) {
					Fat.offer(new Point(ny,nx, p.cost+ map[ny][nx]));
					visit[ny][nx]= true;
				}
			}
		}
	}
	
	static class Point implements Comparable<Point>{
		int y, x, cost;
		Point(int y, int x, int cost){
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
		
	}
}
