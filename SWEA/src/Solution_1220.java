package test;

import java.util.Arrays;


/*------------N---------------
 * 
 *----------------------------
 *|                          |
 *|                          |
 *|                          | 
 *|                          | 
 *|         100x100          | 
 *|                          |
 *|                          |
 *|                          | 
 *|                          |
 * ---------------------------
 * 
 *------------S---------------
 *
 *  0: ºó°ø°£,  1: N±Ø,  2: S±Ø
 * */
import java.util.Scanner;

public class Solution_1220 {
	static int n, ans;
	static int [][] table;
	static int [] visit;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = 10;
		for(int test = 1; test <= T; test++) {
			init();
			sol();
			System.out.println("#" + test + " " + ans);			
		}
	}
	
	static void init() {
		n = sc.nextInt();
		ans = 0;
		table = new int[n][n];
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < n; j++) 
				table[i][j] = sc.nextInt();
	}
	
	static void sol() {
		for(int x = 0; x < n; x++) {
			col(x);
		}
	}
	
	static void col(int x) {
		int n_cnt = 0;
		for (int i = 0; i < n; i++) {
			if(table[i][x] == 1) n_cnt=1;
			else if(table[i][x] == 2 && n_cnt>0) {
				ans++;
				n_cnt=0;
			}
		}
	}
}


