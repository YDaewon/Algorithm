#include <iostream>
#include <stack>
#include <vector>
using namespace std;

vector<vector<int>> g(1001);
int visit[1001];
int n,m,result=0;

void dfs(int n){
    stack<int> s;
    s.push(n);
    while(!s.empty()){
        int t = s.top();
        s.pop();
        for(int i : g[t]){
            if(visit[i]==0){
                visit[i]=1;
                s.push(i);
            }
        }
    }
}

int main(){
    cin>>n>>m;
    int f,s;
    for(int i =0;i<m;i++){
        cin>>f>>s;
        g[f].push_back(s);
        g[s].push_back(f);
    }
    for(int i =1;i<=n;i++){
        if(visit[i]==0){
            visit[i]=1;
            dfs(i);
            result++;
        }
    }
    cout<<result;
}
      