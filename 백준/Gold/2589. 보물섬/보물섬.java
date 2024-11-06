import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean [][] visit;
	static char [][] map;
	static int n, m, ans;
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new char[n][m];
		ans = 0;
		for(int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		System.out.println(ans);
	}
	private static void bfs(int y, int x) {
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {y, x, 0});
		visit = new boolean[n][m];
		visit[y][x] = true;
		while(!q.isEmpty()) {
			int [] now =q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if(ny >= n || ny <0 || nx >= m || nx < 0) continue;
				if(map[ny][nx] == 'W') continue;
				if(!visit[ny][nx]) {
					visit[ny][nx] = true;
					q.offer(new int[] {ny,nx, now[2]+1});
					ans = Math.max(now[2]+1, ans);
				}
			}
		}
	}
}
