#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int visit[6][6];
int r,c,k;
int dx[4] = {0,0,-1,1};
int dy[4] = {-1,1,0,0};
int result = 0;

void dfs(int y,int x, int cnt){
    if(y == 1&&x==c){
        if(cnt == k)
            result++;
        return;
    }
    for(int i = 0;i < 4; i++){
        int px = x + dx[i];
        int py = y + dy[i];
        if(visit[py][px] == -1) continue;
        if(px>c || py >r) continue;
        if(visit[py][px] == 0){
            visit[py][px] = 1;
            dfs(py,px,cnt+1);
            visit[py][px] = 0;
        }
    }
}

int main(){
    cin >> r >> c >> k;
    string t;
    for(int i = 0; i < 6; i++) fill_n(visit[i],6,-1);
    
    for(int i = 1; i <= r; i++){
        cin >> t;
        for(int j = 1; j<=c;j++){
            if(t[j-1] == 'T')
                visit[i][j] = -1;
            else
                visit[i][j] = 0;
        }
    }
    visit[r][1] = 1;
    dfs(r,1,1);
    cout << result;
}
        