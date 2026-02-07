import java.util.*;

class Solution {
    // data: code[0], date[1], maximum[2], remain[3]
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int []> temp = new ArrayList<>();
        int iter = getIter(ext);
        int sort = getIter(sort_by);
        
        for(int [] d : data) if(d[iter] < val_ext) temp.add(d);
        
        
        Collections.sort(temp, (a, b) -> { 
            if(a[sort] > b[sort]) return 1; else return -1;
        });
        int[][] answer = new int [temp.size()][4];
        int i = 0;
        for(int [] t : temp) answer[i++] = t;
        
        return answer;
    }
    
    private int getIter(String s){
        if(s.equals("code")) return 0;
        else if(s.equals("date")) return 1;
        else if(s.equals("maximum")) return 2;
        else if(s.equals("remain")) return 3;
        return 4;
    }

}