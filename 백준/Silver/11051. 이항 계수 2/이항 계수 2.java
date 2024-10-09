import java.util.Scanner;

public class Main {
	static int [][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		dp = new int[n+1][k+1];
		System.out.println(sol(n, k) % 10007);
	}
	
	static int sol(int n, int k) {
		for(int i = 0; i <= n; i++) dp[i][0] = 1;
		for(int i = 0; i <= k; i++) dp[i][i] = 1;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				dp[i][j] %= 10007;
			}
		}
		return dp[n][k];
	}
}
