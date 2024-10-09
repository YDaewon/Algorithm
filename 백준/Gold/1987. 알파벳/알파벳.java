import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	static char [][] board;
	static int r, c, ans = 0;
	static boolean [] m;
	public static void main(String[] args) {
		r = sc.nextInt();
		c = sc.nextInt();
		sc.nextLine();
		m = new boolean[30];
		board = new char[r][c];
		for(int i = 0; i < r; i++) {
			String t = sc.nextLine();
			for(int j = 0; j < c; j++) {
				board[i][j] = t.charAt(j);
			}
		}
		m[board[0][0]-'A'] = true;
		dfs(0,0,0);
		System.out.println(ans);
	}
	
	static void dfs(int y, int x, int val) {
		 ans = Math.max(ans, val+1);
		 for (int i = 0; i < 4; i++) {
             int ny = y + dy[i];
             int nx = x + dx[i];
             if (nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
             if(!m[board[ny][nx] - 'A']) {
            	 m[board[ny][nx] - 'A'] = true;
            	 dfs(ny,nx,val+1);
            	 m[board[ny][nx] - 'A'] = false;
             }
		 }
	}
}
