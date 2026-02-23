 import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static Tree arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

    
        long [] num = new long [n+1];
        for (int i = 1; i <= n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        arr = Tree.init(num, 1, n);
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(q == 1) arr.update(a, b);
            else System.out.println(arr.getSum(a, (int)b));
        }

    }

    static class Tree{
        long sum;
        int start;
        int end;
        Tree left;
        Tree right;

        Tree(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public static Tree init(long [] data, int start, int end){
            Tree node = new Tree(start, end);
            if(start == end){
                node.sum = data[start];
                return node;
            }

            int mid = (start + end)/2;
            node.left = init(data, start, mid);
            node.right = init(data, mid+1,end);
            node.sum = node.left.sum + node.right.sum;
            return node;
        }

        public long getSum(int s, int e){
            if(e < this.start || s > this.end) return 0;

            if(s <= this.start && this.end <= e) return sum;

            return left.getSum(s, e) + right.getSum(s, e);
        }

        public void update(int i, long val){
            if(this.start == this.end) {
                this.sum = val;
                return;
            }

            int mid = (start + end)/2;
            if(i <= mid) left.update(i, val);
            else right.update(i, val);

            this.sum = left.sum + right.sum;
        }
    }


}
