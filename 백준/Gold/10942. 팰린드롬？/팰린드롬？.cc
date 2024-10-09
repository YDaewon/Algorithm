#include <iostream>
#include <cstring>
using namespace std;

int n,m;
int num[2001];
bool dp[2001][2001]={false, };

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    cin>>n;
    for(int i=1;i<=n;i++) {
        cin>>num[i];
        dp[i][i]=1;
        if(i!=1&&num[i-1]==num[i]) dp[i-1][i]=1;
    }
    for(int i=n-1;i>0;i--)
        for(int j=i+2;j<=n;j++)
            if(num[i]==num[j]&&dp[i+1][j-1]==1) dp[i][j]=1;
    cin>>m;
    int f,s;
    while(m--){
        cin>>f>>s;
        cout<<dp[f][s]<<"\n";
    }
}