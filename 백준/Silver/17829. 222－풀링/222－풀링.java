import java.util.Scanner;

public class Main {
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
		System.out.println(polling(n, 0, 0));
		
	}
	
	static int polling(int size, int y, int x) { // 왼쪽 위 시작
		if(size == 2) {
			int f = Integer.MIN_VALUE;
			int s = f;
			for(int i = y; i < y + 2; i++) {
				for(int j = x; j < x + 2;j++) {
					if(board[i][j] >= f) {
						s = f;
						f = board[i][j];
					}
					else if (board[i][j] > s) {
						s = board[i][j];
					}
				}
			}
			//System.out.println(y + ", " + x + ": " + s);
			return s;
		}
		int fval = Integer.MIN_VALUE;
		int sval = Integer.MIN_VALUE;
		for(int i = 0; i <= size/2; i += size/2) {
			for(int j = 0; j <= size/2;j += size/2) {
				int val = polling(size/2, y + i, x + j);
				if(val >= fval) {
					sval = fval;
					fval = val;
				}
				else if (val > sval) {
					sval = val;
				}
			}
		}
		return sval;
	}
}
