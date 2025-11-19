class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int len = arr.length / 2;
        if(arr.length % 2 == 1) len += 1;
        int [][] max = new int[len][len];  // i ~ j까지 연산의 최댓값
        int [][] min = new int[len][len];  // i ~ j까지 연산의 최솟값
        
        int [] dp = new int [len];
        
        for(int i = 0; i < len; i ++){
            for(int j = 0; j < len; j ++){
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
                if(i == j){
                    max[i][i] = Integer.parseInt(arr[2 * i]);
                    min[i][i] = Integer.parseInt(arr[2 * i]);  
                }
            }
        }
        
        for(int l = 1; l < len; l++){ // 계산할 범위 길이
            for(int s = 0; s < len - l; s++){ // start
                int e = s + l;
                for(int now = s; now < e; now++){
                    if(arr[2 * now + 1].equals("+")){
                        max[s][e] = Math.max(max[s][e], max[s][now] + max[now+1][e]);
                        min[s][e] = Math.min(min[s][e], min[s][now] + min[now+1][e]);
                    }
                    else{
                        max[s][e] = Math.max(max[s][e], max[s][now] - min[now+1][e]);
                        min[s][e] = Math.min(min[s][e], min[s][now] - max[now+1][e]);
                    }
                }
            }
        }
        
        return max[0][len-1];
    }
}