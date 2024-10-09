import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] home = new int [n][n];
		long [][][] dp = new long [n][n][3];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				home[i][j] = sc.nextInt();
			}
		}
		dp[0][1][0] = 1;
		for(int i = 2; i < n; i++) {
			if (home[0][i] == 0) dp[0][i][0] = dp[0][i-1][0];
		}
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if(home[i][j] == 1)continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][1];
				if(home[i-1][j] == 1 || home[i][j-1] ==1) continue;
				dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
	}
}
