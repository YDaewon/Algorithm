import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	static Scanner sc =new Scanner(System.in);
	static int n, ans;
	static int [][] map;
	static boolean [][] visit;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			init();
			sol();
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void init() {
		n = sc.nextInt();
		map = new int [n][n];
		visit = new boolean[n][n];
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
	}
	
	static void sol() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0,0,0));
		visit[0][0] = true;
		int cost = 0;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(p.y == n-1 && p.x == n-1) {
                ans =p.cost;
                return;
            }
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if(ny > n-1 || ny < 0 || nx > n-1 || nx < 0) continue;
				if(!visit[ny][nx]) {
					pq.offer(new Point(ny,nx, p.cost+ map[ny][nx]));
					visit[ny][nx] = true;
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
