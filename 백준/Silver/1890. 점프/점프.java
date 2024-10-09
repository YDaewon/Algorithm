import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long [][] dp = new long [n+1][n+1];
		int [][] map = new int [n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dp[1][1] = 1;

		for(int y = 1; y <= n; y++) {
			for(int x = 1; x <= n; x++) {
				if(map[y][x] == 0) break;
				int ny = y + map[y][x];
				int nx = x + map[y][x];
				//System.out.println(ny + ", " + nx);
				if(ny <= n) dp[ny][x] += dp[y][x];
				if(nx <= n) dp[y][nx] += dp[y][x];
			}
		}
		System.out.println(dp[n][n]);
		
	}
}
