package Baekjoon;

import java.util.Scanner;

public class Solution_1149 {
	static int [][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int [n+1][3];
		int r, g, b;
		r = sc.nextInt();
		g = sc.nextInt();
		b = sc.nextInt();
		dp[1][0] = r;
		dp[1][1] = g;
		dp[1][2] = b;
		for(int i = 2; i<= n; i++) {
			r = sc.nextInt();
			g = sc.nextInt();
			b = sc.nextInt();
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
			dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0]) + g;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
		}
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
	}
}


