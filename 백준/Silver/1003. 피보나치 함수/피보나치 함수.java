 import java.io.*;
/*
0: 1 0
1: 0 1
2: 1 1     f(1) + f(0)
3: 1 2     f(2) + f(1)     f(1) + f(0) + f(1)
4: 2 3     f(3) + f(2)     f(2) + f(1) + f(1) + f(0)     f(1) + f(0) + f(1) + f(1) + f(0)
5: 3 5


*/

public class Main {
    static int [] zdp = new int [41];
    static int [] odp = new int [41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        zdp[0] = 1;
        zdp[1] = 0;
        odp[0] = 0;
        odp[1] = 1;

        for(int i = 2; i <= 40; i++){
            zdp[i] = zdp[i-1] + zdp[i-2];
            odp[i] = odp[i-1] + odp[i-2];
        }
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append(zdp[n] + " " + odp[n] + "\n");
        }

        System.out.println(sb);
    }

    
}
