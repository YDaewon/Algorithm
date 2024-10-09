import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char [] car = {'^', 'v', '<', '>'};
    static String str;
    static int y, x, n, now_y, now_x, d;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	init();
        	sol();
        	System.out.print("#" + t + " ");
            for(int i = 0; i < y; i++) {
                for(int j = 0; j < x; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
    
    static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        map = new char[y][x];
        for(int i = 0; i < y; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < x; j++) {
                map[i][j] = input[j];
                for(int k = 0; k<4; k++){
                    if(input[j] == car[k]){
                        now_y = i; now_x = j;
                        d = k;
                        break;
                    }
                }
            }
        }
        
        n = Integer.parseInt(br.readLine());
        str = br.readLine();
    }
    
    static void move(char dir) {
    	d = 0;
    	if(dir == 'D') d = 1;
    	if(dir == 'L') d = 2;
    	if(dir == 'R') d = 3;
    	
    	map[now_y][now_x] = car[d];
    	int ny = now_y + dy[d];
    	int nx = now_x + dx[d];
    	if(ny < 0 || ny >= y || nx < 0 || nx >= x) {
            return;
        }
    	if(map[ny][nx] == '.') {
    		map[ny][nx] = car[d];
    		map[now_y][now_x] = '.';
    		now_y = ny;
    		now_x = nx;
    	}
    }
    
    static void shoot() {
    	int ny = now_y + dy[d], nx = now_x + dx[d];
    	while(ny >= 0 && ny < y && nx >= 0 && nx < x) {
            if(map[ny][nx] == '#') {
                break;
            }
            else if(map[ny][nx] == '*') {
            	map[ny][nx] = '.';
                break;
            }
            ny += dy[d];
            nx += dx[d];
        }
    }
    
    static void sol() {
    	for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c != 'S') move(c);
            else shoot();
        }
    }
}
