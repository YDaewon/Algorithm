#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

bool visit[101][101];
string area[101];
int n,m;
int blue = 0;
int white = 0;
int dx[4]={0,0,-1,1};
int dy[4]={-1,1,0,0};

void dfs(int y, int x){
    int count = 1;
    char team = area[y][x];
    vector<pair<int,int>> s = {make_pair(y,x)};
    while(!s.empty()){
        int px = s.back().second;
        int py = s.back().first;
        s.pop_back();       
        for(int i=0;i<4;i++){
            int tx = px + dx[i];
            int ty = py + dy[i];
            if (tx <0 || tx >= n || ty <0 || ty >= m) continue;
            if(!visit[ty][tx]&& area[ty][tx] == team){
                s.push_back(make_pair(ty,tx));
                count++;
                visit[ty][tx] = true;
            }
        }
    }
    if(team == 'W') white += count * count;
    else if(team == 'B') blue += count*count;
}

int main(){
    cin >> n >> m;

    for(int i=0;i<m;i++){    
        cin >> area[i];
        fill_n(visit[i],n,false);
    }
    for(int i =0; i<m;i++){
        for(int j =0; j<n;j++){
            if(!visit[i][j]){
                visit[i][j] = true;
                dfs(i,j);
            }
        }
    }
    cout << white << " " << blue;
}