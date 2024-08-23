package Baekjoon;

import java.util.Scanner;

public class Solution_2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int[100][100];
		int ans = 0;
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j = y; j < y+10; j++) {
				for(int k = x; k < x+10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		
		int [] dy = {-1,1,0,0};
		int [] dx = {0,0,-1,1};
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j] == 0) continue;
				int t = 0;
				for(int k = 0; k < 4; k++) {
					int y = i + dy[k];
					int x = j + dx[k];
					if(y < 0 || y >=100 || x < 0 || x>=100) ans++;
					else if(arr[y][x] == 0) ans++;
				}
			}
		}
		System.out.println(ans);
		
	}
}
