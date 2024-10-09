import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int n, ans;
	static int [] m;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			init();
			sol();
			System.out.println("#"+test+" "+ ans);
		}
	}
	
	static void init() {
		n = sc.nextInt();
		ans = 0;
		m = new int[n];
		for(int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}
	}
	
	static void sol() {
		int up = 0;
		int down = 0;
		for(int i = 0; i < n-1; i++) {
			if(m[i] < m[i+1]) { // 
				if(down==0) up++;
				else {
					ans+=up*down;
					up = 1;
					down = 0;
				}
			}
			else {
				if(up != 0) down++; 
			}
		}
		ans+=up*down;
	}
}
