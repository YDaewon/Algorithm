 import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Tree tree;
    static int [] numtotree;
    static Tree [] nodes;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        tree = build(str);
        // System.out.println();
        // for (int i = 1; i < numtotree.length; i++) {
        //     System.out.print(numtotree[i] + " ");
        // }
        // System.out.println();

        set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        reverse_find(numtotree[t1]);

        int answer = numtotree[t2];
        while(!set.contains(answer)){
            answer = nodes[answer].p.val;
        }

        for (int i = 1; i <= 2 * n; i++) {
            if(numtotree[i] == answer){
                System.out.print(i + " ");
            }
        }


    } 

    static void reverse_find(int cur){
        set.add(cur);
        if(nodes[cur].p != null) reverse_find(nodes[cur].p.val);
    }

    static int find(Tree cur, int rm){
        // System.out.print(cur.val + " -> ");
        int cnt = 1;
        for (Tree t : cur.child) {
            if(t.val != rm) {
                cnt += find(t, rm);
            }
        }

        return cnt;
    }

    static class Tree{
        int val;
        Tree p;
        List<Tree> child = new ArrayList<>();

        Tree(int v){
            this.val = v;
        }
    }

    static Tree build(String str){
        Stack<Tree> s = new Stack<>();
        Tree root = null;
        int idx = 1;
        numtotree = new int [str.length() + 1];
        nodes = new Tree [n+1];

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - '0';
            if(c == 0){
                Tree newtree = new Tree(idx);
                numtotree[i+1] = newtree.val;
                nodes[idx++] = newtree;

                if(!s.isEmpty()){
                    Tree temp = s.peek();
                    temp.child.add(newtree);
                    newtree.p = temp;
                }
                else{
                    root = newtree;
                }
                s.push(newtree);
            }
            else{
                Tree cur = s.pop();
                numtotree[i+1] = cur.val;
            }
        }
        return root;
    }
}
