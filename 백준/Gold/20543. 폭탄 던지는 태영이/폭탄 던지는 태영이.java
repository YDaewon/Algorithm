import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static long [][] map;
    static long [][] end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new long [n][n];
        end = new long [n][n];
        long [][] diff = new long [n+1][n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                end[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i > 0) diff[i][j] += diff[i-1][j];
                if(j > 0) diff[i][j] += diff[i][j-1];
                if(i > 0 && j > 0) diff[i][j] -= diff[i-1][j-1];

                long temp = end[i][j] + diff[i][j];
                if(temp < 0){
                    long cnt = Math.abs(temp);
                    map[i + m/2][j + m/2] = cnt;
                 
                    diff[i][j] += cnt;
                    diff[i + m][j] -= cnt;
                    diff[i][m + j] -= cnt;
                    diff[i+m][j+m] += cnt;
                }
            }
        }
        pnt();
    }

    static void pnt(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


}
