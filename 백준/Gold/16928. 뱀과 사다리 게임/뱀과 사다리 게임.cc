#include <iostream>
#include <queue>
#include <map>
#include <string.h>
#include <algorithm>
using namespace std;

int visit[101];
int n,m;
map<int,int> shortcut;

void bfs(){
    queue<pair<int,int>> q;
    q.push({1,0});
    visit[1]=1;
    while(!q.empty()){
        int move=q.front().first;
        int cnt=q.front().second;
        q.pop();
        if(move==100){
            continue;
        }
        else{
            if(shortcut[move]){
                q.push({shortcut[move],cnt});
                visit[shortcut[move]]=min(visit[shortcut[move]],cnt);
            }
            else{                
                for(int i = 1;i<=6;i++){            
                    if(move+i>100) continue;
                    if(visit[move+i]>cnt+1){
                        q.push({move+i,cnt+1});
                        visit[move+i]=cnt+1;
                    }
                }
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin>>n>>m;
    int s,e;
    for(int i = 0;i<n+m;i++){
        cin>>s>>e;
        shortcut[s]=e;
    }
    memset(visit,100,sizeof(visit));
    bfs();
    cout<<visit[100];
}

