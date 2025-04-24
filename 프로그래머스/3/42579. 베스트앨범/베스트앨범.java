import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> total = new HashMap<>();
        Map<String, Map<Integer, Integer>> musics = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(!total.containsKey(genres[i])){
                total.put(genres[i], plays[i]);
                
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                musics.put(genres[i], temp);
                
            }
            else{
                musics.get(genres[i]).put(i, plays[i]);
                total.put(genres[i], total.get(genres[i]) + plays[i]);
            }
        }
        
        List<String> genre_key = new ArrayList<>(total.keySet());
        
        Collections.sort(genre_key, (s1, s2) -> total.get(s2) - (total.get(s1)));
        
        for(String genre : genre_key){
            Map<Integer, Integer> temp = musics.get(genre);
            List<Integer> music_num = new ArrayList<>(temp.keySet());
            Collections.sort(music_num, (s1, s2) -> temp.get(s2) - (temp.get(s1)));
            
            answer.add(music_num.get(0));
            if(music_num.size() > 1){
                answer.add(music_num.get(1));
            }
        }
        return answer;
    }
}