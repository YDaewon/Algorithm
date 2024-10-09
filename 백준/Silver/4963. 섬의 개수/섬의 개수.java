import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int [] dy = {-1,1,0,0,-1,-1,1,1};
	static int [] dx = {0,0,-1,1,-1,1,-1,1};
	static int w, h;
	static int [][] board;
	static boolean [][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if(w == 0 && h == 0) break;
			board = new int[h][w];
			visit = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(board[i][j] == 1 && visit[i][j] == false) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	
	 public static void bfs(int i, int j) {
	     Queue<Pair> q = new LinkedList<>();
	     q.add(new Pair(i,j));
	     visit[i][j] = true;
	     while (!q.isEmpty()) {
	         Pair p = q.poll();
	         for (int d = 0; d < 8; d++) {
	             int ny = p.y + dy[d];
	             int nx = p.x + dx[d];
	             if(ny >= h || ny < 0 || nx >= w || nx < 0) continue;
	             if(visit[ny][nx] == false && board[ny][nx] == 1) {
	            	 visit[ny][nx] = true;
	            	 q.add(new Pair(ny,nx));
	             }
	         }
	     }
	 }
	 
	 static class Pair{
		 int y, x;
		 Pair(int y, int x){
			 this.y = y;
			 this.x = x;
		 }
	 }
}
