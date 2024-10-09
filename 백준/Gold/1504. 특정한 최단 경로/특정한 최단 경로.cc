#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;
const int INF = 9999999;

int n,m,v1,v2;
vector<pair<int,int>> town[1001];
int dst[1001];
int result;

void input(){
    int s,e,cost;
    cin>>n>>m;
    for(int i=0;i<m;i++){
        cin>>s>>e>>cost;
        town[s].push_back({e,cost});
        town[e].push_back({s,cost});
    }
    cin >> v1 >> v2;
}

void dijkstra(int start){
    memset(dst,INF,sizeof(dst));
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0,start});
    dst[start]=0;
    while(!pq.empty()){
        int hx=pq.top().second;
        int cost=pq.top().first;
        pq.pop();       
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
    int ans= INF;
    int stov1,stov2,v1tov2,v1toe,v2toe;
    dijkstra(1);
    stov1=dst[v1];
    stov2=dst[v2];           
    dijkstra(v1);
    v1tov2=dst[v2];
    v1toe=dst[n];
    dijkstra(v2);
    v2toe=dst[n];
    ans=min({ans,stov1+v1tov2+v2toe,stov2+v1tov2+v1toe});
    if(ans==INF||v1tov2==INF)cout<<"-1";
    else cout<<ans;

}