#include <iostream>
#include <algorithm>
using namespace std;

const int INF=999999;

int n,m,r;
int g[101][101];
int item[101];

void input(){
    cin>>n>>m>>r;
    for(int i = 1;i<=n;i++)
        cin>>item[i];
    int f,s,l;
    for(int i = 0;i<=n;i++){
        for(int j=0;j<=n;j++){
            if(i==j) g[i][j]=0;
            else g[i][j]=INF;
        }
    }
    for(int i=1;i<=r;i++){
        cin>>f>>s>>l;
        g[f][s]=l;
        g[s][f]=l;
    }
}

void sol(){
    for(int k= 1;k<=n;k++)
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                if(g[i][k]+g[k][j]<g[i][j])
                    g[i][j]=g[i][k]+g[k][j];
    
    int ans=0;
    for(int i=1;i<=n;i++){
        int temp=0;
        for(int j=1;j<=n;j++)
            if(g[i][j]<=m) temp+=item[j];
        ans=max(ans,temp);
    }
    cout << ans;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    input();
    sol();
}
