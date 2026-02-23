 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] inequal; // 0: <   1: >
    static boolean [] visit;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inequal = new int [n];
        
        visit = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            char c = st.nextToken().toCharArray()[0];
            if(c == '<') inequal[i] = 0;
            else inequal[i] = 1;
        }

        for (int i = 0; i <= 9; i++) {
            visit[i] = true;
            calc(0, String.valueOf(i));
            visit[i] = false;
        }


        System.out.printf("%0" + (n+1) + "d\n", max);
        System.out.printf("%0" + (n+1) + "d\n", min);
    }

    static void calc(int d, String num){
        if(d == n){
            long t = Long.parseLong(num);
            max = Math.max(max, t);
            min = Math.min(min, t);
            return;
        }

        int e = num.charAt(d) - '0';
        if(inequal[d] == 0){
            for (int i = e + 1; i <= 9; i++) {
                if(visit[i]) continue;
                visit[i] = true;
                calc(d + 1, num + String.valueOf(i));
                visit[i] = false;
            }
        }
        else{
            for (int i = e - 1; i >= 0; i--) {
                if(visit[i]) continue;
                visit[i] = true;
                calc(d + 1, num + String.valueOf(i));
                visit[i] = false;
            }
        }

    }

}
