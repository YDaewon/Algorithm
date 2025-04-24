class Solution {
    // 현재 피로도: k
    // 던전: [최소 요구치, 실제 소모]
    int answer = 0;
    boolean [] visit = new boolean[9];
    public int solution(int k, int[][] dungeons) {
        permutation(0, dungeons.length, 0, k, dungeons);
        return answer;
    }
    
    void permutation(int d, int max, int dcnt, int now, int[][] dungeons){
        answer = answer > dcnt ? answer : dcnt;
        if(d == max){
            return;
        }
        for(int i = 0; i < max; i++){
            if(!visit[i] && dungeons[i][0] <= now){
                visit[i] = true;
                permutation(d+1, max, dcnt+1, now - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        
    }
    
}