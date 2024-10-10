import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] arr;
    private static boolean[] visited;
    static int x, n, ans;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            arr = new int[2*n][n];
            ans = 0;
            for(int i = 0; i < n; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j< n; j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            for(int i = 0; i < n; i++) {
            	for(int j = 0; j< n; j++) {
            		arr[i+n][j] = arr[j][i];
            	}
            }
            sol();
            
            System.out.println("#" + test_case + " " + ans);
        }
    }
    
    static void sol() {
    	for(int i = 0; i < 2 * n; i++) {
    		int t = isTrue(i);
    		//System.out.println( "return = " + t);
    		ans += t;
        }
    }

	private static int isTrue(int y) {
//    	for(int i = 0; i < n; i++) {
//    		System.out.print(arr[y][i] + " ");
//        }
		
		int val = arr[y][0];
		int cnt = 1;
		for(int i = 1; i < n; i++) {
			if(arr[y][i] == val) cnt++;
			else if(arr[y][i] - val == -1) {
				if(n- i < x) return 0;
				for(int j = 1; j < x; j++) {
					if(val - arr[y][++i] != 1) {
						return 0;
					}
				}
				cnt = 0;
				val = arr[y][i];
			}
			else if(arr[y][i] - val == 1) {
				if(cnt < x) return 0;
				val = arr[y][i];
				cnt = 1;
			}
			else {
				return 0;
			}
		}
		return 1;
	}

}