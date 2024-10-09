#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int t,n;
    cin>>t;
    while(t--){
        cin>>n;
        int skr[2][100001];
        int dp[2][100001];
        for(int i = 0;i<2;i++){
            for(int j = 0;j<n;j++){
                cin>>skr[i][j];
            }
        }
        dp[0][0]=skr[0][0];
        dp[1][0]=skr[1][0];
        dp[0][1]=skr[0][1]+dp[1][0];
        dp[1][1]=skr[1][1]+dp[0][0];
        for(int i = 2;i<n;i++){
            dp[0][i]=skr[0][i]+max(dp[1][i-1],dp[1][i-2]);
            dp[1][i]=skr[1][i]+max(dp[0][i-1],dp[0][i-2]);
        }
        cout<<max(dp[0][n-1],dp[1][n-1])<<endl;
    }
}