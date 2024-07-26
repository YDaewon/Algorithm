import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_15681 {
    static int n, r, q;
    static int [] node_size;
    static ArrayList<Integer> [] node;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str =br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        r = Integer.parseInt(str[1]);
        q = Integer.parseInt(str[2]);
        node_size = new int [n+1];
        node = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            node[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < n-1; i++) {
            String [] temp =br.readLine().split(" ");
            int f = Integer.parseInt(temp[0]);
            int s = Integer.parseInt(temp[1]);
            //System.out.println(f + " , " + s);
            node[f].add(s);
            node[s].add(f);
        }
        int [] visit = new int[n+1];
        find_node(r, visit);

        while(q != 0) {
            int node =Integer.parseInt(br.readLine());
            System.out.println(node_size[node]);
            q--;
        }
    }

    static void find_node(int root, int [] visit) {
        node_size[root] = 1;
        visit[root] = 1;
        for(int i : node[root]) {
            if(visit[i] == 0) {
                find_node(i, visit);
                node_size[root] += node_size[i];
            }
        }
    }
}

class Node{
    int f, s;
    Node(int f, int s){
        this.f = f;
        this.s = s;
    }
}
