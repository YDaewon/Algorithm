 import java.io.*;
import java.util.*;

public class Main {
    static int n, l;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String T = "";
        while((T = br.readLine()) != null && !T.isEmpty()){
            int n = Integer.parseInt(T);
            Trie trie = new Trie();
            String [] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
                trie.insert(arr[i]);
            }

            double sum = 0;

            for (int i = 0; i < n; i++) {
                sum += trie.search(arr[i]);
            }
            sb.append(String.format("%.2f\n", sum / n));
            //System.out.println("sum:" + sum);
        }
        System.out.println(sb);
    } 



    static class Trie{
        Node root;

        Trie(){
            this.root = new Node();
        }

        void insert(String str){
            Node cur = root;

            for(char c : str.toCharArray()){
                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);
            }
            cur.isEnd = true;
        }

        int search(String str){
            Node cur = root.child.get(str.charAt(0));
            int cnt = 1;
            for(int i = 1; i < str.length(); i++){
                char c = str.charAt(i);
                if(cur.isEnd || cur.child.size() > 1) {
                    //System.out.println(str + ", now: " + c + ", cnt: " + cur.child.size());
                    cnt++;
                }
                cur = cur.child.get(c);
            }
            //System.out.println(str + ", cnt: " + cnt);
            return cnt;
        }
    }

    static class Node{
        Map<Character, Node> child;
        boolean isEnd;

        Node(){
            this.child = new HashMap<>();
            this.isEnd = false;
        }
    }


}
