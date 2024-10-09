import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static String pw;
	static int p, n, k;
	static long ans;
	static TreeSet<Long> set;
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			init();
			sol();
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static long hex2dec(String str) {
		int size = str.length();
		long num = 0;
		long t = 0;
		for(int i = 0; i < size; i++) {
			char c = str.charAt(i);
			if(c >= 'A' && c <= 'F') t = c - 'A' + 10;
			else t = c - '0';
			num += t* Math.pow(16, size-i-1);
		}
		return num;
	}
	
	static void init() {
		n = sc.nextInt();
		k = sc.nextInt();
		sc.nextLine();
		pw = sc.nextLine();
		pw = pw + pw;
		ans = 0;
		set = new TreeSet<>(Collections.reverseOrder());
	}
	
	static void sol() {
		for(int t = 0; t < n/4; t++) {
			p = t;
			for(int i = 0; i < 4; i++) {
				String temp = pw.substring(p, p+(n/4));
				//System.out.println(temp);
				set.add(hex2dec(temp));
				p += n/4;
			}
		}
		
		for(int i = 0; i < k; i++) {
			ans = set.pollFirst();
		}
	}

}
