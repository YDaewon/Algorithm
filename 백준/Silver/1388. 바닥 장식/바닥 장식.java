import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char [][] wood;
    static boolean [][] visit;
    static int n,m,ans;

    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ans = 0;
        sc.nextLine();
        wood = new char[n][];
        for (int i = 0; i < n; i++) {
            wood[i] = sc.nextLine().toCharArray();
        }
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j]){
                    bfs(i,j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static void bfs(int y, int x){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        visit[y][x] = true;
        while(!q.isEmpty()){
            int [] p = q.poll();
            int t = wood[y][x] == '-' ? 2 : 0;
            for (int i = t; i < t+2; i++) {
                int ny = p[0]+dy[i];
                int nx = p[1]+ dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(!visit[ny][nx] && wood[ny][nx] == wood[y][x]){
                    visit[ny][nx] = true;
                    q.offer(new int [] {ny,nx});
                }
            }
        }
    }
}
