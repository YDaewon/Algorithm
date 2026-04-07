import java.io.*;
import java.util.*;

public class Main {
    static int c, n;
    static Trie root = new Trie();
    static List<String> nickname = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < c; i++) {
            root.insert(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            nickname.add(br.readLine());
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(q-- > 0){
            String s = br.readLine();
            if(root.search(s)) sb.append("Yes");
            else sb.append("No");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Trie{
        Node root;

        Trie(){
            this.root = new Node();
        }

        void insert(String s){
            Node cur = root;

            for (char c : s.toCharArray()) {
                if(cur.child[c - 'a'] == null) cur.child[c - 'a'] = new Node();
                cur = cur.child[c - 'a'];
            }
            cur.isEnd = true;
        }

        
        boolean search(String s){
            Node cur = root;
            int idx = 0;
            for (char c : s.toCharArray()) {
                cur = cur.child[c - 'a'];
                if(cur == null) break;

                if(cur.isEnd){
                    if(nickname.contains(s.substring(idx + 1))) return true;
                }
                idx++;
            }
            return false;
        }
    }

    static class Node{
        Node [] child;
        boolean isEnd;

        Node(){
            this.child = new Node[26];
            this.isEnd = false;
        }
    }
}
