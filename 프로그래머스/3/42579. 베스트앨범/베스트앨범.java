import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> g = new TreeMap<>(Comparator.reverseOrder());
        Map<String, List< int [] >> musics = new HashMap<>(); // 0 : idx, 1 : plays
        // ------------------- Data Classification
        for(int i = 0; i < plays.length; i++){
            g.put(genres[i], g.getOrDefault(genres[i], 0) + plays[i]);
            List<int []> temp = musics.getOrDefault(genres[i], new ArrayList<>());
            temp.add(new int [] {i, plays[i]});
            musics.put(genres[i], temp);
        }
        
        // -------------------  Sort
        List<String> bestAlbum = new ArrayList<>(g.keySet());
        Collections.sort(bestAlbum, (a,b) -> g.get(b) > g.get(a) ? 1 : -1);
        
        for (String genre: musics.keySet()) {
            Collections.sort(musics.get(genre), (a,b) -> {
                                 if(b[1] != a[1]) 
                                    return b[1] > a[1] ? 1 : -1;
                                 else return b[0] < a[0] ? 1 : -1;
            });
        }
        
        
        
        for (Map.Entry<String, Integer> t : g.entrySet()) {
            System.out.println(t.getKey() + " " + t.getValue());
        }
        System.out.println("Test");
        for (Map.Entry<String, List<int []>> t : musics.entrySet()) {
            for (int [] tt : t.getValue()) {
                System.out.println(tt[0] + ": " + tt[1]);
            }
        }
        // ------------------------------- make answer
        for (String genre : bestAlbum) {
            int cnt = 0;
            for (int [] music : musics.get(genre)) {
                if(cnt++ >= 2) break;
                answer.add(music[0]);
            }
        }
        
        return answer;
    }
}