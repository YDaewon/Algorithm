import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {
    static Scanner sc = new Scanner(System.in);
    static int [] dy = {-1,1,0,0};
    static int [] dx ={0,0,-1,1};
    static int [][] board;
    static boolean [][] visit;
    static int n, m, ans, cnt, cost, max_cost;
    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int t = 1; t<= T; t++){
            init();
            sol();
            System.out.println("#" + t + " " + ans);
        }
    }

    static void init(){
        n = sc.nextInt();
        m = sc.nextInt();
        ans = 0;
        max_cost = 0;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
    }

    static void sol(){
        for (int k = 0; k <= n; k++) {
            int cost = k * k + (k+1) * (k+1);
            //System.out.println(cost);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visit = new boolean[n][n];
                    int c = 0;
                    cnt = 0;
                    for (int a = i - k; a <= i + k; a++) {
                        for (int b = j - c ; b <= j + c; b++) {
                            if (a < 0 || a >= n || b < 0 || b >= n) continue;
                            if (board[a][b] == 1) cnt++;
                        }
                        if (a < i) c++;
                        else c--;
                    }
                    if (cnt * m - cost >= 0 && ans < cnt) ans = cnt;
                }
            }
        }
    }

    static int get_cost(int k){
        return k* k + (k+1) * (k+1);
        //return (k * k) + ((k-1) * (k-1));
    }
}
