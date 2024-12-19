import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int [][] block = new int [H][W];
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int b = Integer.parseInt(st.nextToken());
            for(int j = 0; j < b; j++){
                block[j][i] = 1;
            }
        }
        /*
        for (int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++){
                System.out.print(block[i][j] + " ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < H; i++) {
            int cnt = 0;
            for (int j = 0; j < W; j++) {
                if(block[i][j] == 1){
                    int temp = j+1;
                    boolean flag = false;
                    while(temp < W){
                        if(block[i][temp] == 1) {
                            flag = true;
                            break;
                        }
                        temp++;
                        cnt++;
                    }
                    if(flag){
                        //if(cnt != 0)System.out.println("i: " + i + ", j: " + j + ", temp: " + temp + ", plus: " + cnt);
                        j = temp-1;
                        ans += cnt;
                        cnt = 0;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}