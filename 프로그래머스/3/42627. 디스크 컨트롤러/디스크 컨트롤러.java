import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int total = 0;
        int idx = 0;
        int cnt = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Disk> pq = new PriorityQueue<>();

        while(cnt < jobs.length){
            while (idx < jobs.length && jobs[idx][0] <= time) {
                int [] job = jobs[idx];
                pq.add(new Disk(idx, job[0], job[1]));
                idx++;
            }
            if(!pq.isEmpty()){
                Disk d = pq.poll();
                time += d.need;
                total += time - d.time;
                cnt++;
                System.out.println("num: " + d.num + ", time: " + d.time + ", need: " + d.need);
            } else time++;
            System.out.println("nowTime: " + time);
        }
        
        return total / jobs.length;
    }
    
    
    static class Disk implements Comparable<Disk>{
        int num;
        int time;
        int need;
        
        public Disk(int num, int time, int need) {
            this.num = num;
            this.time = time;
            this.need = need;
        }
        
        @Override
        public int compareTo(Disk d) {
            if (this.need != d.need) {
                return Integer.compare(this.need, d.need);
            } else if (this.time != d.time) {
                return Integer.compare(this.time, d.time);
            } else {
                return Integer.compare(this.num, d.num);
            }
        }
    }
}