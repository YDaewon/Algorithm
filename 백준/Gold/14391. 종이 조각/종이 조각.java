 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [][] board;
    static boolean [][] visit;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        go(0,0);

        System.out.println(ans);
    }

    static void go(int y, int x){
        if(x >= m){
            y++;
            x = 0;
        }
        
        if(y >= n){
            ans = Math.max(ans, calc());
            return;
        }
        
        visit[y][x] = true;
        go(y, x+1);
        visit[y][x] = false;
        go(y, x+1);
    }


    static int calc(){
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j]){ // 가로
                    int num = board[i][j];
                    int t = j+1;
                    while(t < m && visit[i][t]){
                        num *= 10;
                        num += board[i][t];
                        t++;
                    }
                    j = t - 1;
                    //System.out.print(", plus " + num);
                    total += num;
                }
            }
        }

        for (int j = 0; j < m; j++)  {
            for (int i = 0; i < n; i++) {
                if(!visit[i][j]){ // 세로
                    int num = board[i][j];
                    int t = i+1;
                    while(t < n && !visit[t][j]){
                        num *= 10;
                        num += board[t][j];
                        t++;
                    }
                    i = t - 1;
                    //System.out.print(", plus " + num);
                    total += num;
                }
            }
        }
        //System.out.println(", total: " + total);
        return total;
    }
}
