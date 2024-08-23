package Baekjoon;

import java.util.Scanner;

public class Solution_6987 {
	static int [][][] arr = new int[4][6][3];
	static int [][] score = new int[6][3];
	static int [] ans = new int [4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 6; j++) {
				arr[i][j][0] = sc.nextInt(); // win
				arr[i][j][1] = sc.nextInt(); // draw
				arr[i][j][2] = sc.nextInt(); // lose	
			}
		}
	}
	
	static void sol(int team) {
		if(team == 6) {
			for(int i = 0; i < 4; i++) {
				if(check(i)) ans[i] = 1;
			}
			return;
		}
		for(int i = 0; i < 6; i++) {
			if(i == team) continue;
			score[team][0]++; score[i][2]++;
			sol(team+1);
			score[team][0]--; score[i][2]--;
			score[team][1]++; score[i][1]++;
			sol(team+1);
			score[team][1]--; score[i][1]--;
			score[team][2]++; score[i][0]++;
			sol(team+1);
			score[team][2]--; score[i][0]--;
		}
	}
	
	
	static boolean check(int idx) {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				if(arr[idx][i][j] != score[i][j]) return false;
			}
		}
		return true;
	}
	
}
