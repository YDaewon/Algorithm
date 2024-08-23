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
			
			if(root_check()) {  // 2���� ū���� 2�θ������ �������� ���� ��ġ�� ŭ
				n = (long)Math.sqrt(n);
				ans++;
			}
			else {
				long t = (long)Math.sqrt(n) + 1;  // ex n: 10�̸� t ��  3+1 = 4����
				long t2 = t * t - n; // 16 - 10 = 6
				ans += t2; // 6��ŭ �����ֱ�
				n = t; 
				ans++; // ������ ����Ƚ�� 1ȸ �߰�
			}
		}
	}
	
	
	static boolean root_check() {
		double temp = Math.sqrt(n);
		return (long)temp == temp;
	}
}
