#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int board[1000][1000];
int visit[1000][1000];
int n,m;
int hx[4]={0,0,-1,1};
int hy[4]={-1,1,0,0};

void bfs(pair<int,int> g){
    queue<pair<int,int>> q;
    q.push(g);
    visit[g.first][g.second]=1;
    board[g.first][g.second]=0;
    while(!q.empty()){
        int ty=q.front().first;
        int tx=q.front().second;
        q.pop();
        for(int i = 0;i<4;i++){
            int dx=tx+hx[i];
            int dy=ty+hy[i];
            if(dx<0||dx>=m||dy<0||dy>=n) continue;
            if(visit[dy][dx]==0&&board[dy][dx]!=0){
                q.push({dy,dx});
                visit[dy][dx]=1;
                board[dy][dx]=board[ty][tx]+1;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    pair<int,int> g;
    cin>>n>>m;
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            cin >> board[i][j];
            if(board[i][j]==2) g=make_pair(i,j);
        }
    }
    bfs(g);
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(visit[i][j]==0&&board[i][j]!=0) board[i][j]=-1;
        }
    }
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            cout<< board[i][j]<<" ";
        }
        cout<<"\n";
    }
}

            