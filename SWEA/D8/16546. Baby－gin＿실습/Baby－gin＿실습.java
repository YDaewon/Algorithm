import java.util.Scanner;

public class Solution {
    static char [] check = new char[3];
    static int [] visit = new int[6];
    static char [] str;
    static boolean [] ans = new boolean[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int test = 1; test <= T; test++) {
            str = sc.nextLine().toCharArray();
            for (int i = 0; i < 6; i++) ans[i] = false;
            permutation(0);
            boolean flag = true;
            for (int i = 0; i < 6; i++) {
                if(!ans[i]){
                    flag = false;
                    break;
                }
            }
            System.out.println("#" + test + " " + flag);
        }
    }

    static void permutation(int d){
        if(d == 3){
            if(run() || triplet()){
                for (int i = 0; i < str.length; i++) {
                    if(visit[i] == 1 && !ans[i]){
                        ans[i] = true;
                        //System.out.println(i+": ture");
                    }
                }
                check = new char[3];
            }
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if(visit[i] == 0 && ans[i] == false){
                check[d] = str[i];
                visit[i] = 1;
                permutation(d+1);
                visit[i] = 0;
            }
        }
    }

    static boolean run(){
        return (check[2] - check[1] == 1 && check[1] - check[0] == 1);
    }

    static boolean triplet(){
        return (check[2] == check[1] && check[1] == check[0]);
    }
}
