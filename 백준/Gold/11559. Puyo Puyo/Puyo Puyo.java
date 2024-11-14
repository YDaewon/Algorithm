import java.util.*;

public class Main {
    static char [][] map;
    static boolean[][] visit;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String t = sc.nextLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = t.charAt(j);
            }
        }

        while(true){
            visit = new boolean[12][6];
            boolean puyo_check = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(map[i][j] != '.' && !visit[i][j]){
                        if(bfs(i, j)) puyo_check = true;
                    }
                }
            }
            if(!puyo_check) break;
            else{
                ans++;
                down();
            }
            //pnt();
            //System.out.println("=============================");
        }
        System.out.println(ans);
    }

    static void pnt(){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean bfs(int y, int x){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] { y, x});
        visit[y][x] = true;
        int cnt = 0;
        List<int []> list = new ArrayList<>();
        while(!q.isEmpty()){
            int [] n = q.poll();
            list.add(n);
            cnt++;
            for (int i = 0; i < 4; i++) {
                int ny = n[0] + dy[i];
                int nx = n[1] + dx[i];
                if(ny < 0 || ny > 11 || nx < 0 || nx > 5) continue;
                if(!visit[ny][nx] && map[y][x] == map[ny][nx]){
                    visit[ny][nx] = true;
                    q.offer(new int [] { ny, nx});
                }
            }
        }
        //System.out.println(cnt + " " + map[y][x]);
        if(cnt >= 4){
            for(int [] p : list){
                map[p[0]][p[1]] = '.';
            }
            return true;
        }
        return false;
    }

    static void down(){
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if(map[j][i] == '.'){
                    for (int k = j-1; k >= 0; k--) {
                       if(map[k][i] != '.'){
                           map[j][i] = map[k][i];
                           map[k][i] = '.';
                           break;
                       }
                    }
                }
            }
        }
    }
}

