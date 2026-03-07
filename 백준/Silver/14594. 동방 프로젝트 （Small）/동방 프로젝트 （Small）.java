 import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [] wall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        wall = new int [n+1]; // i번 위치 오른쪽 벽(i ~ i+1 사이 벽), 1 = 벽이 있는 상태
        Arrays.fill(wall, 1);
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = a; j < b; j++) wall[j] = 0;


            // for (int j = 1; j < n; j++) {
            //     System.out.print(wall[j] + " ");
            // }
            // System.out.println();
        }

        int cnt = 1;
        for (int i = 1; i < n; i++) {
            cnt += wall[i];
        }

        System.out.println(cnt);
        
    }   

}
