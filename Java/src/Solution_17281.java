import java.util.Scanner;

public class Solution_17281 {
    static int n, ans;
    static int [][] innings;
    static int [] batter, visit;
    static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        init();
        permutation(1);
        System.out.println(ans);
    }

    static void init(){
        n = sc.nextInt();
        ans = 0;
        batter = new int[10];
        visit = new int[10];
        innings = new int [n+1][10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                innings[i][j] = sc.nextInt();
            }
        }
    }

    static void permutation(int d){
        if(d == 10){
            batter[4] = 1;
            play_game();
            return;
        }
        for(int i = 2; i < 10; i++){
            if(visit[i] == 0){
                batter[d] = i;
                visit[i] = 1;
                if(d == 3) permutation(d+2);
                else permutation(d+1);
                visit[i] = 0;
            }
        }
    }

    static void play_game() {
        boolean [] base;
        int idx = 0;
        int score = 0;
        int val;
        for(int i = 1; i <= n; i++){
            int zero_cnt = 0;
            base = new boolean[4];  // home , 1base, 2base, 3base
            while(zero_cnt < 3){
                val = innings[i][batter[idx % 9 + 1]];
                if(val == 0) zero_cnt++;
                else if( val == 1){
                    for(int j = 3; j > 0; j--){
                        if(base[j]){
                            if(j == 3){
                                score++;
                                base[j] = false;
                            }
                            else{
                                base[j] = false;
                                base[j+1] = true;
                            }
                        }
                    }
                    base[1] = true;
                }
                else if( val == 2){
                    for(int j = 3; j > 0; j--) {
                        if (base[j]) {
                            if (j >= 2) {
                                score++;
                                base[j] = false;
                            } else {
                                base[j] = false;
                                base[j + 2] = true;
                            }
                        }
                    }
                    base[2] = true;
                }
                else if( val == 3){
                    for(int j = 3; j > 0; j--){
                        if(base[j]){
                            score++;
                            base[j] = false;
                        }
                    }
                    base[3] = true;
                }
                else {
                    for(int j = 3; j > 0; j--){
                        if(base[j]){
                            score++;
                            base[j] = false;
                        }
                    }
                    score++;
                }
                idx++;
            }
        }
        ans = Math.max(ans, score);
    }
}
