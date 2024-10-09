#include <iostream>
#include <algorithm>
#include <cstring>
#define INF 2147483647
using namespace std;

int n;
pair<int,int> m[501];
int dp[501][501];

int mul(int s, int k, int e){
    return m[s].first * m[k].second * m[e].second;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin>>n;
    memset(dp,0,sizeof(dp));
    for(int i = 1; i<=n;i++)
        cin>> m[i].first >> m[i].second;
    for(int i = 1; i<n;i++){
        for(int j=1;j+i<=n;j++){
            dp[j][i+j]=INF;
            for(int k = j;k<i+j;k++){
                dp[j][i+j]=min(dp[j][i+j], dp[j][k] + dp[k+1][i+j]+mul(j,k,i+j));
            }
        }
    }
    cout << dp[1][n];
}