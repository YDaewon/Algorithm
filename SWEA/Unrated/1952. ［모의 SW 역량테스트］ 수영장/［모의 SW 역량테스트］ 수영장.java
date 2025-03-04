import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int ans;
	static int [] plan, cost;
	static int [] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T;t++) {
			cost = new int [4];
			for(int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			plan = new int [12];
			for(int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			dp = new int[13];
			for(int i = 1; i<= 12; i++) {
				if(plan[i-1] != 0) {
					int val = dp[i-1] + cost[0] * plan[i-1];
					val = Math.min(val, dp[i-1] + cost[1]);
					if(i >= 3) val = Math.min(val, dp[i-3] + cost[2]);
					val = Math.min(val, cost[3]);
					dp[i] = val;
				}
				else dp[i] = dp[i-1];
			}
			//for(int i = 1; i <= 12; i++) System.out.println(dp[i]);
			
			System.out.println("#" + t + " " + dp[12]);
		}
	}
}
