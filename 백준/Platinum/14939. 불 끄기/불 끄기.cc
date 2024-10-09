#include <iostream>
#include <algorithm>
using namespace std;

int board[11][11], temp[11][11];
int ans = 1000;
int dy[5]={0,-1,1,0,0};
int dx[5]={0,0,0,-1,1};

void input(){
    char t;
    for(int i = 0; i < 10;i++){
        for(int j = 0; j < 10; j++){
            cin >> t;
            if(t=='O') board[i][j]=1;
            else board[i][j]=0;
        }
    }
}

void init(){
    for(int i = 0;i<10;i++){
        for(int j=0;j<10;j++){
            temp[i][j]=board[i][j];
        }
    }
}

void turn(int y, int x){
    for(int i = 0;i<5;i++){
        int ty= y+dy[i];
        int tx= x+dx[i];
        if(ty>=10||ty<0||tx>=10||tx<0) continue;
        temp[ty][tx] = !temp[ty][tx];
    }
}

bool light(){
    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            if(temp[i][j]) return false;
        }
    }
    return true;
}

void sol(){
    for(int d=0;d<1024;d++){
        int cnt =0;
        init();
        
        for(int b=0;b<10;b++){
            if(d&(1<<b)){
                cnt++;
                turn(0,b);
            }
        }
        
        for(int y=1;y<10;y++){
            for(int x=0;x<10;x++){
                if(temp[y-1][x]){
                    cnt++;
                    turn(y,x);
                }
            }
        }
        
        if(light()) ans=min(ans,cnt);
    }
    if(ans==1000) cout<<-1;
    else cout << ans;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    sol();
}
            