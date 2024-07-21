import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2638 {
    static int [][] arr= new int[100][100];
    static int n, m, cnt = 0;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static void pnt() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    static void bfs(int y, int x) {
        int [][] visit = new int[100][100];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        visit[y][x] = 1;
        while(!q.isEmpty()) {
            Pair t = q.poll();
            int cy = t.y;
            int cx = t.x;
            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(arr[ny][nx] > 0) {
                    //System.out.println(cy + ", " + cx + ", up : " + ny + ", " + nx);
                    arr[ny][nx]++;
                }
                else if(visit[ny][nx] == 0 && arr[ny][nx] == 0) {
                    visit[ny][nx] = 1;
                    //System.out.println(arr[ny][nx]);
                    q.add(new Pair(ny,nx));
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]>2){
                    arr[i][j]=0;
                    cnt--;
                }
                else if(arr[i][j]==2) arr[i][j]=1;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int timer = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    cnt++;
                }
            }
        }
        int [][] v = new int[100][100];
        while(cnt > 0) {
            bfs(0,0);
            timer++;
        }
        System.out.println(timer);
    }


    static class Pair{
        int x, y;
        Pair(int y,int x){
            this.x = x;
            this.y = y;
        }
    }
}

