import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.Math;

class Solution
{
    public static int kill_bug_p(int [][] arr, int n, int m, int y, int x){
        int bug = arr[y][x];
        for(int i = 1; i < m; i++){
            if(y + i < n) bug += arr[y+i][x];
            if(x + i < n) bug += arr[y][x+i];
            if(y - i >= 0) bug += arr[y-i][x];
            if(x - i >= 0) bug += arr[y][x-i];
        }
        return bug;
    }
    public static int kill_bug_x(int [][] arr, int n, int m, int y, int x){
        int bug = arr[y][x];
        for(int i = 1; i < m; i++){
            if(y + i < n && x + i < n) bug += arr[y+i][x+i];
            if(y - i >= 0 &&x + i < n) bug += arr[y-i][x+i];
            if(y + i < n && x - i >= 0) bug += arr[y+i][x-i];
            if(y - i >= 0 && x - i >= 0) bug += arr[y-i][x-i];
        }
        return bug;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int n , m, ans = 0;
            int [][] arr = new int[15][15];
            n = sc.nextInt();
            m = sc.nextInt();
            for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
                	arr[i][j] = sc.nextInt();
                }                
            }
            
            for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
                	ans = Math.max(ans, kill_bug_p(arr,n,m,i,j));
                    ans = Math.max(ans, kill_bug_x(arr,n,m,i,j));
                }                
            }
            System.out.println("#"+test_case+" "+ ans);
		}
	}
}