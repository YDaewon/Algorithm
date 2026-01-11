import java.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] num = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        int left = 0;
        for(int i =0;i <n;i++){
            while(!s.isEmpty() && num[s.peek()] < num[i]){
                int top = s.pop();
                num[top] = num[i];
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            int now = s.pop();
            num[now] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : num) sb.append(i+" ");
        System.out.println(sb);
    }
}