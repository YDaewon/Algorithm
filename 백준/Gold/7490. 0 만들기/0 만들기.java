import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            sol(1, 1, 1, 0, "1");
            System.out.println();
        }
    }

    static void sol(int d, int stack, int def_sign, int sum, String str){
        if(d == n){
            sum += (stack * def_sign);
            if(sum == 0){
                System.out.println(str);
            }
            return;
        }
        sol(d + 1, stack*10 + d+1, def_sign, sum, str+" "+Integer.toString(d+1));
        sol(d + 1, d+1,1, sum + ((stack) * def_sign), str+"+"+Integer.toString(d+1));
        sol(d + 1, d+1,-1, sum + ((stack) * def_sign), str+"-"+Integer.toString(d+1));
    }
}