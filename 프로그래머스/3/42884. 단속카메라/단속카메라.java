import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        // Arrays.sort(routes, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         if(o1[0] != o2[0]) {
        //             return o1[1] - o2[1];
        //         }else {
        //             return o1[0] - o2[0];
        //         }
        //     }
        // });
        //Arrays.sort(routes, (o1, o2) -> o1[0] == o2[0] ? (o1[0] - o2[0]) : (o1[1] - o2[1])
        
        int prev_end = -35000;
        
        for(int [] route : routes){
            int start = route[0];
            int end = route[1];
            if(prev_end < start){
                answer++;
                prev_end = end;
            }
        }
        
        
        return answer;
    }
}