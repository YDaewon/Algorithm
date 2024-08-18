import java.util.Scanner;

public class Solution_4013 {
    static int [][] cog;
    static boolean [] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test = 1; test <= T; test++){
            int r = sc.nextInt();
            int sum = 0;
            cog = new int [4][8];
            for(int i = 0; i<4;i++){
                for(int j = 0; j < 8; j++){
                    cog[i][j] = sc.nextInt();
                }
            }
            while(r-- != 0){
                int n = sc.nextInt()-1;
                int d = sc.nextInt();
                visit = new boolean[4];
                round(n, d);
            }
            for (int i = 0; i < 4; i++) {
                sum += cog[i][0] == 1 ? (int) Math.pow(2, i) : 0;
            }
            System.out.println("#" + test + " " + sum);
        }
    }
    // 만나는 자리: 2, 6
    static void round(int n, int d){
        visit[n] = true;
        if(n != 3 && cog[n][2] != cog[n+1][6] && !visit[n+1]) {
            round(n+1,d > 0 ? -1 : 1);
        }
        if(n != 0 && cog[n][6] != cog[n-1][2] && !visit[n-1]) {
            round(n-1,d > 0 ? -1 : 1);
        }
        turn_cog(n, d);
    }

    static void turn_cog(int n, int d){
        int t;
        if(d == 1){
            t = cog[n][7];
            for(int i = 7; i > 0; i--){
                cog[n][i] = cog[n][i-1];
            }
            cog[n][0] = t;
        }
        else{
            t = cog[n][0];
            for(int i = 0; i < 7; i++){
                cog[n][i] = cog[n][i+1];
            }
            cog[n][7] = t;
        }
    }
}