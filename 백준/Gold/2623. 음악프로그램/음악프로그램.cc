#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n,m;
vector<vector<int>> graph;
vector<int> d;
vector<int> ans;

void input(){
    cin>>n>>m;
    d.resize(n+1);
    graph.resize(n+1);
    while(m--){
        int t,f,s;
        cin>>t;
        if(!t)continue;
        cin>>f;
        t--;
        while(t--){
            cin>>s;
            graph[f].push_back(s);
            d[s]++;
            f=s;
        }
    }
}

void sol(){
    queue<int> q;
    for(int i=1;i<=n;i++)
        if(d[i]==0) q.push(i);
    while(!q.empty()){
        int x = q.front();
        q.pop();
        ans.push_back(x);
        for(int i: graph[x])
            if(--d[i]==0) q.push(i);
    }
    if(ans.size()==n) for(int i:ans) cout << i << '\n';
    else cout << 0;
}

int main(){
    input();
    sol();
}