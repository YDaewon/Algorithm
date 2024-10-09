#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#define pii pair<int,int>
using namespace std;

int n,k,ans;

void sol(){
    priority_queue<pii, vector<pii>, greater<pii>> pq;
    int visit[100010];
    fill(visit,visit+100010,1);
    pq.push({0,n});
    visit[n]=0;
    while(!pq.empty()){
        int t= pq.top().first;
        int x= pq.top().second;
        pq.pop();
        if(x==k){
            ans=t;
            break;
        }
        int nx = 2*x;
        if(nx>=0&&nx<=100000&&visit[nx]){
            pq.push({t,nx});
            visit[nx]=0;
        }
        for(int next : {x+1,x-1}){
            if(next>=0&&next<=100000&&visit[next]){
                pq.push({t+1,next});
                visit[next]=0;
            }
        }
    }
    cout<<ans;
}

int main(){
    cin>>n>>k;
    sol();
}
            
        