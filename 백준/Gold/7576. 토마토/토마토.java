import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int r, c, ans;
	static int [][] g;
	static int [][] visit;
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	static 	Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) {
		r = sc.nextInt();
		c = sc.nextInt();
		ans = 0;
		g = new int[c][r];
		visit = new int[c][r];
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				g[i][j] = sc.nextInt();
				if(g[i][j] == 0) visit[i][j] = -1;
				else if(g[i][j] == 1) {
					q.add(new int[] {i,j});
					visit[i][j] = 0;
				}
			}
		}
		sol();
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				if(visit[i][j] == -1) {
					System.out.println(-1);
					return;
				}
				else ans = Math.max(ans,  visit[i][j]);
			}
		}
		System.out.println(ans);
	}
	
	static void sol() {
		while(!q.isEmpty()) {
			int [] t = q.poll();
			int y = t[0];
			int x = t[1];
			for(int i =0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny >= c || ny<0||nx>=r||nx<0) continue;
				if(visit[ny][nx] == -1 && g[ny][nx] == 0) {
					visit[ny][nx] = visit[y][x] + 1;
					q.add(new int[]{ny, nx});
				}
			}
		}
	}
}
