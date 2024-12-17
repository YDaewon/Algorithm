import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] preOrder, inOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try{
            while(true) {
                String input = br.readLine();
                if(input.split(" ").length ==0) break;
                st = new StringTokenizer(input);
                preOrder = st.nextToken().toCharArray(); // root -> left -> right
                if(preOrder.length == 0) break;
                inOrder = st.nextToken().toCharArray(); // left -> root -> right

                postOrder(0, 0, preOrder.length);
                sb.append("\n");
                //System.out.println(sb.toString());
            }
        } catch (Exception e){}

        System.out.println(sb.toString());
    }

    // left -> right -> root
    private static void postOrder(int root, int start, int end) {
        if(root >= preOrder.length) return;

        char rootNode = preOrder[root];

        for (int i = start; i < end; i++) {
            if(rootNode == inOrder[i]) {
                postOrder(root+1, start, i); // leftNode
                postOrder(root+(i-start+1), i+1, end); // rightNode
                sb.append(rootNode);
                return;
            }
        }
    }
}
