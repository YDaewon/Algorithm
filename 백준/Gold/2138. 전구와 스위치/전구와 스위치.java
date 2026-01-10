import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char [] even = br.readLine().toCharArray();
        char [] odd = Arrays.copyOf(even, n);
        char [] end = br.readLine().toCharArray();

        int even_cnt = 1;
        int odd_cnt = 0;

        even[0] = (even[0] == '1') ? '0' : '1';
        even[1] = (even[1] == '1') ? '0' : '1';

        for (int i = 0; i < n-1; i++) {
            if(even[i] != end[i]) {
                even[i] = (even[i] == '1') ? '0' : '1';
                even[i+1] = (even[i+1] == '1') ? '0' : '1';
                if(i < n-2) even[i+2] = (even[i+2] == '1') ? '0' : '1';
                even_cnt++;
            }
            if(odd[i] != end[i]) {
                odd[i] = (odd[i] == '1') ? '0' : '1';
                odd[i+1] = (odd[i+1] == '1') ? '0' : '1';
                if(i < n-2) odd[i+2] = (odd[i+2] == '1') ? '0' : '1';
                odd_cnt++;
            }
        }

        boolean even_same = same(even, end);
        boolean odd_same = same(odd, end);

        if (even_same && odd_same) System.out.println(Math.min(even_cnt, odd_cnt));
        else if(even_same) System.out.println(even_cnt);
        else if (odd_same) System.out.println(odd_cnt);
        else System.out.println(-1);
    }

    static boolean same(char [] s, char [] e){
        for (int i = 0; i < s.length; i++) if(s[i] != e[i]) return false;
        return true;
    }
}