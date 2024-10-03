import java.util.Scanner;

public class Solution_1058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char [][] friend = new char [n][n];
        int [][] famous = new int [n][n];
        for (int i = 0; i < n; i++) {
            String t = sc.nextLine();
            for (int j = 0; j < n; j++) {
                friend[i][j] = t.charAt(j);
            }
        }


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == j) continue;
                    if(friend[i][j] == 'Y' || (friend[i][k] =='Y' && friend[k][j] == 'Y'))
                        famous[i][j]=1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if(famous[i][j] == 1) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
