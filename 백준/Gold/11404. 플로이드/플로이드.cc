#include <iostream>
#include <algorithm>
using namespace std;
const int INF = 99999999;

int n,m;
int town[101][101];

void input(){
    cin>>n>>m;
    fill_n(town[0],10101,INF);
    int f,s,c;
    for(int i =0;i<m;i++){
        cin>>f>>s>>c;
        town[f-1][s-1]=min(town[f-1][s-1], c);
    }
    for(int i =0;i<n;i++)
        town[i][i]=0;
}

void sol(){
    for(int k=0;k<n;k++)
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                town[i][j]=min(town[i][j],town[i][k]+town[k][j]);
    int t;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            t= (town[i][j]<INF) ? town[i][j] : 0;
            cout<< t<<" ";
        }
        cout<<"\n";
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    input();
    sol();
}
                
    