import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int r, c, s, w;
	static char [][] map;
	static boolean [][] visit;
	
	static int [] dy = {1,-1,0,0};
	static int [] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char [r][c];
		visit = new boolean[r][c];
		for(int i = 0 ; i < r ; i++) {
			String t = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j] == 'o') s++;
				else if(map[i][j] =='v') w++;
			}
		}
		for(int i = 0 ; i < r ; i++) {
			for(int j = 0; j < c; j++) {
				if(!visit[i][j] && map[i][j] != '#') {
					bfs(i, j);
				}
				
			}
		}
		System.out.println(s + " " + w);
	}
	
	static void bfs(int y, int x) {
		Queue<int [] > q = new LinkedList<>();
		int ns=0, nw=0;
		q.offer(new int [] {y, x});
		visit[y][x] = true;
		while(!q.isEmpty()) {
			int [] n = q.poll();
			if(map[n[0]][n[1]] == 'v') nw++;
			if(map[n[0]][n[1]] == 'o') ns++;
			for(int i = 0; i < 4; i++) {
				int ny = n[0]+dy[i];
				int nx = n[1] + dx[i];
				if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if(!visit[ny][nx] && map[ny][nx] != '#') {
					q.offer(new int[] {ny,nx});
					visit[ny][nx] = true;
				}
			}
		}
		if(ns <= nw) {
			s -= ns;
		}
		else {
			w -= nw;
		}
	}
}
