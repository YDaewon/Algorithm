 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] x;
    static int [] s;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = new int [17]; // 0 ~ 16 val: 카운트
        s = new int [2*n];
        Arrays.fill(s, -1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            x[num]++; 
        }

        go(0);
        if(!flag) System.out.println(-1);
    } 

    static void go(int d){
        if(flag) return;
        if(d == 2 * n){
            for(int i : s){
                System.out.print(i + " ");
            }
            System.out.println();
            flag = true;
            return;
        }
        if(s[d] != -1) {
            go(d+1);
            return;
        }
        
        for(int i = 0; i < 17; i++){
            if(x[i] != 0 && (d + i + 1) < 2 * n && s[d+i + 1] == -1){
                s[d] = i;
                s[d + i + 1] = i;
                x[i] = 0;
                go(d+1);
                s[d] = -1;
                s[d + i + 1] = -1;
                x[i] = 1;
            }
        }
    }
}
