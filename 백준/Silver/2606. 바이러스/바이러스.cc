#include <iostream>
#include <stack>
#include <vector>
using namespace std;

vector<vector<int>> pc;
int visit[101];
int n,m;

int dfs(int start){
    stack<int> s;
    s.push(start);
    visit[start]=1;
    int cnt = 0;
    while(!s.empty()){
        int t = s.top();
        s.pop();
        for(int i : pc[t]){
            if(visit[i]==0){
                visit[i]=1;
                s.push(i);
                cnt++;
            }
        }
    }
    return cnt;
}

int main(){
    cin>>n>>m;
    int f,s;
    pc.resize(n+1);
    for(int i = 1;i<=m;i++){
        cin>>f>>s;
        pc[f].push_back(s);
        pc[s].push_back(f);
    }
    cout<<dfs(1);
}