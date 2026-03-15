 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Pos start, end;

    static int [] dy = {-2,-2,0,0,2,2};
    static int [] dx = {-1,1,-2,2,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        end = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), 0);

        Queue<Pos> q = new LinkedList<>();
        boolean [][] visit = new boolean [n][n];
        
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            if(cur.y == end.y && cur.x == end.x){
                System.out.println(cur.cost);
                return;
            }

            for(int i = 0; i < 6; i++){
                int y = cur.y + dy[i];
                int x = cur.x + dx[i];

                if(y >= n || y < 0 || x >=n || x < 0) continue;
                if(!visit[y][x]){
                    visit[y][x] = true;
                    q.add(new Pos(y,x,cur.cost+1));
                }
            }
        }

        System.out.println(-1);
    } 

    static class Pos{
        int y;
        int x;
        int cost;
        Pos(int y, int x, int cost){
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
