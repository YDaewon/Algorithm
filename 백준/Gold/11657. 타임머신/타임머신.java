import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 99999999);
            map[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            map[s][e] = Math.min(c, map[s][e]);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][k] == 99999999 || map[k][j] == 99999999) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        if(check()) System.out.println(-1);
        else {
            for (int i = 1; i < n; i++) System.out.println((map[0][i] == 99999999) ? -1 : map[0][i]);
        }
    }

    static boolean check(){
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (map[0][i] != 99999999) {
                flag = false;
                break;
            }
        }
        if(flag) return false;

        for (int i = 0; i < n; i++) {
            if (map[i][i] < 0) return true;
        }
        return false;
    }
    
}
