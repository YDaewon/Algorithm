import java.io.*;
import java.util.*;

public class Main {
    /*
    2: 이김, 1: 비김, 0: 짐

    처음은 a - b
    이긴사람과 안나온 나머지 1명

    내가 a

    res[0][1] = 0 => 0이 짐
    res[1][0] = 2 => 1이 이김
    */
    static int n, k;
    static int [][] res;
    static boolean [] visit;
    static int [] cnt = {0,0,0};
    static int [] score = {0,0,0};
    static int [][] card = new int [3][20];
    static boolean answer = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        res = new int [n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 20; j++) {
                card[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }
        calc(0, 0, 1);
        System.out.println((answer ? 1 : 0));
    }

    // card[l][cnt[l]++] l번 유저가 이번에 낼 카드
    static void calc(int d, int l, int r){
        if(end_check()) return;
        if(l == 0){
            for(int i = 0; i < n; i++){  // 내가 낼 손동작
                if(!visit[i]){
                    visit[i] = true;
                    int draw = draw(r);
                    if(draw == -1) continue;
                    cnt[r]++;
                    if(res[i][draw] == 2){
                        score[0]++;
                        calc(d+1, 0, (r == 1 ? 2 : 1));
                        score[0]--;
                    }
                    else if(res[i][draw] == 1){
                        score[r]++;
                        calc(d+1, r, (r == 1 ? 2 : 1));
                        score[r]--;
                    }
                    else{
                        score[r]++;
                        calc(d+1, r, (r == 1 ? 2 : 1));
                        score[r]--;
                    }
                    visit[i] = false;
                    cnt[r]--;
                }
            }
        }
        else if(r == 0){
            for(int i = 0; i < n; i++){  // 내가 낼 손동작
                if(!visit[i]){
                    visit[i] = true;
                    int draw = draw(l);
                    if(draw == -1) continue;
                    cnt[l]++;
                    if(res[draw][i] == 2){
                        score[l]++;
                        calc(d+1, l, (l == 1 ? 2 : 1));
                        score[l]--;
                    }
                    else if(res[draw][i] == 1){
                        score[l]++;
                        calc(d+1, l, (l == 1 ? 2 : 1));
                        score[l]--;
                    }
                    else{
                        score[0]++;
                        calc(d+1, 0, (l == 1 ? 2 : 1));
                        score[0]--;
                    }
                    visit[i] = false;
                    cnt[l]--;
                }
            }
        }
        else{
            int l_draw = draw(l);
            if(l_draw == -1) return;
            int r_draw = draw(r);
            if(r_draw == -1) return;
            cnt[l]++;
            cnt[r]++;
            if(res[l_draw][r_draw] == 2){
                score[l]++;
                calc(d+1, l, 0);
                score[l]--;
            }
            else if(res[l_draw][r_draw] == 1){
                int winner = Math.max(l, r);
                score[winner]++;
                calc(d+1, winner, 0);
                score[winner]--;
            }
            else{
                score[r]++;
                calc(d+1, r, 0);
                score[r]--;
            }
            cnt[l]--;
            cnt[r]--;
        }
    }

    static boolean end_check(){
        if (score[0] >= k) {
            answer = true;
            return true;
        }
        else if(score[1] >= k || score[2] >= k){
            return true;
        }
        return false;
    }

    static int draw(int user){
        if(cnt[user] >= 20) return -1;
        return card[user][cnt[user]];
    }
}
