package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109 {
    static int n; 
    static String d;
    static int[][] map, result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException{
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	init();
            sol(t);
        }
    }

    static void init() throws IOException {
    	st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	d = st.nextToken();
        map = new int[n][n];
        result = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void sol(int t) {
        switch (d.charAt(0)) {
            case 'l': goLeft(); break;
            case 'r': goRight(); break;
            case 'u': goUp(); break;
            case 'd': goDown(); break;
        }
        System.out.println("#"+t);
        print();
    }

    static void print() {
    	for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void goRight() {
    	//System.out.println("Right!!");
        for (int y = 0; y < n; y++) {
            for (int x = n-1; x > 0; x--) {  // 각 줄마다 한칸씩 조회하면서 같은 블록 찾기
            	int nx = x-1;  // end포인터 선언
            	while(nx > 0) {   // 끝까지 가면 종료
            		if(map[y][nx] != 0) break;   // 0이 아닌 다른 블록을 만날 때 까지 포인터 옮기기
            		nx--;
            	}
                if (map[y][x] == map[y][nx]) { // x와 nx자리의 숫자가 똑같으면
                    map[y][x] *= 2;   // 합해주고
                    map[y][nx] = 0;   // end 포인터를 0으로 변경
                }
            }
            int idx = n - 1;
			for (int x = idx; x >= 0; x--) {   // 민 방향으로 줄세우기
				if (map[y][x] != 0) result[y][idx--] = map[y][x]; // 위 for문에서 map에 숫자들이 합쳐짐
			}                                                      // 0이 아니면 넣고 한칸 뒤로 idx 옮기기
        }
    }
    
    static void goLeft() {
    	//System.out.println("Left!!");
    	for (int y = 0; y < n; y++) {
            for (int x = 0; x < n-1; x++) {
            	int nx = x+1;
            	while(nx < n-1) {
            		if(map[y][nx] != 0) break;
            		nx++;
            	}
                if (map[y][x] == map[y][nx]) {
                    map[y][x] *= 2;
                    map[y][nx] = 0;
                }
            }
            int idx = 0;
			for (int x = idx; x < n; x++) {
				if (map[y][x] != 0) result[y][idx++] = map[y][x];
			}
        }
    }

    static void goDown() {
    	//System.out.println("Down!!");
        for (int x = 0; x < n; x++) {
            for (int y = n-1; y > 0; y--) {
            	int ny = y-1;
            	while(ny > 0) {
            		if(map[ny][x] != 0) break;
            		ny--;
            	}
                if (map[y][x] == map[ny][x]) {
                    map[y][x] *= 2;
                    map[ny][x] = 0;
                }
            }
            int idx = n - 1;
			for (int y = idx; y >= 0; y--) {
				if (map[y][x] != 0) result[idx--][x] = map[y][x];
			}
        }
    }
    
    static void goUp() {
    	//System.out.println("Up!!");
        for (int x = 0; x < n; x++) {
        	for (int y = 0; y < n - 1; y++) {
				int ny = y + 1;
				while(ny < n-1) {
            		if(map[ny][x] != 0) break;
            		ny++;
            	}
				if (map[y][x] == map[ny][x]) {
	                map[y][x] *= 2;
	                map[ny][x] = 0;
	            }
			}
            int idx = 0;
			for (int y = idx; y < n; y++) {
				if (map[y][x] != 0) result[idx++][x] = map[y][x];
			}
        }
    }

}