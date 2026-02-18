 import java.io.*;
import java.util.*;

public class Main {

    /*
    경우
    0 => 0은 x
    1 => 1은 x
    01 => 다시 처음
    10 => 1은 x
    100 => 0은 그대로, 1이면 다음
    100~1 => 0이면 01로, 1이면 그대로
    100~1~ => 0이면 경우 2개, 1이면 그대로
    if(00) => 다시 첫번째꺼 사용중
    else => 두번째 꺼
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int [][] status = {
            {1 , 2}, // start
            {-1, 0}, // 0
            {3, -1}, // 1
            {4, -1}, // 10
            {4, 5}, //100
            {1, 6}, //100~1
            {7, 6}, // 100~1~
            {4, 0}, //100~1~0 
        };
        
        int now = 0;
        for (char c : str.toCharArray()) {
            int cur = c - '0';
            now = status[now][cur];
            if(now == -1) break; 
        }


        if(now != 0 && now != 5 && now != 6) System.out.println("NOISE");
        else System.out.println("SUBMARINE");
    }

}
