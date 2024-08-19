package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_4012 {
	static int n, ans;
	static int [][] food;
	static int [] visit;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			init();
			combination();
			System.out.println("#" + test + " " + ans);			
		}
	}
	
	static void init() {
		n = sc.nextInt();
		ans = Integer.MAX_VALUE;
		food = new int[n+1][n+1];
		visit = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				food[i][j] = sc.nextInt();
			}
		}
		visit = new int[n+1];
	}
	
	static void combination() {
		int len = 1 << n;
		for(int i = 0; i < len; i++) {
			int cnt = 0;
			Arrays.fill(visit, 0);
		    for(int j = 1; j <= n; j++) {
                if((i &(1<<j)) != 0) { //음식 분배
                    visit[j]= 1;
                    cnt++;
                }
            }
		    if(cnt == n/2) {
		    	ans = Math.min(ans, Math.abs(taste(0)- taste(1)));
		    }
		}
	}
	
	static int taste(int x) {
		int sum = 0;
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(visit[i] == x && visit[j] == x) sum += food[i][j];
			}
		}
		return sum;
	}
}
