import java.util.Scanner;

public class Main {
	static int [] ans = {0,0,0}; // -1, 0, 1
	static int [][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		board = new int [n][n];
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ;j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		polling(n, 0, 0);
		for(int i : ans) {
			System.out.println(i);			
		}
	}
	
	static void polling(int size, int y, int x) { // 왼쪽 위 시작
		if(size == 1) {
			count_up(board[y][x]);
			return;
		}
		boolean flag = true;
		int val = board[y][x];
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				if(val != board[i][j]) {
					flag = false;
					break;
				}
			}
			if(!flag) break;
		}
		if(flag) {
			count_up(val);
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					polling(size/3, y + (size/3 * i), x + (size/3 * j));
				}
			}
		}
	}
	
	static void count_up(int num) {
		if(num == 1) ans[2]++;
		else if(num == 0) ans[1]++;
		else ans[0]++;
	}
}
