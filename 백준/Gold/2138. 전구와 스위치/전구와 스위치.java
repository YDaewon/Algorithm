 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        char [] s1 = br.readLine().toCharArray();
        char [] s2 = Arrays.copyOf(s1, n);
        char [] end = br.readLine().toCharArray();

        int s1_cnt = 1;
        int s2_cnt = 0;

        s1[0] = s1[0] == '0' ? '1' : '0';
        s1[1] = s1[1] == '0' ? '1' : '0';

        for (int i = 1; i < n; i++) {
            if(s1[i-1] != end[i-1]){
                go(s1, i);
                s1_cnt++;
            }

            if(s2[i-1] != end[i-1]){
                go(s2, i);
                s2_cnt++;
            }
        }
        // for(char c : s1) System.out.print(c);
        // System.out.println();
        // for(char c : s2) System.out.print(c);
        // System.out.println();
        boolean s1True = isTrue(s1, end);
        boolean s2True = isTrue(s2, end);
        
        if(s1True && s2True) System.out.println(Math.min(s1_cnt, s2_cnt));
        else if(s1True) System.out.println(s1_cnt);
        else if(s2True) System.out.println(s2_cnt);
        else System.out.println(-1);

    } 

    static void go(char[] s, int idx) {
    for (int i = idx - 1; i <= idx + 1; i++) {
        if (i >= 0 && i < n) {
            s[i] = (s[i] == '0') ? '1' : '0';
        }
    }
}

    static boolean isTrue(char [] a, char [] b){
        for(int i = 0; i < n; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }

}
