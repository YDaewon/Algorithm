#include <iostream>
#include <vector>
#include <stack>
using namespace std;
typedef pair<int,int> pii;

int n,m;
int board[1000][1000];
vector<vector<int>> v;

int dy[4]={-1,1,0,0};
int dx[4]={0,0,-1,1};

void input(){
    cin>>n>>m;
    char t;
    for(int i=0;i<n;i++){
        vector<int> tv;
        for(int j=0;j<m;j++){
            cin>>t;
            board[i][j]=t-'0';
            tv.push_back(0);
        }
        v.push_back(tv);
    }
}

void dfs(pii p){
    vector<pii> wall;
    stack<pii> s;
    s.push(p);
    v[p.first][p.second]=1;
    int cnt=1;
    while(!s.empty()){
        int y = s.top().first;
        int x = s.top().second;
        s.pop();
        for(int i = 0;i<4;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny<0||ny>=n||nx<0||nx>=m) continue;
            if(v[ny][nx]==0&&board[ny][nx]==0){
                v[ny][nx]=1;
                s.push({ny,nx});
                cnt++;
            }
            else if(v[ny][nx]==0&&board[ny][nx]!=0){
                v[ny][nx]=1;
                wall.push_back({ny,nx});
            }
        }
    }
    for(auto k:wall){
        board[k.first][k.second]+=cnt;
        v[k.first][k.second]=0;
    }
}

void sol(){
    for(int i =0;i<n;i++){
        for(int j=0;j<m;j++){
            if(v[i][j]==0&&board[i][j]==0)dfs({i,j});
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cout<<board[i][j]%10;
        }
        cout<<"\n";
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}