import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 팀 개수
            int k = Integer.parseInt(st.nextToken()); // 문제 개수
            int my_id = Integer.parseInt(st.nextToken()) - 1; // 내 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

            Team [] team = new Team[n];
            for (int i = 0; i < n; i++) team[i] = new Team(i, k);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int tid = Integer.parseInt(st.nextToken()) - 1;
                int pid = Integer.parseInt(st.nextToken()) - 1;
                int score = Integer.parseInt(st.nextToken());

                team[tid].addLog(pid, score, i);
            }

            for (int i = 0; i < n; i++) {
                team[i].getTotal();
            //    System.out.println("team[" + (team[i].teamId+1) + "]'s score: " + team[i].total);
            }

            Arrays.sort(team);

           // for (int i = 0; i < n; i++) {
           //     System.out.println("team[" + (team[i].teamId + 1) + "]'s rank: " + (i+1));
           // }

            for(int i = 0; i < n; i++){
                if(team[i].teamId == my_id) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }

}

class Team implements Comparable<Team>{
    int teamId;
    int submitCount;
    int [] problem;
    int submitTime;
    int total;

    @Override
    public int compareTo(Team o){
        if(this.total != o.total) return o.total - this.total;
        else if( this.submitCount != o.submitCount) return this.submitCount - o.submitCount;
        else return this.submitTime - o.submitTime;
    }

    public Team(int id, int p_count){
        this.teamId = id;
        this.submitCount = 0;
        this.problem = new int[p_count];
        this.submitTime = 0;
    }

    public void addLog(int pid, int score, int time){
        submitCount++;
        this.submitTime = time;
        problem[pid] = Math.max(problem[pid], score);
    }

    public void getTotal(){
        for (int i : problem) {
            total += i;
        }
    }
}
