package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1941 {
	static int [] dy = {-1,1,0,0};
	static int [] dx = {0,0,-1,1};
	static char [][] map = new char[5][];
	static boolean [] visit;
	static int [] check;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 5; i++) map[i] = sc.nextLine().toCharArray();
		ans = 0;
		check = new int[7];
		combi(0,0,0);
		System.out.println(ans);
	}
	
	static void combi(int d, int now, int cnt) {
		if(d == 7) {
			if(cnt >= 4) {
				visit = new boolean[7];
				bfs(check[0] / 5, check[0] % 5);		
			}
			return;
		}
		for(int i = now; i < 25; i++) {
			int r = i / 5;
			int c = i % 5;
			check[d] = i;
			combi(d+1, i+1, cnt + (map[r][c] == 'S' ? 1 : 0));
		}
	}
	
	static void bfs(int i, int j) {
		int cnt = 0;
		Queue<int[]> q =new LinkedList<>();
		q.offer(new int [] {i, j});
		visit[0] = true;
		while(!q.isEmpty()) {
			int [] p = q.poll();
			for(int d = 0; d < 4; d++) {
				int ny = p[0] + dy[d];
				int nx = p[1] + dx[d];
				if(ny >= 5 || ny < 0 || nx >= 5 || nx < 0) continue;
				int nxt_visit = ny*5 + nx;
				for(int k = 1; k< 7; k++) {
					if(!visit[k] && check[k] == nxt_visit) {
						visit[k] = true;
						q.offer(new int [] {ny,nx});
					}
				}
			}
			cnt++;
		}
		if(cnt == 7) {
			ans++;
		}
	}
}
