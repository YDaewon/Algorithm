import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int [][] swap = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            swap[i][0] = Integer.parseInt(st.nextToken()) - 1; // left
            swap[i][1] = Integer.parseInt(st.nextToken()) - 1; // right
            swap[i][2] = Integer.parseInt(st.nextToken()); // cost
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        pq.add(new State(arr, 0));
        visited.put(convert(arr, n), 0);

        while(!pq.isEmpty()){
            State cur = pq.poll();
            if(isSorted(cur.arr)){
                System.out.println(cur.cost);
                return;
            }

            if(visited.getOrDefault(convert(cur.arr, n), Integer.MAX_VALUE) < cur.cost) continue;

            for (int i = 0; i < m; i++) {
                int [] next = swap(cur.arr, swap[i][0], swap[i][1]);
                if(visited.getOrDefault(convert(next, n), Integer.MAX_VALUE) > cur.cost + swap[i][2]) {
                    visited.put(convert(next, n), cur.cost + swap[i][2]);
                    pq.add(new State(next, cur.cost + swap[i][2]));
                }
            }
        }
        System.out.println(-1);
    }

    static int convert(int [] arr, int n){
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i];
            result *= 10;
        }
        return result;
    }

    static boolean isSorted(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    static int [] swap(int[] arr, int left, int right){
        int [] result = new int [arr.length];
        for (int i = 0; i < arr.length; i++) result[i] = arr[i];
        int temp = result[left];
        result[left] = result[right];
        result[right] = temp;
        return result;
    }



    static class State implements Comparable<State>{
        int[] arr;
        int cost;

        State(int[] arr, int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        @Override
        public int compareTo(State s){
            return this.cost - s.cost;
        }
    }
}
