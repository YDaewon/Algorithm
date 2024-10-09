#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n,m,h;
int head_x[6]={0,0,-1,1,0,0};
int head_y[6]={-1,1,0,0,0,0};
int head_z[6]={0,0,0,0,-1,1};
queue<vector<int>> q;

int box[100][100][100];
int visit[100][100][100];

void bfs(){
    while(!q.empty()){
        int tz = q.front()[0];
        int ty = q.front()[1];
        int tx = q.front()[2];
        q.pop();
        for(int i = 0;i<6;i++){
            int pz = tz+head_z[i];
            int py = ty+head_y[i];
            int px = tx+head_x[i];
            if(pz<0||pz>=h||py<0||py>=n||px<0||px>=m) continue;
            if(visit[pz][py][px] == -1 && box[pz][py][px] != -1){
                vector<int> t(3);
                t[0]=pz;t[1]=py;t[2]=px;
                q.push(t);
                visit[pz][py][px]=visit[tz][ty][tx]+1;
            }
        }
    }
}

int main(){
    cin>>m>>n>>h;
    for(int i = 0;i<h;i++){
        for(int j = 0;j<n;j++){
            for(int k = 0;k<m;k++){
                cin >> box[i][j][k];
                if(box[i][j][k]==1){
                    vector<int> t(3);
                    t[0]=i;
                    t[1]=j;
                    t[2]=k;
                    q.push(t);
                }
                if(box[i][j][k]==0) visit[i][j][k]=-1;
            }
        }
    }
    bfs();
    int result = 0;
    for(int i = 0;i<h;i++){
        for(int j = 0;j<n;j++){
            for(int k = 0;k<m;k++){
                if(visit[i][j][k]==-1){
                    cout<<-1;
                    return 0;
                }
                else if(visit[i][j][k] > result){
                    result= visit[i][j][k];
                }
            }
        }
    }
    cout << result;
}

                  