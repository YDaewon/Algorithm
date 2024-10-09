import java.util.Scanner;

public class Solution {
	static int n, l, ans;
	static burger [] bg;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			n = sc.nextInt();
			l = sc.nextInt();
			bg = new burger[n];
			ans = 0;
			for(int i = 0; i < n;i++) {
				int s = sc.nextInt();
				int k = sc.nextInt();
				bg[i] = new burger(s, k);
			}
			subset(0,0,0);
			System.out.println("#" + test + " " + ans);
		}
	}
	
	
	static void subset(int depth, int total_kcal, int total_score) {
		if(total_kcal > l) return;
		if(depth == n) {
			ans = Math.max(ans, total_score);
			return;
		}
		subset(depth+1, total_kcal + bg[depth].kcal, total_score + bg[depth].score);
		subset(depth+1, total_kcal, total_score);
		
	}
	
	
	
	static class burger{
		int score;
		int kcal;
		burger(int f, int s){
			score = f;
			kcal = s;
		}
		
	}
}
