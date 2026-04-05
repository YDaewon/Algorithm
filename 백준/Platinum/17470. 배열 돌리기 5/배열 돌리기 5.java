import java.io.*;
import java.util.*;

public class Main {
    static int n,m,r;
    
    static int num = 1;
    static int [][] board;
    static Group [][] groups =
    {
        {new Group(0), new Group(1)},
        {new Group(2), new Group(3)}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int [n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        while(r-- > 0){
            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1){
                Group temp = groups[0][0];
                groups[0][0] = groups[1][0];
                groups[1][0] = temp;

                temp = groups[0][1];
                groups[0][1] = groups[1][1];
                groups[1][1] = temp;

                groups[0][0].changeUpdown();
                groups[0][1].changeUpdown();
                groups[1][0].changeUpdown();
                groups[1][1].changeUpdown();
            }
            else if(cmd == 2){
                Group temp = groups[0][0];
                groups[0][0] = groups[0][1];
                groups[0][1] = temp;

                temp = groups[1][0];
                groups[1][0] = groups[1][1];
                groups[1][1] = temp;

                groups[0][0].changeLeftright();
                groups[0][1].changeLeftright();
                groups[1][0].changeLeftright();
                groups[1][1].changeLeftright();
            }
            else if(cmd == 3){
                Group temp = groups[0][0];
                groups[0][0] = groups[1][0];
                groups[1][0] = groups[1][1];
                groups[1][1] = groups[0][1];
                groups[0][1] = temp;

                groups[0][0].rotate(1);
                groups[0][1].rotate(1);
                groups[1][0].rotate(1);
                groups[1][1].rotate(1);
            }
            else if(cmd == 4){
                Group temp = groups[0][0];
                groups[0][0] = groups[0][1];
                groups[0][1] = groups[1][1];
                groups[1][1] = groups[1][0];
                groups[1][0] = temp;

                groups[0][0].rotate(3);
                groups[0][1].rotate(3);
                groups[1][0].rotate(3);
                groups[1][1].rotate(3);                
            }    
            else if(cmd == 5){
                Group temp = groups[0][0];
                groups[0][0] = groups[1][0];
                groups[1][0] = groups[1][1];
                groups[1][1] = groups[0][1];
                groups[0][1] = temp;
            }    
            else if(cmd == 6){
                Group temp = groups[0][0];
                groups[0][0] = groups[0][1];
                groups[0][1] = groups[1][1];
                groups[1][1] = groups[1][0];
                groups[1][0] = temp;
            }           
        }

        StringBuilder sb = new StringBuilder();

        int hn = n / 2;
        int hm = m / 2;

        boolean isRotated = (groups[0][0].rotate % 2 != 0);
        int total_row = isRotated ? m : n;
        int total_col = isRotated ? n : m;
        int cur_hn = isRotated ? hm : hn;
        int cur_hm = isRotated ? hn : hm;

        for (int i = 0; i < total_row; i++) {
            for (int j = 0; j < total_col; j++) {
                Group cur = groups[i / cur_hn][j / cur_hm];
                sb.append(cur.getPosValue(i % cur_hn, j % cur_hm, hn, hm) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Group{
        int num;
        boolean updown = false;
        boolean leftright = false;
        int rotate = 0;  // 0: 0 , 1: 90, 2: 180, 3: 270

        Group(int num) {
            this.num = num;
        }

        void changeUpdown(){
            if(rotate % 2 == 0)updown = !updown;
            else leftright = !leftright;
        }
        void changeLeftright(){
            if(rotate % 2 == 1) updown = !updown;
            else leftright = !leftright;
        }
        void rotate(int cnt) { rotate = (rotate + cnt) % 4; }

        int getPosValue(int y, int x, int row, int col){
            int fy, fx;
            if(rotate == 0){
                fy = y;
                fx = x;
            }
            else if(rotate == 1){
                fy = row - 1 - x;
                fx = y;
            }
            else if(rotate == 2){
                fy = row - 1 - y;
                fx = col - 1 - x;
            }
            else {
                fy = x;
                fx = col - 1 - y;
            }

            if(updown) fy = row - 1 - fy;
            if(leftright) fx = col - 1 - fx;

            int sy = (num / 2) * row;
            int sx = (num % 2) * col;

            return board[sy + fy][sx + fx];
        }
    }
}
