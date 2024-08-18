import java.util.Arrays;
import java.util.Scanner;

public class Solution_2112 {
    static boolean [][] film, init_film;
    static int d, w, k;
    static int ans;
    static boolean [] select;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int test = 1; test <= T; test++){
            init();
            if(check()){
                System.out.println("#" + test + " " + 0);
                continue;
            }
            subset(0);
            System.out.println("#" + test + " " + ans);
        }
    }

    static void init(){
        d = sc.nextInt();
        w = sc.nextInt();
        k = sc.nextInt();
        film = new boolean[d][w];
        init_film = new boolean[d][w];
        ans = Integer.MAX_VALUE;
        select = new boolean [d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < w; j++) {
                init_film[i][j] = film[i][j] = (sc.nextInt() == 1) ? true : false;
            }
        }
    }

    static void subset(int D){
        if(d == D){
            dfs(select, 0,0);
            rollback();
            return;
        }
        select[D] = true;
        subset(D+1);
        select[D] = false;
        subset(D+1);
    }

    static void dfs(boolean [] arr, int cnt, int idx){
        if(cnt >= ans) return;
        if(idx == d){
            if(check()) {
                ans = Math.min(ans, cnt);
            }
            return;
        }
        if(arr[idx]){
            Arrays.fill(film[idx], false);
            dfs(arr, cnt+1, idx+1);

            Arrays.fill(film[idx], true);
            dfs(arr, cnt+1, idx+1);
        }
        else{
            dfs(arr, cnt, idx+1);
        }
    }

    static boolean check(){
        for (int i = 0; i < w; i++) {
            int cnt = 1;
            boolean temp = film[0][i];
            boolean flag = false;
            for (int j = 1; j < d; j++) {
                if(film[j][i] == temp){
                    cnt++;
                }
                else{
                    temp = film[j][i];
                    cnt = 1;
                }
                if(cnt == k){
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }

    static void rollback(){
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < w; j++) {
                film[i][j] = init_film[i][j];
            }
        }
    }
}
