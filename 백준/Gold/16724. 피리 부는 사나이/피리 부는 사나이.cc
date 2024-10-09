#include <iostream>
#include <algorithm>
using namespace std;
typedef pair<int,int> pll;

int n,m;
int ans;
char board[1000][1000];
pll parant[1000][1000];

pll find(pll a){
    int y = a.first; int x = a.second;
    if(a == parant[y][x]) return a;
    parant[y][x]=find(parant[y][x]);
    return parant[y][x];
}

void input(){
    cin>>n>>m;
    ans=n*m;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>board[i][j];
            parant[i][j]={i,j};
        }
    }
}

void sol(){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(parant[i][j] != make_pair(i,j)) continue;
            pll p;
            if(board[i][j]=='U') p = find(parant[i-1][j]);
            else if(board[i][j]=='D') p= find(parant[i+1][j]);
            else if(board[i][j]=='R') p= find(parant[i][j+1]);
            else p=find(parant[i][j-1]);
            if(p!=make_pair(i,j)){
                parant[i][j]=p;
                ans--;
            }
        }
    }
    cout << ans;
}

int main(){
    input();
    sol();
}
    