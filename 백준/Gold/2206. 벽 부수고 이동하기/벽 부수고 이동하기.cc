#include <iostream>
#include <queue>
#include <string>
using namespace std;
#define pll pair<int,int>

int n,m;
int board[1000][1000];
int visit[1000][1000][2];
int hy[4]={-1,1,0,0};
int hx[4]={0,0,-1,1};

void input(){
    cin>>n>>m;
    string t;
    for(int i=0;i<n;i++){
        cin>>t;
        for(int j = 0;j<m;j++){
            board[i][j]=t[j]-'0';
        }
    }
}

int sol(){
    queue<pair<int, pll>> q;
    q.push({0,{0,0}});
    visit[0][0][0]=1;
    while(!q.empty()){
        int row = q.front().second.first;
        int col = q.front().second.second;
        int wall= q.front().first;
        q.pop();
        if (row==n-1&&col==m-1){
            return visit[row][col][wall];
        }
        for(int i = 0;i<4;i++){
            int dy = row+hy[i];
            int dx = col+hx[i];
            if(dy<0||dy>=n||dx<0||dx>=m) continue;
            if(board[dy][dx]==1&&wall==0){
                q.push({1,{dy,dx}});
                visit[dy][dx][wall+1]=visit[row][col][wall]+1;
            }
            else if(board[dy][dx]==0&&visit[dy][dx][wall]==0){
                q.push({wall,{dy,dx}});
                visit[dy][dx][wall]=visit[row][col][wall]+1;
            }
        }
    }
    return -1;
}

int main(){
    input();
    cout << sol();
}