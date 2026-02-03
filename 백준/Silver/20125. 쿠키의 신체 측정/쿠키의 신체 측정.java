import java.io.*;
import java.util.*;


public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] answer = new int [5];
        int [][] board = new int [n][n];

        for (int i = 0; i < n; i++) {
            String t = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = t.charAt(j) == '*' ? 1 : 0;
            }
        }

        int [] heart = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1){
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                       int ny = i + dy[k];
                       int nx = j + dx[k];
                       if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                       if(board[ny][nx] != 1) break;
                       cnt++;
                    }
                    //System.out.println(i + ", " + j + ", cnt: " + cnt);
                    if(cnt == 4){
                        heart[0] = i;
                        heart[1] = j;
                        break;
                    }
                }
            }
        }
        System.out.println((heart[0]+1) + " " + (heart[1]+1));
        int py = heart[0];
        int px = heart[1] - 1;
        while(px >= 0){
            if(board[py][px--] != 1) break;
            answer[0]++;
        }
        px = heart[1] + 1;
        while(px < n){
            if(board[py][px++] != 1) break;
            answer[1]++;
        }

        px = heart[1];
        while(++py < n){
            if(board[py][px] != 1) break;
            answer[2]++;
        }
        // leg_start_y
        int leg_start_y = py;
        px--; // left_leg
        while(py < n){
            if(board[py++][px] != 1) break;
            answer[3]++;
        }
        py = leg_start_y;
        px+=2;
        while(py < n){
            if(board[py++][px] != 1) break;
            answer[4]++;
        }

        for (int t : answer) System.out.print(t + " ");
    }

}
