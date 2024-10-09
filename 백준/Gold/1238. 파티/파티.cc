#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

int n,m,x;
vector<pair<int,int>> town[1001];
int dst[1001];
int result;

void input(){
    int s,e,cost;
    cin>>n>>m>>x;
    for(int i=0;i<m;i++){
        cin>>s>>e>>cost;
        town[s].push_back({e,cost});
    }
}

int dijkstra(int start,int end){
    memset(dst,98765432,sizeof(dst));
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0,start});
    dst[start]=0;
    while(!pq.empty()){
        int hx=pq.top().second;
        int cost=pq.top().first;
        pq.pop();
        if(hx==end){
            return dst[hx];
        }
        for(int i = 0;i<town[hx].size();i++){
            int dx=town[hx][i].first;
            int dcost=town[hx][i].second+cost;
            if(dst[dx]>dcost){
                dst[dx]=dcost;
                pq.push({dcost,dx});
            }
        }
    }
}

int main(){
    input();
    int ans=0, ans1,ans2;
    for(int i = 1;i<=n;i++){
        ans=max(ans,dijkstra(i,x)+dijkstra(x,i));
    }
    cout<<ans;
}