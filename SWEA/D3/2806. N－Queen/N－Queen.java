import java.util.Scanner;

public class Solution {
	static int n, ans;
	static int [] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			n = sc.nextInt();
			ans = 0;
			board = new int [n];
			find(0);
			System.out.println("#"+t+" " + ans);
		}
	}
	
	static void find(int d) {
		if(d == n) {
			ans++;
			return;
		}
		for(int i = 0; i < n; i++) {
			board[d] = i;
			if(check(d)) find(d+1);
			board[d] = 0;
		}
	}
	
	static boolean check(int y) {
		for(int i = 0; i < y; i++) {
			if(board[i] == board[y]) return false;
			if (y-i == Math.abs(board[y] - board[i])) return false;
		}
		return true;
	}
}
