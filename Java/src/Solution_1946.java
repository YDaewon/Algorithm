import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1946 {
    public static void main(String[] args) throws IOException {
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
            Arrays.sort(em); // codingtest을 기준으로 정렬
            //for (int i = 0; i < n; i++) System.out.println(em[i].codingtest + " " + em[i].interview);
            int ans = 1; // 코테 1등은 무조건 합격임
            int t = 0; // 그래서 1등의 면접 등수를 초기값으로 설정
            for (int i = 1; i < n; i++) {
                if(em[t].interview > em[i].interview){ // 코테를 더 잘본놈이 면접을 더 잘하면 떨어짐
                    t = i; // 면접 등수가 더 높다면 t를 갱신(이제 이사람보다 더 높아야함)
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
