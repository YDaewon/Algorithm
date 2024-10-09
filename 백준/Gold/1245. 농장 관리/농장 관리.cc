#include <iostream>
#include <stack>
using namespace std;

int mount[101][101];
int visit[101][101];
int n,m;
int head_x[8]={0,0,-1,1,-1,1,-1,1};
int head_y[8]={-1,1,0,0,1,1,-1,-1};
bool flag;

void dfs(int y, int x){
    stack<pair<int,int>> s;
    s.push({y,x});
    while(!s.empty()){
        int tx = s.top().second;
        int ty = s.top().first;
        s.pop();
        int px, py;
        for(int i=0;i<8;i++){
            px = tx + head_x[i];
            py = ty + head_y[i];
            if (px <1 || px > m || py <1 || py > n) continue;
            if(mount[y][x] < mount[py][px]) flag=false;
            if(mount[py][px] == mount[y][x]&&visit[py][px]==0){
                s.push({py,px});
                visit[py][px]=1;
            }
        }
    }
}

int main(){
    int count=0;
    cin >> n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin >> mount[i][j];
        }
    }
    for(int i =1; i<=n;i++){
        for(int j=1; j<=m;j++){
            if(visit[i][j]==0){
                visit[i][j]=1;
                flag=true;
                dfs(i,j);
                if(flag)count++;
            }
        }
    }
    cout << count;
}