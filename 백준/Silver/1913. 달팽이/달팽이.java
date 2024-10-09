import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int [] dy = {1,0,-1,0};
		int [] dx = {0,1,0,-1};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] p = new int [2];
		int [][] board = new int[n][n];
		int d = 0;
		int y = 0, x = 0;
		for(int i = n*n; i >= 1; i--) {
			if(y < 0 || y >= n || x < 0|| x >= n || board[y][x] != 0 ) {
				y -= dy[d];
				x -= dx[d];
				d = (d+1)%4;
				y += dy[d];
				x += dx[d];
			}
			board[y][x] = i;
			if(m == i) {
				p[0] = y+1;
				p[1] = x+1;
			}
			y += dy[d];
			x += dx[d];
			//System.out.println(i + ": (" + y + ", " + x + ")");
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(p[0] + " " + p[1]);
	}
	
}
