import java.util.Scanner;

public class Solution {
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
			
			if(root_check()) {
				n = (long)Math.sqrt(n);
				ans++;
			}
			else {
				long t = (long)Math.sqrt(n) + 1;
				long t2 = t * t - n;
				ans += t2;
				n = t;
				ans++;
			}
		}
	}
	
	
	static boolean root_check() {
		double temp = Math.sqrt(n);
		return (long)temp == temp;
	}
}
