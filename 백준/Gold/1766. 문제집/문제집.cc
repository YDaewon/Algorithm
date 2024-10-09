#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <map>
using namespace std;

int n,m;
vector<vector<int>> node;
map<int,int> visit;

void input(){
    cin>>n>>m;
    node.resize(n+1);
    int f,s;
    for(int i=0;i<m;i++){
        cin>>f>>s;
        node[f].push_back(s);
        visit[s]++;
    }
}

void sol(){
    priority_queue<int,vector<int>,greater<int>> pq;
    for(int i=1;i<=n;i++){
        if(visit[i]==0){
            pq.push(i);
        }
    }
    for(int i = 1;i<=n;i++){
        if(pq.empty()) return;
        int x=pq.top();
        pq.pop();
        for(int j : node[x]){
            visit[j]--;
            if(visit[j]==0){
                pq.push(j);
            }
        }
        cout<<x<<" ";
    }
}

int main(){
    input();
    sol();
}
        