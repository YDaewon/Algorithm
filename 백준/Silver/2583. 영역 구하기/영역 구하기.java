import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	static Scanner sc = new Scanner(System.in);
	
	
	static int n, m, k, ans;
	static int [][] board;
	static boolean [][] visit;
	static List<Integer> sec;
	public static void main(String[] args) {
		init();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 0 && !visit[i][j]) {
					sec.add(bfs(i,j));
					ans++;
				}
			}
		}
		Collections.sort(sec);
		System.out.println(ans);
		for(int i : sec) {
			System.out.print(i + " ");
		}
	}
	
	
	static void init() {
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		board = new int[m][n];
		visit = new boolean[m][n];
		ans = 0;
		for(int i = 0; i < k; i++) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();
			for(int y = sy; y < ey; y++) {
				for(int x = sx; x < ex; x++) {
					board[y][x] = -1;
				}
			}
		}
		sec = new ArrayList<>();
	}
	
	
	
	static int bfs(int y, int x) {
		int cnt = 1;
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {y,x});
		while(!q.isEmpty()) {
			int [] p = q.poll();
			board[p[0]][p[1]] = ans+1;
			for(int i = 0; i < 4; i++) {
				int ny = p[0] + dy[i];
				int nx = p[1] + dx[i];
				if(ny < 0 || ny >= m || nx < 0 || nx>= n) continue;
				if(board[ny][nx] == -1) continue;
				if(board[ny][nx] == 0 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.offer(new int [] {ny, nx});
					cnt++;
				}
			}
		}
		return cnt;
	}
}
