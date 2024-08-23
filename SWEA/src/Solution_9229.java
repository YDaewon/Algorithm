package SWEA;

import java.util.Scanner;

public class Solution_9229 {
	static Scanner sc =new Scanner(System.in);
	static int n,m,ans;
	static int [] arr;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			init();
			sol(0,0,0);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = -1;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}	
	}
	
	static void sol(int d, int now, int sum) {
		if(sum > m) return;
		if(d == 2) {
			ans = Math.max(sum, ans);
			return;
		}
		for(int i = now; i < n; i++) {
			sol(d+1, i+1, sum + arr[i]);
		}
	}
}
