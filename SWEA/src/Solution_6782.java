package SWEA;

import java.util.Scanner;

public class Solution_6782 {
	static Scanner sc = new Scanner(System.in);
	static long n, ans;
	public static void main(String[] args) {
		long T = sc.nextLong();
		for(long t = 1; t<=T;t++) {
			n = sc.nextLong();
			ans = 0;
			sol();
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void sol() {
		while(n != 2) {
			if(n == 1) {
				ans++;
				break;
			}
			
			if(root_check()) {  // 2보다 큰수를 2로만들려면 제곱근이 제일 가치가 큼
				n = (long)Math.sqrt(n);
				ans++;
			}
			else {
				long t = (long)Math.sqrt(n) + 1;  // ex n: 10이면 t 는  3+1 = 4가됨
				long t2 = t * t - n; // 16 - 10 = 6
				ans += t2; // 6만큼 더해주기
				n = t; 
				ans++; // 제곱근 연산횟수 1회 추가
			}
		}
	}
	
	
	static boolean root_check() {
		double temp = Math.sqrt(n);
		return (long)temp == temp;
	}
}
