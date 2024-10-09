import java.util.Scanner;

public class Main {
    static int [] dna, need;
    static int n, m, answer = 0;
    static String str;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dna = new int [4];
        need = new int[4];
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        str = sc.nextLine();
        for(int i = 0; i < 4; i++)
            need[i] = sc.nextInt();

        int [] temp = new int[4];
        for(int i = 0 ; i < m; i++) {
            int idx = dna_count(str.charAt(i));
            if(idx != -1) temp[idx]++;
        }
        for (int i = m; i <= n; i++) {
            boolean flag = true;
            for(int j = 0; j < 4; j++){
                if(temp[j] < need[j]) {
                    flag = false;
                    //System.out.println("flag!!!!");
                }
            }
            if(flag) answer++;
            if(i == n) break;
            int idx = dna_count(str.charAt(i));
            if(idx != -1) temp[idx]++;
            idx = dna_count(str.charAt(i-m));
            if(idx != -1) temp[idx]--;
        }
        System.out.println(answer);
    }

    static int dna_count(char c){
        if(c == 'A') return 0;
        else if(c=='C') return 1;
        else if(c=='G') return 2;
        else if(c=='T') return 3;

        return -1;
    }
}
