import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int [] belt;
    static boolean [] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[n*2+1];
        robot = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1;
        while(true){
            //System.out.println("seq: " + ans);
            if(play() >= k) break;
            ans++;
        }
        System.out.println(ans);
    }

    static int play(){
        int zero_cnt = 0;
        //System.out.println("=== lotate ===");
        lotate();
        //print();
        //System.out.println("=== robot move ===");
        robot_move();
        //print();
        if(belt[0] != 0 && !robot[0]){
            robot[0] = true;
            belt[0]--;
        }
        //System.out.println("=== robot up ===");
        //print();
        for (int i = 0; i < 2*n; i++) {
            if(belt[i] == 0) zero_cnt++;
        }
        //System.out.println("zero: " + zero_cnt);
        return zero_cnt;
    }

    static void lotate(){
        int first = belt[2 * n -1];
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i-1]; // 벨트 회전
            if(i <= n-1) robot[i] = robot[i-1]; // 로봇 회전

        }
        robot[n-1] = false;
        robot[0] = false;
        belt[0] = first;
    }

    static void robot_move(){
        for (int i = n-1; i > 0; i--) {
            if(robot[i-1] && !robot[i] && belt[i] != 0){
                //System.out.println("move robot: " + (i-1) + " to " + i);
                robot[i] = true; // 로봇 이동
                robot[i-1] = false;
                belt[i]--;
            }
        }
        robot[n-1] = false;
    }

    static void print(){
        System.out.println("robot position");
        for(int r = 0; r < n; r++){
            if(robot[r]) System.out.print(r + " ");
        }
        System.out.println();

        System.out.println("belt state");
        for(int r = 0; r < 2*n; r++){
            System.out.print(belt[r] + " ");
        }
        System.out.println();
        System.out.println();
    }
}