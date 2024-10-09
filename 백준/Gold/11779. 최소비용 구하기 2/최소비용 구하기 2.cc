#include <iostream>
#include <vector>
#include <queue>
using namespace std;
const int INF = 99999999;

int n,m;
int start, d;
vector<vector<pair<int,int>>> arr;
int dist[1005];

void input(){
    cin>>n>>m;
    int f,s,c;
    arr.resize(n+1);
    for(int i = 1;i<=n;i++)
        dist[i]=INF;
    for(int i = 0;i<m;i++){
        cin>>f>>s>>c;
        arr[f].push_back({s,c});
    }
    cin>>start>>d;
}

void sol(){
    dist[start]=0;
    vector<int> route(n+1);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    pq.push({start,0});
    while(!pq.empty()){
        int node=pq.top().first;
        int cost=pq.top().second;
        pq.pop();
        if(dist[node]<cost)continue;
        for(int i = 0;i<arr[node].size();i++){
            int next=arr[node][i].first;
            int ncost=arr[node][i].second+cost;
            if(ncost<dist[next]){
                pq.push({next,ncost});
                dist[next]=ncost;
                route[next]=node;
            }
        }
    }
    vector<int> ans;
    cout<<dist[d]<<"\n";
    while(d){
        ans.push_back(d);
        d=route[d];
    }
    cout<< ans.size()<<"\n";
    for(int i = ans.size()-1;i>=0;i--){
        cout << ans[i]<<" ";
    }
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}