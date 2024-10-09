#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
typedef long long L;
const int INF=99999999;

L n,m,ans=INF;

void bfs(){
    queue<pair<L,L>> q;
    q.push({n,1});
    while(!q.empty()){
        L x=q.front().first;
        L d=q.front().second;
        q.pop();
        if(x>m)continue;
        if(x==m) ans=min(ans,d);
        for(L i : {x*2,x*10+1})
            q.push({i,d+1});
    }
}

int main(){
    cin>>n>>m;
    bfs();
    if(ans==INF)cout<<-1;
    else cout<<ans;
}
            