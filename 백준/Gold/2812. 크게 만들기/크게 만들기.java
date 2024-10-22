import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans_len = n - k;
		Stack<Integer> s = new Stack<>();
		String num = br.readLine();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i = 0; i < num.length(); i++) {
			int now = num.charAt(i) - '0';
			while(k > 0 && !s.isEmpty()) {
				if(s.peek() >= now) break;
                s.pop();
				//System.out.println(s.pop() + "POP!!");
				k--;
			}
			s.push(now);
			//System.out.println(now + "PUSH!!");
		}
		
		while(!s.isEmpty()) ans.add(s.pop());
		Collections.reverse(ans);
		while(ans.size() > ans_len) ans.remove(ans.size()-1);
		for(int i : ans) System.out.print(i);
	}
}
