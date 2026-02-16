 import java.io.*;
import java.util.*;

public class Main {

    static Set<String> set;
    static int [] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            visit = new int[26];
            for (int j = 0; j < s.length(); j++) visit[s.charAt(j) - 'a']++;
            set = new TreeSet<>();
            permutation(s, "", 0, s.length());
            for(String t : set) sb.append(t + "\n");
        }
        System.out.println(sb);
    }

    static void permutation(String s, String e, int d, int h){
        if(d == h){
            set.add(e);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if(visit[i] != 0){
                visit[i]--;
                permutation(s, e + (char) (i + 'a'), d + 1, h);
                visit[i]++;
            }
        }
    }



}
