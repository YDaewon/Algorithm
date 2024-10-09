#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n,ans=1;
    int dp[1001],seq[1001];
    cin>>n;
    for(int i=1;i<=n;i++) cin>>seq[i];
    for(int i=1;i<=n;i++){
        int m=0;
        for(int j=1;j<i;j++){
            if(seq[j]<seq[i])
                m=max(m,dp[j]);
        }
        dp[i]=m+1;
        ans=max(ans,dp[i]);
    }
    cout << ans;
}
         