import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] people = new int [2][n];
        int [] grade = new int [n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[0][i] = Integer.parseInt(st.nextToken());
            people[1][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(people[0][i] < people[0][j] && people[1][i] < people[1][j]) cnt++;
            }
            grade[i] = cnt;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(grade[i] + " ");
        }

    }

}
