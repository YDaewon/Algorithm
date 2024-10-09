import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	static int [][] map;
	static boolean [][] visit;
	static int n, k, max, ans;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++) {
			init();
			sol();
			System.out.println("#" + i + " " + ans);
		}
	}
	static void init() {
		n = sc.nextInt();
		k = sc.nextInt();
		max = 0;
		ans = 0;
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
	}
	
	static void sol() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == max) {
					visit = new boolean[n][n];
					visit[i][j] = true;
					dfs(i,j, map[i][j], 1, 0);
				}
			}
		}
	}

	private static void dfs(int y, int x, int h, int len, int cnt) {
		for (int d = 0; d < 4; d++) {
			ans = Math.max(len, ans);

			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
			if(!visit[ny][nx]){
				if (h <= map[ny][nx]) {
					if (cnt == 0 && h > map[ny][nx] - k) {
						visit[ny][nx] = true;
						dfs(ny, nx, h - 1, len+ 1, 1);
						visit[ny][nx] = false;
					}
				} else {
					visit[ny][nx] = true;
					dfs(ny, nx, map[ny][nx], len+ 1, cnt);
					visit[ny][nx] = false;
				}
			}
		}
	}
}
