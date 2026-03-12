 import java.io.*;
import java.util.*;

public class Main {
    static int [][] arr = new int [3][3];
    static int now = 0;
    static int end = 0; // 0 : L, 1: D, 2: W
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int one = 0;
        int two = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());    
                if(arr[i][j] == 1) one++;
                else if(arr[i][j] == 2) two++;
            }
        }
        now = one == two ? 1 : 2;

        end = play(now);

        if(end == 2) System.out.println("W");
        else if(end == 1) System.out.println("D");
        else System.out.println("L");
    }   


    static int play(int cur){
        if(is_end(cur == 1 ? 2 : 1)) return 0;

        int temp = 3;
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[i][j] == 0){
                    flag = false;
                    arr[i][j] = cur;
                    temp = Math.min(temp, play(cur == 1 ? 2 : 1));
                    arr[i][j] = 0;
                    
                    if(temp == 0) return 2;
                }
            }
        }
        if(flag) return 1;

        if(temp == 1) return 1;
        return 0;
    }

    static boolean is_end(int num){
        // System.out.println("==================");
        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }        

        for (int i = 0; i < 3; i++) {
            if(arr[i][0] == num && arr[i][1] == num && arr[i][2] == num) return true;
            if(arr[0][i] == num && arr[1][i] == num && arr[2][i] == num) return true;
        }
        if(arr[0][0] == num && arr[1][1] == num && arr[2][2] == num) return true;
        if(arr[0][2] == num && arr[1][1] == num && arr[2][0] == num) return true;
        
        return false;
    }
}
