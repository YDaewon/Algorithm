import java.util.Scanner;

public class Solution_3282 {
    static Scanner sc = new Scanner(System.in);
    static int [][] dp;
    static int [][] product;
    static int n, k;

    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            init();
            sol(i);
        }
    }
    static void init(){
        n = sc.nextInt();
        k = sc.nextInt();
        dp = new int[k+1][n+1];
        product = new int [n+1][2];
        for (int i = 1; i <= n; i++) {
            product[i][0] = sc.nextInt(); // v
            product[i][1] = sc.nextInt(); // c
        }
    }
    static void sol(int T){
        for (int v = 1; v <= k; v++) {
            for (int i = 1; i <= n; i++) {
                if(v>= product[i][0]) dp[v][i] = Math.max(dp[v][i-1], dp[v-product[i][0]][i-1] + product[i][1]);
                else dp[v][i] = dp[v][i-1];
            }
        }
        System.out.println("#"+T+" "+dp[k][n]);
    }
}
