#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;
const int INF = 999999;

int n;
vector<int> v;
int state[100001][5][5];
int cost[5][5]={{INF,2,2,2,2},
                {INF,1,3,4,3},
                {INF,3,1,3,4},
                {INF,4,3,1,3},
                {INF,3,4,3,1}};

void input(){
    v.push_back(0);
    while(1){
        cin>>n;
        if(n==0)break;
        v.push_back(n);
    }
    memset(state,INF, sizeof(state));
    n=v.size();
}

void sol(){
    state[0][0][0]=0;
    for(int i=1;i<n;i++){
        for(int y=0;y<5;y++){
            for(int x=0;x<5;x++){
                if(state[i-1][y][x]>=INF) continue;
                state[i][v[i]][x]=min(state[i][v[i]][x], state[i-1][y][x]+cost[y][v[i]]);
                state[i][y][v[i]]=min(state[i][y][v[i]], state[i-1][y][x]+cost[x][v[i]]);
            }
        }
    }
    int ans = INF;
    for(int y=0;y<5;y++)
        for(int x=0;x<5;x++)
            ans=min(ans,state[n-1][y][x]);
    cout<<ans;
}
                    
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}