 import java.io.*;
import java.util.*;

public class Main {

    static int [][] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        alpha = new int[str.length()][26];
        alpha[0][str.charAt(0) - 'a'] = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j < 26; j++) {
                alpha[i][j] = alpha[i-1][j];
                if(j == (c - 'a')) alpha[i][j]++;
            }
        }

        int n = Integer.parseInt(br.readLine());

        // for(int i : alpha[0]) System.out.print(i + " ");
        // System.out.println();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = st.nextToken().charAt(0) - 'a';
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int start = (str.charAt(s) - 'a' == c) ? 1 : 0;
            sb.append(alpha[e][c] - alpha[s][c] + start + "\n");
        }
        System.out.println(sb);

    }   

}
