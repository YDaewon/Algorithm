import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static int n, ans, ans_idx;
    static int [][] arr;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int t = 1; t<= T; t++){
            init();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sol(i,j,1,arr[i][j]);
                }
            }
            System.out.println("#" + t + " " +ans_idx + " " + ans);
        }
    }

    static void init(){
        n = sc.nextInt();
        ans = 0;
        ans_idx = 0;
        arr = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static void sol(int y, int x, int d, int val){
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
            if(arr[y][x] + 1 == arr[ny][nx]){
                flag = false;
                sol(ny, nx, d+1, val);
            }
        }
        if(flag){
            if(ans < d){
                ans = d;
                ans_idx = val;
            }
            else if(ans == d && val < ans_idx){
                ans = d;
                ans_idx = val;
            }            
        }
        
    }
}
