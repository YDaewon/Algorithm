class Solution {
    int answer = 0;
    int move = 0;
    char [] str;
    
    public int solution(String name) {
        str = name.toCharArray();
        move = str.length-1;
        for(int i = 0; i < str.length; i++) {
            process(i);
        }
        answer += move;
        return answer;
    }

    void process(int now){
        //1. 지금 알파벳에서 숫자 올리기 vs 내리기 , 알파벳은 26글자
        answer += Math.min(str[now] - 'A', 'Z' - str[now] + 1);
        //System.out.print("now: " + now + "인덱스 알파벳 변경: " + Math.min(cur, 26-cur));
        //2. 오른쪽으로 가서 돌릴지, 왼쪽으로가서 돌릴지   ex) n: 7이고 내가 2번을 보고있어. 3~6까지는 A   2 -> 보다는 <- 2가 더 빠르다. 
        //오른쪽껄 봤을 때 안바꿔도된다? -> 왼쪽으로 가는 선택지도 있긴하다
        str[now] = 'A';
        
        int nxt = now + 1;
        while(nxt < str.length && str[nxt] =='A'){
            nxt++;
        }
        
        move = Math.min(move, (now * 2) + str.length - nxt);
        move = Math.min(move, (str.length - nxt) *2 + now);
    }
}