#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

vector<vector<pair<int,int>>> tree(1001);
int visit[1001];
int n,m;

int bfs(int start, int end){
    queue<pair<int,int>> q;
    q.push({start,0});
    visit[start]=1;
    while(!q.empty()){
        int cur = q.front().first;
        int cnt = q.front().second;
        q.pop();
        if(cur == end) return cnt;
        for(pair<int,int> i:tree[cur]){
            if(visit[i.first]==0){
                visit[i.first] = 1;
                q.push({i.first,i.second+cnt});
            }
        }
    }
}    
int main(){
    cin >> n >> m;
    int s,e,d;
    for(int i = 1;i<n;i++){
        cin >> s >> e >> d;
        tree[s].push_back({e,d});
        tree[e].push_back({s,d});
    }
    for(int i = 0; i < m;i++){
        cin >> s >> e;
        int des = bfs(s,e);
        cout << des << endl;
        memset(visit,0,sizeof(visit));
    }
}