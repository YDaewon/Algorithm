import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	
	static int [][] board, dp, visit;
	static int n, m, ans;
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		ans = 0;
		board = new int [n][m];
		dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		dfs(0,0);
		System.out.println(dp[0][0]);
	}
	
	static int dfs(int y, int x) {
		//System.out.println(y + ", " + x);
		if(y == n-1 && x == m-1) {
			return 1;
		}
		if(dp[y][x] != -1) return dp[y][x];
		dp[y][x] = 0;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if(board[y][x] > board[ny][nx]) dp[y][x] += dfs(ny,nx);
		}
		return dp[y][x];
	}
}
