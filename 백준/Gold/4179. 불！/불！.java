import java.io.*;
import java.util.*;


public class Main {
    static int r, c;
    static int [] dy = {1,-1,0,0};
    static int [] dx = {0,0,-1,1};
    static int [][] graph;
    static List<int []> fires;
    static int [][] fire_map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        graph = new int [r][c];
        fire_map = new int [r][c];
        boolean [][] visit = new boolean[r][c];
        Queue<int []> q = new LinkedList<>();
        fires = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                char n = temp.charAt(j);
                if(n == '#'){
                    graph[i][j] = -1;
                }
                else if(n == 'J'){
                    graph[i][j] = 1;
                    q.add(new int[] {i, j, 0});
                    visit[i][j] = true;
                }
                else if(n == 'F'){
                    graph[i][j] = 2;
                    fires.add(new int [] {i,j});
                }
            }
        }

        makeBurn();

        while(!q.isEmpty()){
            int [] cur = q.poll();

            if(cur[0] == 0 || cur[0] == r - 1 || cur[1] == 0 || cur[1] == c - 1) {
                answer = Math.min(answer, cur[2] + 1);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny < 0 || ny > r-1 || nx < 0 || nx > c-1) continue;
                if(graph[ny][nx] == 0 && !visit[ny][nx] && cur[2] + 1 < fire_map[ny][nx]){
                    q.add(new int [] {ny,nx, cur[2] + 1});
                    visit[ny][nx] = true;
                }
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);

    }


    static void makeBurn(){
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                fire_map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int [] fire : fires){
            q.add(new int [] {fire[0], fire[1], 0});
            fire_map[fire[0]][fire[1]] = 0;
        }

        while(!q.isEmpty()){
            int [] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                int time = cur[2] + 1;
                if(ny < 0 || ny > r-1 || nx < 0 || nx > c-1) continue;
                if(graph[ny][nx] != -1 && time < fire_map[ny][nx]){
                    q.add(new int [] {ny,nx, time});
                    fire_map[ny][nx] = time;
                }
            }
        }
    }
}
/*
    1
  1 1 1
1 1 1 1 1
  1 1 1
    1
 */