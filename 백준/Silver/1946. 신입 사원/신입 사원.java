import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            int n = Integer.parseInt(br.readLine());
            employee [] em = new employee[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                em[i] = new employee(a, b);
            }
            Arrays.sort(em);
            //for (int i = 0; i < n; i++) System.out.println(em[i].codingtest + " " + em[i].interview);
            int ans = 1;
            int t = 0;
            for (int i = 1; i < n; i++) {
                if(em[t].interview > em[i].interview){
                    t = i;
                    ans++;
                }
            }
            System.out.println(ans);
        }

    }

    static class employee implements Comparable<employee> {
        int codingtest;
        int interview;
        employee(int f, int s) {
            codingtest = f;
            interview = s;
        }


        @Override
        public int compareTo(employee o) {
            if (this.codingtest > o.codingtest) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
