import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] word = new int[26];

        int n = Integer.parseInt(br.readLine());
        char [] start = br.readLine().toCharArray();
        for (int i = 0; i < start.length; i++) {
            word[start[i] - 'A']++;
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            char [] t = br.readLine().toCharArray();
            int [] temp = Arrays.copyOf(word, 26);
            for (int j = 0; j < t.length; j++) {
                temp[t[j]-'A']--;
            }
            int remain = 0;
            for (int c : temp) {
                remain += Math.abs(c);
            }
            // System.out.println(new String(t) +"'s remain count: " + remain);

            if(t.length == start.length){
                remain--;
            }
            if(remain <= 1) {
                cnt++;
            }

        }

        System.out.println(cnt);
    }

}
