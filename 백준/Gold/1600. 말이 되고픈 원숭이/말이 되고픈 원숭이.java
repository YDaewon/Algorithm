import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int [] dy = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2 ,1};
	static int [] dx = {0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2};
	static int k, w, h;
	static int [][] map;
	static boolean [][][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		map = new int[h][w];
		visit = new boolean[h][w][k+1];
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();
	}
	
	static void bfs() {
		PriorityQueue<int []> pq = new PriorityQueue<>((a, b)-> (a[2] - b[2]));
		pq.offer(new int[] {0,0,0, k});
		visit[0][0][k] = true;
		while(!pq.isEmpty()) {
			int [] p = pq.poll();
			int cost = p[2];
			int k_cnt = p[3];
			if(p[0] == h-1 && p[1] == w-1) {
				System.out.println(cost);
				return;
			}
			for(int i = 0; i < 12; i++) {
				if(k_cnt == 0 && i >= 4) continue;
				int ny = p[0] + dy[i];
				int nx = p[1] + dx[i];
				
				if(ny >= h || ny < 0 || nx >= w || nx < 0 ) continue;
				if(i < 4) {
					if(!visit[ny][nx][k_cnt] && map[ny][nx] == 0) {
						visit[ny][nx][k_cnt] = true;
						pq.offer(new int [] {ny,nx,cost+1, k_cnt});
					}
				}
				else{
					if(!visit[ny][nx][k_cnt - 1] && map[ny][nx] == 0) {
						visit[ny][nx][k_cnt - 1] = true;
						pq.offer(new int [] {ny,nx,cost+1, k_cnt-1});
					}
				}
			}
		}
		System.out.println(-1);
	}
}
