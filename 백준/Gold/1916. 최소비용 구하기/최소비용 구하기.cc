#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;
const int INF = 99999999;

int n,m,start,ans;
vector<vector<pair<int,int>>> g;
int dst[1001];

void dijkstra(int point){
    priority_queue<pair<int,int>> pq;
    pq.push({0,point});
    dst[point]=0;
    while(!pq.empty()){
        int x = pq.top().second;
        int cost = pq.top().first;
        pq.pop();
        if(dst[x] < cost) continue;
        for(auto i : g[x]){
            int px= i.first;
            int pcost=i.second+cost;
            if(dst[px]>pcost){
                dst[px]=pcost;
                pq.push({pcost,px});
            }
        }
    }
    cout <<dst[ans];
}

void input(){
    cin>>n>>m;
    g.resize(n+1);
    int f,s,cost;
    for(int i = 0;i<m;i++){
        cin>>f>>s>>cost;
        g[f].push_back({s,cost});
    }
    fill_n(dst,1001,INF);
    cin>>start>>ans;
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    input();
    dijkstra(start);
}
            