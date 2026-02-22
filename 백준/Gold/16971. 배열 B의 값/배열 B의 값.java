 import java.io.*;
import java.util.*;

public class Main {
    /*
    중앙에 있는 값이 많이 쓰임
    1 2 1
    2 4 2
    1 2 1

    1 2 2 1
    2 4 4 2
    1 2 2 1

    1 2 2 1
    2 4 4 2
    2 4 4 2
    1 2 2 1

    꼭짓점: 1
    외에 사이드들: 2
    나머지: 4
    
    */
    static int n, m;

    static int [][] board;
    static long [] row;
    static long [] col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
               board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        row = new long [n];
        col = new long [m];
        for (int i = 0; i < n; i++) {
            row[i] += board[i][0] + board[i][m-1];
            for (int j = 1; j < m-1; j++) {
                row[i] += board[i][j] * 2;
            }
        }
        
        for (int i = 0; i < m; i++) {
            col[i] += board[0][i] + board[n-1][i];
            for (int j = 1; j < n-1; j++) {
                col[i] += board[j][i] * 2;
            }
        }
        long sum = calc();
        long answer = sum;

        if(n > 2){
            long temp = row[1];
            for (int i = 2; i < n - 1; i++) {
                temp = Math.min(temp, row[i]);
            }
            answer = Math.max(answer, sum + row[0] - temp);
            answer = Math.max(answer, sum + row[n-1] - temp);
        }

        if(m > 2){
            long temp = col[1];
            for (int i = 2; i < m - 1; i++) {
            temp = Math.min(temp, col[i]);
            }
            answer = Math.max(answer, sum + col[0] - temp);
            answer = Math.max(answer, sum + col[m-1] - temp);
        }

        System.out.println(answer);

    }

    static long calc(){
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if((i == 0 && j == 0) || (i == 0 && j == m-1) || (i == n-1 && j == 0) || (i == n-1 && j == m-1)) sum += board[i][j];
                else if(i==0 || j == 0 || i == n-1 || j == m-1) sum += board[i][j] * 2;
                else sum += board[i][j]*4;
            }
        }

        return sum;
    }

}
