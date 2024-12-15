import java.io.*;

public class Main {
    static int n;
    static char [] ball;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ball = br.readLine().toCharArray();
        System.out.println(Math.min(calc('R'), calc('B')));
    }

    static int calc(char mv_color){
        int sort_left = 0;
        int sort_right = 0;

        int mv_ball = 0;
        for (int i = n-1; i >= 0; i--) {
            if(ball[i] != mv_color) mv_ball++;
            else{
                sort_right += mv_ball;
                mv_ball = 0;
            }
        }

        mv_ball = 0;
        for (int i = 0; i < n; i++) {
            if(ball[i] != mv_color) mv_ball++;
            else{
                sort_left += mv_ball;
                mv_ball = 0;
            }
        }

        return Math.min(sort_left, sort_right);
    }
}