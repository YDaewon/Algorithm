 import java.io.*;
import java.util.*;

public class Main {
    static int w, h;

    static int [][] board;
    static boolean [][] visit;

    static int [] dy = {-1,-1,0,0,1,1};
    static int [] dx1 = {-1,0,-1,1,-1,0};
    static int [] dx2 = {0,1,-1,1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int [h + 2][w+2];
        visit = new boolean [h + 2][w + 2];
        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0));

        // for (int i = 0; i <= h + 1; i++) {
        //     if(i % 2 == 1) System.out.print(" ");
        //     for (int j = 0; j <= w + 1; j++) {
        //         System.out.print((visit[i][j] ? 1 : 0) + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("=============================================");
        // for (int i = 0; i <= h + 1; i++) {
        //     if(i % 2 == 1) System.out.print(" ");
        //     for (int j = 0; j <= w + 1; j++) {
        //         System.out.print((board[i][j]) + " ");
        //     }
        //     System.out.println();
        // }
    }

    static int bfs(int y, int x){
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] { y, x});
        visit[y][x] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int [] c = q.poll();
            for (int i = 0; i < 6; i++) {
                int ny = c[0] + dy[i];
                int nx = c[1];

                if(ny % 2 == 1)nx += dx1[i];
                else nx += dx2[i];

                if(ny < 0 || ny > h+1 || nx < 0 || nx > w+1) continue;

                if(board[ny][nx] == 1) cnt++;
                else if(!visit[ny][nx]){
                    q.add(new int [] {ny, nx});
                    visit[ny][nx] = true;
                }

            }
        }
        return cnt;
    }
}
