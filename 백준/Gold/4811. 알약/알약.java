import java.util.Scanner;

public class Main {
	static int n;
	static long [][] dp = new long[31][31];
	
	public static void main(String[] args) {
		Scanner nc = new Scanner(System.in);
		while(true) {
			n = nc.nextInt();
			if(n==0) break;
			dp[0][0] = 0;
			for(int i = 1; i <= n; i++) {
				dp[0][i] = 1;
				for(int j = 1; j <= i; j++) {
					dp[j][i] = dp[j-1][i] + dp[j][i-1];
				}
			}
			System.out.println(dp[n][n]);
		}
	}
}
