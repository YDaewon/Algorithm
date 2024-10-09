#include <iostream>
#include <algorithm>
using namespace std;

int paper[500][500];
int visit[500][500];
int n,m,result=0;
int head_x[4]={0,0,-1,1};
int head_y[4]={-1,1,0,0};

void dfs(int y, int x, int sum, int depth){
    visit[y][x]=1;
    if(depth==4)
        result=max(result,sum);
    else{
        for(int i = 0;i<4;i++){
            int dx=x+head_x[i];
            int dy=y+head_y[i];
            if(dx<0||dx>=m||dy<0||dy>=n) continue;
            if(visit[dy][dx]==0){
                dfs(dy,dx,sum+paper[dy][dx],depth+1);
            }
        }
    }
    visit[y][x]=0;
}

void T(int y,int x){ 
    for(int i = 0; i < 4; i++){
        int sum=paper[y][x];
        for(int j = 0; j < 4; j++){
            if(i==j) continue;
            int dx = x+head_x[j];
            int dy = y+head_y[j];
            if(dx>=0&&dx<m&&dy>=0&&dy<n) {
                sum += paper[dy][dx];
            }
        }
        result=max(result,sum);
    }
}

int main(){
    cin>>n>>m;
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            cin >> paper[i][j];
        }
    }
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            dfs(i,j,paper[i][j],1);
            T(i,j);
        }
    }
    cout << result;
}
            