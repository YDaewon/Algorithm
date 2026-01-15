import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int [][] matrix = new int [n][m];
        int [][][] dp = new int[3][n][m];// 방향, n, m
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<m;j++){
                matrix[i][j]= Integer.parseInt(st.nextToken());
                for(int d=0;d<3;d++)
                    dp[d][i][j] = Integer.MAX_VALUE;
                if(i==0) {
                    for(int d=0;d<3;d++)
                        dp[d][i][j] = matrix[i][j];
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j =0;j<m;j++){
                if(j == 0) {
                    dp[0][i][j] = Math.min(dp[2][i-1][j+1], dp[1][i-1][j+1]) + matrix[i][j];
                    dp[1][i][j] = dp[0][i-1][j]+matrix[i][j];
                }
                else if(j == m-1) {
                    dp[1][i][j] = dp[2][i-1][j] + matrix[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j-1], dp[1][i-1][j-1]) + matrix[i][j];
                }
                else{
                    dp[0][i][j] = Math.min(dp[2][i-1][j+1], dp[1][i-1][j+1]) + matrix[i][j];
                    dp[1][i][j] = Math.min(dp[2][i-1][j], dp[0][i-1][j]) + matrix[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j-1], dp[1][i-1][j-1]) + matrix[i][j];
                }
            }
        }
        
        int need = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int d = 0; d < 3; d++){
                if(need > dp[d][n-1][i]){
                    need = dp[d][n-1][i];
                }
            }
        }
        
        System.out.println(need);
    }
}