import java.io.*;
import java.util.*;


public class Main {
    static int n, k, p, x, ans;
    static int[][] num = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9
    /*
        1
      0   2
        3
      4   6
        5
     0: 1110111
     1: 1000100
     2: 0111110
     3: 1101110
     4: 1001101
     5: 1101011
     6: 1111011
     7: 1000110
     8: 1111111
     9: 1101111
    */
    static int [] display;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ans = 0;
        int temp = x;
        display = new int [k+1];
        for(int i = k; i > 0; i--){
            display[i] = temp % 10;
            temp /= 10;
        }
        for (int i = 1; i <= n; i++) {
            sol(i);
        }
        System.out.println(ans);
    }

    static void sol(int val){
        int temp = val;
        int [] now = new int [k+1];
        for(int i = k; i > 0; i--){
            now[i] = val % 10;
            val /= 10;
        }

        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 7; j++) {
                if(num[now[i]][j] != num[display[i]][j]) cnt++;
                if(cnt > p) return;
            }
        }
        if(cnt != 0) {
            //System.out.println("able: " + temp);
            ans++;
        }
    }
}