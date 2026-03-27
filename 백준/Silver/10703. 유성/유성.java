 import java.io.*;
import java.util.*;

public class Main {
    static int r, s;
    static char [][] pic;
    static boolean [][] visit;
    static int min_move;

    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        pic = new char [r][s];
        visit = new boolean[r][s];
        min_move = r;

        for (int i = 0; i < r; i++) {
            pic[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < s; i++) {
            int s = -1;
            int g = r;

            for(int y = 0; y < r; y++){
                if(pic[y][i] == 'X') s = y;
                else if(pic[y][i] == '#') {
                    g = y;
                    break;
                }
            }

            if(s != -1) min_move = Math.min(g - s - 1, min_move);
        }

        //make_meteor();

        // for(int i = 0; i < min_move; i++){
        //     down();
        //     pnt(pic);
        // }

        char [][] temp = new char[r][s];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if(pic[i][j] == '#') temp[i][j] = '#';
                else temp[i][j] = '.';
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if(pic[i][j] == 'X') temp[i + min_move][j] = 'X';
            }
        }
        pnt(temp);
    }

    static void make_meteor(){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if(!visit[i][j] && pic[i][j] == 'X'){
                    Queue<Pos> q = new LinkedList<>();
                    q.add(new Pos(i, j));
                    visit[i][j] = true;
                    while(!q.isEmpty()){
                        Pos p = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int y = p.y + dy[k];
                            int x = p.x + dx[k];

                            if(y < 0 || y >= r || x < 0 || x >= s) continue;

                            if(!visit[y][x] && pic[y][x] == 'X'){
                                q.add(new Pos(y, x));
                                visit[y][x] = true;
                            }
                        }
                    }
                }
            }
        }
    }

    static void down(){
        for (int i = 0; i < s; i++) {
            int s = 0;

            while(s < r && !visit[s][i]) s++;
            
            if(s >= r) continue;

            int e = s;

            while(e < r && visit[e][i]) e++;

            if(e >= r) break; 

            visit[e][i] = true;
            pic[e][i] = 'X';
            
            visit[s][i] = false;
            pic[s][i] = '.';
        }
    }

    static boolean check(){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if(visit[i][j]){
                    for (int d = 0; d < 4; d++) {
                        int y = i + dy[d];
                        int x = j + dx[d];

                        if(y < 0 || x < 0 || x >= s) continue;

                        if(y >= r) return false;
                        if(d == 1 && pic[y][x] == '#') return false;
                    }
                }
            }
        }
        return true;
    }

    static void pnt(char [][] p){
        //  System.out.println("=================================");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                sb.append(p[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Pos{
        int y;
        int x;
        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
