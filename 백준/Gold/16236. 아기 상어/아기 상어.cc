#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define pll pair<int,int>
using namespace std;

int n,time=0;
int sea[21][21];
int head_y[4] = {-1,1,0,0};
int head_x[4] = {0,0,-1,1};
pll start;

struct Fish{
    int d,y,x;
    bool operator<(const Fish& b) const{
        if(d==b.d){
            if(y==b.y){
                return x>b.x;
            }
            return y>b.y;
        }
        return d>b.d;
    }
};        

int sol(int size){
    vector<vector<int>> visit(n+1);
    for(int i=0;i<=n;i++)
        for(int j=0;j<=n;j++)
            visit[i].push_back(-1);
    visit[start.first][start.second]=0;
    queue<pll> q;
    priority_queue<Fish> pq;
    q.push(start);
    while(!q.empty()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for(int i=0;i<4;i++){
            int dy= y+head_y[i];
            int dx=x+head_x[i];
            if(dy>n||dy<1||dx>n||dx<1) continue;
            if(visit[dy][dx]<0&&sea[dy][dx]<=size){
                visit[dy][dx]=visit[y][x]+1;
                if(sea[dy][dx]>0&&sea[dy][dx]<size){
                   pq.push({visit[dy][dx],dy,dx});
                }
                else{
                    q.push(make_pair(dy,dx));  
                }
            }
        }
    }
    if(!pq.empty()){
        time+=pq.top().d;
        start={pq.top().y, pq.top().x};
        sea[start.first][start.second]=0;
        return true;
    }
    return false;        
}

int main(){
    cin >>n;
    for(int i=1;i<=n;i++){        
        for(int j=1;j<=n;j++){
            cin >>sea[i][j];
            if(sea[i][j]==9){
                start={i,j};
                sea[i][j]=0;
            }
        }
    }
    int size=2;
    int cnt=0;
    while(1){
        if(sol(size)){
            cnt+=1;
            if(cnt==size){
                size+=1;
                cnt=0;
            }
        }
        else break;
    }
    cout << time;
}

        

            