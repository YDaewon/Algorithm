import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_3307 {
	static Scanner sc = new Scanner(System.in);
	static int n, ans;
	static int [] arr;
	static int [] list;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			init();
			sol();
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void init() {
		ans = 0;
		n = sc.nextInt();
		arr = new int[n];
        list = new int [n];
		for(int i = 0; i < n; i ++) {
			arr[i] = sc.nextInt();
		}
	}
	
	static void sol() {
		int cnt = 0;
		list[cnt] = arr[0];
		for(int i = 1; i < n; i++) {
			if(arr[i] > list[cnt]) {
				cnt++;
				list[cnt] = arr[i];
			}
			else {
				list[lower_bound(0, cnt, arr[i])] = arr[i];
			}
		}
		ans = cnt+1;
	}
	
	static int lower_bound(int left, int right, int num) {
		while(left < right) {
			int mid = (left+right)/2;
			if(list[mid] >= num) right = mid;
			else left = mid+1;
		}
		return right;
	}
}
