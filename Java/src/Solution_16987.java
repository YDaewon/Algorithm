package Baekjoon;

import java.util.Scanner;


public class Solution_16987 {
	static int n, ans = 0;
	static int [][] egg;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		egg = new int [n][2]; // 0: 내구도 , 1: 무게
		for(int i = 0; i < n;i++) {
			egg[i][0] = sc.nextInt();
			egg[i][1] = sc.nextInt();
		}
		sol(0, 0);
		System.out.println(ans);
	}
	
	static void sol(int now, int cnt) {
		//System.out.println(now);
		if(now == n) {
			ans = Math.max(ans, cnt);
			return;
		}
		if(egg[now][0] <= 0 || cnt == n-1) {
			sol(now+1, cnt);
			return;
		}
		int temp = cnt;
		for(int i = 0; i < n;i++) {
			if(i == now) continue;
			if(egg[i][0] <= 0) continue;
			crack(now, i);
			if(egg[now][0] <= 0) cnt++;
			if(egg[i][0] <= 0) cnt++;
			sol(now+1, cnt);
			btb(now,i);
			cnt = temp;
		}
	}
	
	static void crack(int a, int b) {
		egg[a][0] -= egg[b][1];
		egg[b][0] -= egg[a][1];
	}
	static void btb(int a, int b) {
		egg[a][0] += egg[b][1];
		egg[b][0] += egg[a][1];
	}
}
