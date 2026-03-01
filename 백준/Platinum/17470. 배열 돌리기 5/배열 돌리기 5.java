 import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int [][] arr;

    static Group [][] group = {
            {new Group(0), new Group(1)}, 
            {new Group(2), new Group(3)}
        };;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int [n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        while(r-- > 0) {
            int cmd = Integer.parseInt(st.nextToken());
            // if(cmd == 1) calc_1();
            // else if(cmd == 2) calc_2();
            // else if(cmd == 3) calc_3();
            // else if(cmd == 4) calc_4();
            // else if(cmd == 5) calc_5();
            // else if(cmd == 6) calc_6();

            if(cmd == 1) {
                Group temp = group[0][0];
                group[0][0] = group[1][0];
                group[1][0] = temp;

                temp = group[0][1];
                group[0][1] = group[1][1];
                group[1][1] = temp;

                group[0][0].flipUpdown();
                group[0][1].flipUpdown();
                group[1][1].flipUpdown();
                group[1][0].flipUpdown();
            } else if(cmd == 2) {
                Group temp = group[0][0];
                group[0][0] = group[0][1];
                group[0][1] = temp;

                temp = group[1][0];
                group[1][0] = group[1][1];
                group[1][1] = temp;

                group[0][0].flipLeftRight();
                group[0][1].flipLeftRight();
                group[1][1].flipLeftRight();
                group[1][0].flipLeftRight();
            }else if(cmd == 3) {
                Group temp = group[0][0];
                group[0][0] = group[1][0];
                group[1][0] = group[1][1];
                group[1][1] = group[0][1];
                group[0][1] = temp;

                group[0][0].rotate(1);
                group[0][1].rotate(1);
                group[1][1].rotate(1);
                group[1][0].rotate(1);
            }else if(cmd == 4) {
                Group temp = group[0][0];
                group[0][0] = group[0][1];
                group[0][1] = group[1][1];
                group[1][1] = group[1][0];
                group[1][0] = temp;

                group[0][0].rotate(3);
                group[0][1].rotate(3);
                group[1][1].rotate(3);
                group[1][0].rotate(3);
            }else if(cmd == 5){ 
                Group temp = group[0][0];
                group[0][0] = group[1][0];
                group[1][0] = group[1][1];
                group[1][1] = group[0][1];
                group[0][1] = temp;
            }else if(cmd == 6) {
                Group temp = group[0][0];
                group[0][0] = group[0][1];
                group[0][1] = group[1][1];
                group[1][1] = group[1][0];
                group[1][0] = temp;
            }
            //pnt();
        }
        //pnt();
        
        int hn = n / 2;
        int hm = m / 2;

        boolean isRotated = (group[0][0].rotation % 2 != 0);
        int total_row = isRotated ? m : n;
        int total_col = isRotated ? n : m;
        int cur_hn = isRotated ? hm : hn;
        int cur_hm = isRotated ? hn : hm;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total_row; i++) {
            for (int j = 0; j < total_col; j++) {
                Group g = group[i / cur_hn][j / cur_hm];
                int temp = g.getValue(i % cur_hn, j % cur_hm, hn, hm);
                sb.append(temp + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void pnt(){
        // System.out.println("========================================");
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    static class Group{
        int num;
        boolean changeUpdown = false;
        boolean changeLeftRight = false;
        int rotation = 0; // 0: 0 , 1: 90, 2: 180, 3: 270

        Group(int num){
            this.num = num;
        }
        void flipUpdown() {
            if (rotation % 2 == 0) changeUpdown = !changeUpdown;
            else changeLeftRight = !changeLeftRight;
        }
        void flipLeftRight() {
            if (rotation % 2 == 0) changeLeftRight = !changeLeftRight;
            else changeUpdown = !changeUpdown;
        }
        void rotate(int cnt) { rotation = (rotation + cnt) % 4; }

        int getValue(int y, int x, int row, int col) {
            // 1. 회전 역변환 먼저
            int finalY, finalX;
            if (rotation == 0) {
                finalY = y; finalX = x;
            } else if (rotation == 1) { // 시계 90도 역변환
                finalY = row - 1 - x;
                finalX = y;
            } else if (rotation == 2) {
                finalY = row - 1 - y;
                finalX = col - 1 - x;
            } else { // 반시계 90도 역변환
                finalY = x;
                finalX = col - 1 - y;
            }

            // 2. 반전은 원본 좌표계 기준으로 나중에
            if (changeUpdown) finalY = row - 1 - finalY;
            if (changeLeftRight) finalX = col - 1 - finalX;

            int startY = (num / 2) * row;
            int startX = (num % 2) * col;
            return arr[startY + finalY][startX + finalX];
        }
    }


    static void calc_1(){
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row/2; i++) {
            int [] t = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = t;
        }
    }

    static void calc_2(){
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int t = arr[i][j];
                arr[i][j] = arr[i][m-j-1];
                arr[i][m-j-1] = t;
            }
        }
    }

    static void calc_3(){
        int row = arr.length;
        int col = arr[0].length;
        int [][] temp = new int [col][row];
        for (int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++){
                temp[i][j] = arr[row - j - 1][i];
            }
        }
        arr = temp;
    }

    static void calc_4(){
        int row = arr.length;
        int col = arr[0].length;
        int [][] temp = new int [col][row];
        for (int i = col-1; i >= 0; i--) {
            for(int j = 0; j < row; j++){
                temp[(col-1) - i][j] = arr[j][i];
            }
        }
        arr = temp;
    }

    static void calc_5(){
        int row = arr.length;
        int col = arr[0].length;

        int grow = row/2;
        int gcol = col/2;

        int [][] temp = new int [grow][gcol]; // group 4

        for (int i = 0; i < grow; i++) { // 4 -> temp
            for (int j = 0; j < gcol; j++) {
                temp[i][j] = arr[grow+i][j];
            }
        }

        for (int i = 0; i < grow; i++) {  // 3 -> 4
            for (int j = 0; j < gcol; j++) {
                arr[grow+i][j] = arr[grow+i][gcol + j];
            }
        }

        for (int i = 0; i < grow; i++) { // 2 -> 3
            for (int j = 0; j < gcol; j++) {
                arr[grow+i][gcol + j] = arr[i][gcol + j];
            }
        }

        for (int i = 0; i < grow; i++) { // 1 -> 2
            for (int j = 0; j < gcol; j++) {
                arr[i][gcol + j] = arr[i][j];
            }
        }

        for (int i = 0; i < grow; i++) { // temp -> 1
            for (int j = 0; j < gcol; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    static void calc_6(){
        int row = arr.length;
        int col = arr[0].length;

        int grow = row/2;
        int gcol = col/2;

        int [][] temp = new int [grow][gcol]; // group 4

        for (int i = 0; i < grow; i++) { // 4 -> temp
            for (int j = 0; j < gcol; j++) {
                temp[i][j] = arr[grow+i][j];
            }
        }

        for (int i = 0; i < grow; i++) {  // 1 -> 4
            for (int j = 0; j < gcol; j++) {
                arr[grow+i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < grow; i++) { // 2 -> 1
            for (int j = 0; j < gcol; j++) {
                arr[i][j] = arr[i][gcol + j];
            }
        }

        for (int i = 0; i < grow; i++) { // 3 -> 2
            for (int j = 0; j < gcol; j++) {
                arr[i][gcol + j] = arr[grow + i][gcol + j];
            }
        }

        for (int i = 0; i < grow; i++) { // temp -> 3
            for (int j = 0; j < gcol; j++) {
                arr[grow + i][gcol + j] = temp[i][j];
            }
        }
    }


}
