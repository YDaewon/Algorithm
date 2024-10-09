import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [] dy = {-1,0,1,0}; // N, E, S, W 
	static int [] dx = {0,1,0,-1};
	static int n, m;
	static int [][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		board = new int[n+1][m+1];
		int direction = 1;
		Dice dice = new Dice();
		dice.y = 1; dice.x = 1;
		for(int i = 1; i<= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<= m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i = 0; i < k; i++) {
			dice.y += dy[direction];
			dice.x += dx[direction];
			if(!out_check(dice.y, dice.x)) {
				direction = (direction + 2) % 4;
				dice.y += dy[direction] * 2;
				dice.x += dx[direction] * 2;
			}
			dice.roll(direction);
			ans += bfs(dice.y, dice.x);
			if(dice.getB() > board[dice.y][dice.x]) direction = (direction + 1) % 4;
			else if(dice.getB() < board[dice.y][dice.x]) direction = (direction + 4 - 1) % 4;
			//System.out.println(" direction: " + direction);
		}
		System.out.println(ans);
	}
	
	static boolean out_check(int y, int x) {
		return y <= n && y > 0 && x <= m && x > 0;
	}
	
	static int bfs(int y, int x) {
		int [][] visit = new int[n+1][m+1];
		Queue<Pair> q = new LinkedList<>();
		int val = board[y][x];
		int result = val;
		//System.out.print("now Point: "+y+", "+x+" value: "+val);
		q.add(new Pair(y,x));
		visit[y][x] = 1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = p.y+dy[i];
				int nx = p.x +dx[i];
				if(out_check(ny,nx) && visit[ny][nx] == 0 && board[ny][nx] == val) {
					q.add(new Pair(ny,nx));
					visit[ny][nx] = 1;
					result += val;
				}
			}
		}
		return result;
	}
}

class Dice{
	int y, x;
	int [] element = {1,6,4,3,2,5};
	// top, bottom, W, E, S, N
	void roll(int d){
		int top = element[0];
		switch(d) {
		case 1: // E
			element[0] = element[2];
			element[2] = element[1];
			element[1] = element[3];
			element[3] = top;
			break;
		case 3: // W
			element[0] = element[3];
			element[3] = element[1];
			element[1] = element[2];
			element[2] = top;
			break;
		case 2: // S
			element[0] = element[4];
			element[4] = element[1];
			element[1] = element[5];
			element[5] = top;
			break;
		case 0: // N
			element[0] = element[5];
			element[5] = element[1];
			element[1] = element[4];
			element[4] = top;
			break;
			
		}
	}
	
	int getB() {
		return element[1];
	}
	@Override
	public String toString() {
		return "Dice [" + ", element=" + Arrays.toString(element) + "]";
	}
}

class Pair{
	int y, x;
	Pair(int y, int x){
		this.y = y;
		this.x = x;
	}
}