import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int [][] board;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		board = new int [n][n];
		for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
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
