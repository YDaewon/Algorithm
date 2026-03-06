 import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static Node f, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            List<String> a = new ArrayList<>();
            while(st.hasMoreTokens()){
                a.add(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            List<String> b = new ArrayList<>();
            while(st.hasMoreTokens()){
                b.add(st.nextToken());
            }

            f = build(a);
            s = build(b);

            sb.append(is_same(f, s) + "\n");
        }
        System.out.println(sb);
    }   

    static class Node{
        String str;
        Node left;
        Node right;
    }

    static Node build(List<String> post){
        Stack<Node> s = new Stack<>();
        for(String n : post){
            if(n.equals("end")) break;
            if(n.equals("nil")) s.push(null);
            else{
                Node node = new Node();
                node.str = n;
                if(!s.isEmpty()) node.right = s.pop();
                if(!s.isEmpty()) node.left = s.pop();
                s.push(node);
            }
        }
        return s.isEmpty() ? null :s.pop();
    }

    static boolean is_same(Node a, Node b){
        if(a == null && b == null) return true;
        else if(a == null || b == null) return false;
       // System.out.println("a: " + a.str + ", b: " + b.str);
        
        if(!a.str.equals(b.str)) return false;
        
        return (is_same(a.left, b.left) && is_same(a.right, b.right)) || 
           (is_same(a.left, b.right) && is_same(a.right, b.left));
    }

}
