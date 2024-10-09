#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct shark{
    int y;
    int x;
    int size;
    int speed;
    int direction;
    int num;
};

int r,c,m;
vector<shark> obj;
vector<int> board[101][101];
int dy[5]={0,-1,1,0,0};
int dx[5]={0,0,0,1,-1};

bool srt(int a, int b){
    if(obj[a].size > obj[b].size) return true;
    else return false;
}

void input(){
    cin>>r>>c>>m;
    for(int i=0;i<m;i++){
        shark t;
        cin>>t.y>>t.x>>t.speed>>t.direction>>t.size;
        t.num=i;
        obj.push_back(t);
        board[t.y][t.x].push_back(i);              
    }
}

int fishing(int x){
    for(int y = 1;y<=r;y++){
        if(board[y][x].size()!=0){
            int res=obj[board[y][x][0]].size;
            obj[board[y][x][0]].size=0;
            board[y][x].clear();
            return res;
        }
    }
    return 0;
}

void move(){
    for(shark s : obj){
        if(s.size==0) continue;
        board[s.y][s.x].clear();
    }

    for(int i=0;i<obj.size();i++){
        if(obj[i].size==0) continue;
        int y = obj[i].y;
        int x = obj[i].x;
        int d = obj[i].direction;
        int spd = obj[i].speed;
        if(d<=2){
            int mod = (r-1)*2;
            if(spd>=mod) spd%=mod;
            for(int i=0;i<spd;i++){
                int ny=y+dy[d];
                int nx=x+dx[d];
                if(ny>r){
                    d=1;
                    ny-=2;
                }
                else if(ny<1){
                    d=2;
                    ny+=2;
                }
                y=ny;
                x=nx;
            }
        }
        else{
            int mod = (c-1)*2;
            if(spd>=mod) spd%=mod;
            for(int i=0;i<spd;i++){
                int ny=y+dy[d];
                int nx=x+dx[d];
                if(nx>c){
                    d=4;
                    nx-=2;
                }
                else if(nx<1){
                    d=3;
                    nx+=2;
                }
                y=ny;
                x=nx;
            }
        }
        obj[i].y=y;
        obj[i].x=x;
        obj[i].direction=d;
        board[y][x].push_back(i);
    }
}

void kill(){
    for(int i=1;i<=r;i++){
        for(int j=1;j<=c;j++){
            if(board[i][j].size()>1){
                sort(board[i][j].begin(), board[i][j].end(), srt);
                int live=board[i][j][0];
                for(int k=1;k<board[i][j].size();k++){
                    obj[board[i][j][k]].size=0;
                    obj[board[i][j][k]].y=-1;
                    obj[board[i][j][k]].x=-1;
                }
                board[i][j].clear();
                board[i][j].push_back(obj[live].num);
            }
        }        
    }
}

void sol(){
    int sum=0;
    for(int x=1;x<=c;x++){
        sum+=fishing(x);
        move();
        kill();
    }
    cout << sum;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}