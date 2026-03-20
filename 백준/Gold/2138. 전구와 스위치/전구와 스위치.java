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
        char [] e = br.readLine().toCharArray();

        int s1_cnt = 0;
        int s2_cnt = 1;

        s2[0] = (s2[0] == '0') ? '1' : '0';
        s2[1] = (s2[1] == '0') ? '1' : '0';


        for (int i = 0; i < n-1; i++) {
            if(s1[i] != e[i]) {
                calc(s1, i);
                s1_cnt++;
            }
            if(s2[i] != e[i]) {
                calc(s2, i);   
                s2_cnt++;
            } 
        }
        
        int answer = Integer.MAX_VALUE;
        if(isSame(s1, e)) answer = Math.min(answer, s1_cnt);
        if(isSame(s2, e)) answer = Math.min(answer, s2_cnt);

        System.out.println((answer == Integer.MAX_VALUE ? -1 : answer));
    } 

    static void calc(char [] c, int i){
        c[i] = (c[i] == '0') ? '1' : '0';
        if(i + 1 < n) c[i+1] = (c[i+1] == '0') ? '1' : '0';
        if(i + 2 < n) c[i+2] = (c[i+2] == '0') ? '1' : '0';
    }

    static boolean isSame(char [] a, char [] b){
        for (int i = 0; i < n; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }

}
