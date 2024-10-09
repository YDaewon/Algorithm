#include <iostream>
#include <algorithm>
using namespace std;

int n,m;
int mc = 0;
pair<int,int> app[101];
int dp[10001];

void input(){
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        cin>> app[i].first;
    }
    for(int i = 1;i<=n;i++){
        cin>>app[i].second;
        mc+=app[i].second;
    }
}

void sol(){
    for(int i=1;i<=n;i++){
        for(int j=mc;j>=0;j--){
            if(j>=app[i].second) 
                dp[j]=max(dp[j],dp[j-app[i].second]+app[i].first);
        }
    }
    int c=0;
    while(dp[c]<m) c++;
    cout << c;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}