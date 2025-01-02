import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int [][] board;
    static boolean [][] visit;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int [N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while(true){
            visit = new boolean[N][N];
            boolean flag= true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visit[i][j]){
                        if(bfs(i,j)){
                            flag = false;
                        }
                    }
                }
            }

            if(flag) break;
            ans++;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j <N; j++) {
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("========================");
        }
        System.out.println(ans);
    }

    static boolean bfs(int y, int x){
        int people = board[y][x];
        int cnt = 1;
        Queue<int []> q = new LinkedList<>();
        List<int []> list = new ArrayList<>();
        q.offer(new int [] {y,x});
        visit[y][x] = true;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(!visit[ny][nx]){
                    int temp = Math.abs(board[cur[0]][cur[1]] - board[ny][nx]);
                    if(temp >= L && temp <= R){
                        visit[ny][nx] = true;
                        people += board[ny][nx];
                        cnt++;
                        q.offer(new int [] {ny,nx});
                        list.add(new int []{ny,nx});
                    }
                }
            }
        }
        if(list.isEmpty()) return false;
        int avg = people / cnt;
        board[y][x] = avg;
        for(int [] idx : list){
            board[idx[0]][idx[1]] = avg;
        }
        return true;
    }

}