import java.util.Scanner;

public class Solution {
	static boolean [][] not;
	static int [] visit, select;
	static int n, nand, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			n = sc.nextInt();
			nand = sc.nextInt();
			not = new boolean[n+1][n+1];
			visit = new int[n+1];
			select = new int[n+1];
			ans = 0;
			for(int i = 0; i < nand; i++) {
				int f = sc.nextInt();
				int s = sc.nextInt();
				not[f][s] = true;
				not[s][f] = true;
			}
			subset(1, 1);
			System.out.println("#" + test + " " + ans);
		}
	}
	
	static boolean check(int d, int nxt) {
		for(int i = 1; i <= d; i++) {
			if(not[nxt][select[i]]) return true;
		}
		return false;
	}
	
	static void subset(int d, int now) {
		ans++;
		if(d > n) return;
		//for(int i = 1; i < d; i++) System.out.print(i + ": "  + select[i] + " ");
		//System.out.println();
		for(int k = now; k <= n; k++) {
			if(check(d, k)) continue;
			if(select[d] == 0) {
				select[d] = k;
				subset(d+1, k+1);
				select[d] = 0;
			}
		}
	}
}
