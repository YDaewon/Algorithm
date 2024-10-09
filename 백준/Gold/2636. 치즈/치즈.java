import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int [][]board;
	static int n, m, cnt, before, ans;
	
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		cnt = before = ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == 1) {
					cnt++;
				}
			}
		}
		int time = 0;
		while(cnt != 0) {
			bfs();
			time++;
		}
		
		System.out.println(time);
		System.out.println(before);
	}
	
	static void bfs() {
		before = cnt;
		Queue<Pair> q = new LinkedList<>();
		int [][] visit = new int [n][m];
		q.add(new Pair(0,0));
		visit[0][0] = 1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if(ny >=n || ny < 0 || nx >=m || nx < 0) continue;
				if(visit[ny][nx] == 0) {
					if(board[ny][nx] == 0) {
						q.add(new Pair(ny,nx));
						visit[ny][nx] = 1;
					}
					else if(board[ny][nx] == 1) {
						visit[ny][nx] = 1;
						board[ny][nx] = -1;
					}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == -1) {
					board[i][j] = 0;
					cnt--;
				}
			}
		}
	}
	
	static class Pair{
		int y,x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
