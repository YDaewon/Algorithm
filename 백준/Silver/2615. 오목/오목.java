import java.util.Scanner;

public class Main {
	static int [][] board;
	static boolean [][][] visit;
	static int [] dy = {1, 1, 0,-1};
	static int [] dx = {0, 1, 1, 1};
	static boolean end = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new int[21][21];
		visit = new boolean [21][21][4];
		for(int i = 1; i <= 19; i++) {
			for(int j = 1; j <= 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		sol();
	}
	
	static void sol(){
		for(int i = 1; i <= 19; i++) {
			for(int j = 1; j <= 19; j++) {
				if(board[i][j] != 0) {
					for(int d = 0; d < 4; d++) {
						if(!visit[i][j][d]) end = isEnd(i,j,d);
						if(end) {
							System.out.println(board[i][j]);
							System.out.println(i + " " + j);
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}
	
	static boolean isEnd(int y, int x, int d) {
		int cnt = 0;
		int ny = y, nx = x;
		while(board[ny][nx] == board[y][x]) {
			cnt++;
			visit[ny][nx][d] = true;
			ny += dy[d];
			nx += dx[d];
		}
		ny = y- dy[d]; nx = x-dx[d];
		while(board[ny][nx] == board[y][x]) {
			cnt++;
			visit[ny][nx][d] = true;
			ny += dy[d];
			nx += dx[d];
		}
		return cnt == 5;
	}
}
