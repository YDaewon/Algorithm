import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int [n];
		Stack<Integer> s = new Stack<>();
		for(int i =0 ; i < n; i++) arr[i] = sc.nextInt();
		int idx = 1;
		int top = -1;
		for(int i = 0; i < n; i++) {
			if(arr[i] == idx) {
				idx++;
			}
			else {
				s.add(arr[i]);
				top = arr[i];
			}
			
			while(!s.empty()) {
				int t = s.peek();
				if(t == idx) {
					s.pop();
					idx++;
					top = s.empty() ? -1 : s.peek();
				}
				else {
					break;
				}
			}
		}
		while(!s.empty()) {
			int t = s.pop();
			if(t == idx) idx++;
		}
		System.out.println(idx == n+1 ? "Nice" : "Sad");
	}
}
