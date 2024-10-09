#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>
using namespace std;

int n, k;
int visit[100010];
map<int, int> m;

void dfs(){
    queue<int> q;
    q.push(n);
    fill(visit, visit+100010, -1);
    visit[n]=0;
    m[n] = 1;
    while(!q.empty()){
        int x = q.front();
        q.pop();
        for(int i : {x-1, x+1, x*2}){
            if(i<0 || i > 100000) continue;
            if(visit[i] == -1){
                q.push(i);
                m[i] = m[x];
                visit[i] = visit[x] + 1;
            }
            else{
                if(visit[x] + 1 == visit[i]){
                    m[i] += m[x];
                }
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    cin>>n >> k;
    dfs();
    cout << visit[k] <<"\n" << m[k];
}