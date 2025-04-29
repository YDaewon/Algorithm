class Solution {
    int cnt = -1;
    int answer = 0;
    public int solution(String word) {
        permutation(word, 0, "");
        return answer;
    }
    
    void permutation(String word, int d, String now){
        if(answer != 0 || d > 5){
            return;
        }
        cnt++;
        //System.out.println("now: " + now + ", cnt: " + cnt);
        if(word.equals(now)){
            answer = cnt;
        } else{
            for(String s : new String [] {"A", "E", "I", "O", "U"}){
                permutation(word, d+1, now + s);
            }
        }
        
        
        
    }
}