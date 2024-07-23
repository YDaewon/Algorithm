package Algo;

/*
17141번

N은 5 이상, 50 이하
M은 1이상, 10이하
2는 M이상 10 이하

1. 조합
- visit을 이용한 바이러스 별 인덱스 부여(y,x)값을 데이터, idx를 번호로 사용

2. bfs
- 바이러스의 조합을  찾으면 계산 시작
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.DelayQueue;

public class Main {
	static int n, m, two = 0; // m = depth
	static int able = 0;
	static int ans = Integer.MAX_VALUE;
	static Pair [] birus = new Pair[10];
	static int [][] board = new int[51][51];
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	
	public static void main(String argv[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] c_visit = new int[10];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
            	board[i][j] = Integer.parseInt(st.nextToken());
            	if(board[i][j] == 2) birus[two++] = new Pair(i, j);
            	if(board[i][j] != 1) able++;
            	
            }
        }
		if(n == 1) {
			System.out.println(0);
			return;
		}
        //System.out.println("two="+two);
        combination(0,c_visit,0);
        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
	}
	
	static void combination(int depth, int [] visit, int start) { // 바이러스의 조합을 구함
		if(depth == m) {
			int [] arr = new int[depth];
			int cnt = 0;
			for(int i = 0; i< two;i++) {
				if(visit[i] == 1) arr[cnt++] = i;
			}
			//pnt(arr);
			int result = bfs(arr);
			ans = Math.min(ans, result);
			return;
		}
		else {
			for(int i = start; i < two; i++) {
				visit[i] = 1;
				combination(depth+1, visit, i + 1);
				visit[i] = 0;
			}
		}
	}
	
	static int bfs(int [] arr) {
		Queue<Pair> q = new LinkedList<Pair>();
		int [][] visit = new int [n][n];
		int cnt = able;
		for(int i = 0; i < m; i++) {
			Pair temp = birus[arr[i]];
			q.add(temp);
			visit[temp.y][temp.x] = 1; 
			cnt--;
		}
		int max = 1;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int y = cur.y;
			int x = cur.x;
			for(int i = 0; i < 4; i++) {
				int ny = y +dy[i];
				int nx = x + dx[i];
				if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
				if(visit[ny][nx] == 0 && board[ny][nx] != 1) {
					q.add(new Pair(ny,nx));
					visit[ny][nx] = visit[y][x] + 1;
					max = Math.max(max, visit[ny][nx]);
					cnt--;
				}
			}
		}
		if(cnt == 0) {
			//pnt(visit);
			//System.out.println("=======================================");
			//System.out.println(max-1);
			return max-1;
		}
		else return Integer.MAX_VALUE;
	}
	
	static void pnt(int [] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	static void pnt(int [][] arr) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}


class Pair{
	int y,x;
	public Pair() {
		super();
	}
	public Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}
