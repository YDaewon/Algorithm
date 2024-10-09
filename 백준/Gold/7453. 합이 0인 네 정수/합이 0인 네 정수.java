
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		int [] A = new int[4000];
		int [] B = new int[4000];
		int [] C = new int[4000];
		int [] D = new int[4000];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		int [] AB = new int[n*n];
		int [] CD = new int[n*n];
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx++] = C[i] + D[j];
			}
		}
		long ans = 0;		
		//이분탐색
		Arrays.sort(AB);
		Arrays.sort(CD);
		int left = 0;
		int right = n*n-1;
		while(left < n*n && right >= 0) {
			if(AB[left] + CD[right] < 0) {
				left++;
			}
			else if(AB[left] + CD[right] > 0) {
				right--;
			}
			else {
				long next_left = 1;
				for(int i = left+1; i < n*n;i++) {
					if(AB[i-1] == AB[i]) {
						next_left++;
						left++;
					}
					else {
						break;
					}
				}
				long next_right = 1;
				for(int i = right-1; i >= 0;i--) {
					if(CD[i] == CD[i+1]) {
						next_right++;
						right--;
					}
					else {
						break;
					}
				}
				ans += next_left * next_right;
				left++;
			}
		}
		System.out.println(ans);
	}
}