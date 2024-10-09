#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int visit[10000];

void bfs(int s, int e){
    queue<pair<int,string>> q;
    visit[s] = 1;
    q.push({s,""});
    while(!q.empty()){
        int n = q.front().first;
        string ans = q.front().second;
        q.pop();
        if(n==e){
            cout << ans << endl;
            return;
        }
        int L,R,D,S;
        D = (n*2) % 10000;
        if(visit[D]==0){
            visit[D]=1;
            q.push({D, ans+"D"});       
        }
        S = n-1 < 0 ? 9999 : n-1;
        if(visit[S]==0){
            visit[S]=1;
            q.push({S, ans+"S"});
        }
        L=(n%1000) * 10 + n/1000;
        if(visit[L]==0){
            visit[L]=1;
            q.push({L, ans+"L"});
        }
        R= (n%10)*1000 + (n/10);
        if(visit[R]==0){
            visit[R]=1;
            q.push({R, ans+"R"});
        }
    }
}

int main(){
    int T;
    cin>>T;
    while(T--){
        int s,e;
        cin >> s>> e;
        memset(visit,0,sizeof(visit));
        bfs(s,e);
    }
}
            