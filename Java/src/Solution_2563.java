package Baekjoon;

import java.util.Scanner;

public class Solution_2563 {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int [][] arr;
	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int [101][101]; //100x100 도화지에서 1의 갯수= 답
		int ans = 0;
		for(int i = 0; i < n ; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			for(int j = y; j < y+10;j++) {
				for(int k = x; k < x+10;k++) {
					if(arr[j][k] == 0) {  //visit으로 사용
						arr[j][k] = 1;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
