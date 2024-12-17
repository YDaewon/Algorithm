import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            if(K != 1){
                int [] alphabet = new int[27];
                for (int i = 0; i < W.length(); i++) {
                    alphabet[W.charAt(i) - 'a']++;
                }

                int min = 10001;
                int max = 0;
                for(int start = 0; start < W.length(); start++){
                    if(alphabet[W.charAt(start)-'a'] < K) continue;

                    int cnt = 1;
                    for (int end = start+1; end < W.length(); end++) {
                        if(W.charAt(start) == W.charAt(end)) cnt++;
                        if(cnt == K){
                            min = Math.min(min, end - start + 1);
                            max = Math.max(max, end-start+1);
                            //System.out.println("start: " + start + ", end" + end +", min: " + min + ", max: " + max);
                            break;
                        }
                    }
                }
                if(min == 10001) System.out.println("-1");
                else System.out.println(min + " " + max);
            }
            else System.out.println(1 + " " + 1);
        }
    }

}