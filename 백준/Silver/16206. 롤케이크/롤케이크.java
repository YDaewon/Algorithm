import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    static Integer [] cake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cake = new Integer [n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cake[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cake, (a, b) -> {
            if((a % 10) != (b % 10)) return (a % 10) > (b % 10) ? 1 : -1; 
            else return a > b ? 1 : -1; 
        });
        int idx = 0;
        int cnt = 0;
        while(idx >= 0 && idx < n){
            if(cake[idx] > 10 && m > 0){
                int t = 0;
                if(cake[idx] % 10 == 0) t = Math.min(m, (cake[idx] / 10) - 1);
                else t = Math.min(m, (cake[idx] / 10));
                m -= t;
                cake[idx] -= t * 10;
                cnt += t;
            }
            else if(cake[idx] == 10){
                cnt++;
                cake[idx] = 0;
            }
            else{
                idx++;
            }
        }
        System.out.println(cnt);
    }
    
}
