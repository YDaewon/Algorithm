#include <iostream>
#include <stack>
#include <algorithm>
#include <vector>
#define pll pair<int,int>
using namespace std;

int n;
pll answer={0,0};
vector<vector<pll>> g;
int visit[10001];

void dfs(int start){
    stack<pll> s;
    s.push({0,start});
    visit[start]=1;
    while(!s.empty()){
        int x = s.top().second;
        int cost = s.top().first;
        s.pop();
        bool flag = true;
        for(auto i : g[x]){
            int px= i.first;
            int pcost=i.second+cost;
            if(!visit[px]){
                visit[px]=1;
                s.push({pcost,px});
                flag = false;
            }
            if(flag){
                if(answer.first<cost){
                    answer={cost,x};
                }
            }
        }
    }
}

void input(){
    cin>>n;
    g.resize(n+1);
    int f,s,cost;
    for(int i = 1;i<n;i++){
        cin>>f>>s>>cost;
        g[f].push_back({s,cost});
        g[s].push_back({f,cost});
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    input();
    dfs(1);
    int temp= answer.second;
    fill_n(visit,n+1,0);
    dfs(temp);
    cout<<answer.first;
}