#include <iostream>
using namespace std;

int n;
int ans[2];
int dy[4]={-1,-1,1,1};
int dx[4]={-1,1,-1,1};
int board[11][11];

void input(){
    cin>>n;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>board[i][j];
        }
    }
}

bool check(int y,int x){
    for(int i=1;i<n;i++){
        for(int j=0;j<4;j++){
            int ny=y+dy[j]*i;
            int nx=x+dx[j]*i;
            if(ny<0||ny>=n||nx<0||nx>=n) continue;
            if(board[ny][nx] == -1) return false;
        }
    }
    return true;
}

void n_bishop(int cnt, int y, int x, int c){
    if(x>=n){
        y++;
        x = x % 2 ? 0 : 1;
    }
    if (y>=n){
        ans[c] = ans[c] > cnt ? ans[c] : cnt;
        return;
    }
    if(board[y][x] == 1 && check(y,x)){
        board[y][x]=-1;
        n_bishop(cnt+1,y,x+2,c);
        board[y][x]=1;
    }
    n_bishop(cnt,y,x+2,c);
}

int main(){
    input();
    n_bishop(0,0,0,0);
    n_bishop(0,0,1,1);
    cout<<ans[0]+ans[1];
}
                