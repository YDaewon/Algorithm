import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution_2543 {
	static int n, hole_y, hole_x;
	static int [][] arr;
	static Deque<Pair> q = new ArrayDeque<>();
	static int []dy = {-1,1,0,0,-1,-1,1,1};
	static int []dx = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		hole_y = sc.nextInt();
		hole_x = sc.nextInt();
		arr = new int[n][n];
		arr[hole_y][hole_x] = -1;
		sol(0,0,n);
		arr[hole_y][hole_x] = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	static void sol(int y, int x, int size) {
		if(size == 2) {
			int tile = 1;
			boolean flag = false;
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					if(arr[i+y][j+x] == -1) {
						tile += (i*2)+j;
						flag = true;
					}
				}
			}
			if(flag) {
				for(int i = y; i < y+2; i++) {
					for(int j = x; j < x+2; j++) {
							arr[i][j] = tile;
					}
				}
				arr[hole_y][hole_x] = -1;
			}
			q.add(new Pair(y-1,x-1));
			set_tile();
			return;
		}
		int half = size/2;
		sol(y,x,half);
		sol(y+half,x,half);
		sol(y,x+half,half);
		sol(y+half,x+half,half);
	}
	
	static void set_tile() {
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int tile = select_tile(p.y, p.x);
			if(tile != -1) {
				for(int i = 0; i < 2; i++) {
					for(int j = 0; j < 2; j++) {
						if((i*2) + j + 1 == tile) continue;
						int ny = p.y + i;
						int nx = p.x + j;
						if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
						arr[ny][nx]= tile; 
					}
				}
			}
		}
	}
	
	static int select_tile(int y, int x) {
		int num = 1;
		int check = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				int ny = y + i;
				int nx = x + j;
				if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
				if(arr[ny][nx] != 0) num += (i*2) + j;
				else check++;
			}
		}
		if(check == 3) {
			for(int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
				if(arr[ny][nx] == 0) q.add(new Pair(ny, nx));
			}
		}
		return check == 3 ? num : -1;
	}
	
	
	static class Pair{
		int y, x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
