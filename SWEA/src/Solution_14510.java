import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_14510 {
	static Scanner sc = new Scanner(System.in);
	static int n, max, ans;
	static int [] tree;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			init();
			sol();
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void init() {
		n = sc.nextInt();
		tree = new int [n];
		ans = 0;
		max = 0;
		for(int i = 0 ; i < n; i++) {
			tree[i] = sc.nextInt();
			max = Math.max(tree[i], max);
		}
	}
	
	static void sol() {
		int one=0, two=0;
		for(int i = 0 ; i < n; i++) {
			int d = max - tree[i];
			if(d == 0) continue;
			one += d % 2;
			two += d / 2;
		}

		if(two > one) {
			while(Math.abs(two - one) > 1) {
				two--;
				one += 2;
			}
		}
		if(one > two){
			ans = one * 2 - 1;
		}
		else if(one < two) ans = two * 2;
		else{
			ans = one +two;
		}
	}
	
}
