import java.io.*;
import java.util.*;


public class Main {
    static int N, M, L, K;
    static int [][] board;
    static List<Pos> stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 좌표 가로
        M = Integer.parseInt(st.nextToken()); // 좌표 세로
        L = Integer.parseInt(st.nextToken()); // 트램펄린 길이
        K = Integer.parseInt(st.nextToken()); // 별똥별 수
        stars = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new Pos(y, x));
        }

        int answer = Integer.MAX_VALUE;

        for(Pos a : stars){
            for(Pos b : stars){
                int y0 = a.y;
                int x0 = b.x;

                answer = Math.min(K - simulation(y0, x0), answer);
            }
        }
        System.out.println(answer);
    }

    static int simulation(int y, int x){
        int cnt = 0;
        for(Pos p : stars){
            if(p.y >= y && p.y <= y + L && p.x >= x && p.x <= x + L) cnt++;
        }
        return cnt;
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
