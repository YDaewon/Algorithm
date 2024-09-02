import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_5644 {
    static Scanner sc = new Scanner(System.in);

    static int [] dy = {0,-1,0,1,0};
    static int [] dx = {0,0,1,0,-1};

    static Player [] players;
    static int [][] command;
    static AP [] aps;
    static int m,a;
    static int charge;
    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int test = 1; test <= T; test++){
            init();
            sol();
            System.out.println("#" + test + " " + charge);
        }
    }


    static void init(){
        m = sc.nextInt();
        a = sc.nextInt();
        charge = 0;
        players = new Player[2];
        command = new int[2][m];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < m; j++) {
                command[i][j] = sc.nextInt();
            }
        }
        aps = new AP[a];
        for (int i = 0; i < a; i++) {
            aps[i] = new AP(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

        }
        players[0] = new Player(1,1);
        players[1] = new Player(10,10);
    }

    static void sol(){
        get_charge();
        for(int t = 0; t < m; t++){
            //System.out.print("t: " + (t+1) + ", " + charge);
            players[0].move(command[0][t]);
            players[1].move(command[1][t]);
            //System.out.print(" A point: " + players[0].y + ", " + players[0].x);
            //System.out.print(" B point: " + players[1].y + ", " + players[1].x);
            get_charge();
        }
    }

    static void get_charge(){
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            if (aps[i].connect(players[0])) A.add(i);
            if (aps[i].connect(players[1])) B.add(i);
        }

        int val = 0, t = 0;
        //System.out.println("   A size: " + A.size() + ", B size: " + B.size());
        if(A.size() > 0 && B.size() > 0){
            for (int i : A) {
                for (int j : B) {
                    t = 0;
                    if (i == j) {
                        t = aps[i].p;
                    } else {
                        t += aps[i].p;
                        t += aps[j].p;
                    }
                    val = Math.max(val, t);
                }
            }
        } else if (A.size() > 0) {
            for(int i : A){
                val = Math.max(val, aps[i].p);
            }
        } else if (B.size() > 0) {
            for(int i : B){
                val = Math.max(val, aps[i].p);
            }
        }
        charge += val;
    }

    static class AP{
        int y,x;
        int c, p;
        AP(int x, int y, int c, int p){
            this.y = y;
            this.x = x;
            this.c = c;
            this.p = p;
        }

        boolean connect(Player p){
            return c >= (Math.abs(p.y-this.y) + Math.abs(p.x-this.x));
        }
    }

    static class Player{
        int y, x;
        Player(int y, int x){
            this.y = y;
            this.x = x;
        }

        void move(int d){
                y += dy[d];
                x += dx[d];
        }
    }
}
